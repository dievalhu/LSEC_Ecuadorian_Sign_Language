/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Database_New_View;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseGuerra
 */
public class Controller_DB {

    Database_New_View view;
    File user = new File(System.getProperty("user.dir") + "\\dbconfig\\user.conf");
    File pwd = new File(System.getProperty("user.dir") + "\\dbconfig\\pwd.conf");
    File db = new File(System.getProperty("user.dir") + "\\dbconfig\\dbname.conf");

    public Controller_DB(Database_New_View view) {
        this.view = view;
        init();
        asignarValores();
    }

    public void init() {
        view.setTitle("SignText - Database configuration");
        view.setLocationRelativeTo(null);
        bindUIListeners();
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(view.getClass().getResource("/img/icono.png")));
        view.setVisible(true);
        view.getContentPane().setBackground(Color.WHITE);
        asignarValores();
    }

    public void bindUIListeners() {
        view.btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.txt_username.getText();
                String password = view.txt_password.getText();
                String dbname = view.txt_dbname.getText();
                if (!username.isEmpty() || !password.isEmpty() || !dbname.isEmpty()) {
                    guardarTXT(user, username);
                    guardarTXT(pwd, password);
                    guardarTXT(db, dbname);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Please, complete all the database configuration");
                }
            }
        });
    }

    public void guardarTXT(File archivo, String parametros) {
        FileWriter writer = null;
        BufferedWriter bf = null;
        try {
            writer = new FileWriter(archivo, false);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            bf = new BufferedWriter(writer);
            bf.write(parametros);
            bf.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error while savig data: "+e.getMessage());
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "The file could no be saved");
                }
            }
        }
    }

    public String leerTXT(File archivo) {
        String linea = "", acum = "";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            do {
                linea = br.readLine();
                if (linea != null) {
                    acum += linea;
                }
            } while (linea != null);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The file could not be found " + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        if (br != null) {
            try {
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "The file could not be closed");
            }
        }
        return acum;
    }

    public void asignarValores() {

        try {
            if (!user.exists()) {
                user.createNewFile();
                guardarTXT(user, "postgres");
            }
            if (!pwd.exists()) {
                pwd.createNewFile();
                guardarTXT(pwd, "Set your server password here");
            }
            if (!db.exists()) {
                db.createNewFile();
                guardarTXT(db, "Set your database name here");
            }
            view.txt_username.setText(leerTXT(user));
            view.txt_password.setText(leerTXT(pwd));
            view.txt_dbname.setText(leerTXT(db));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to perform database configuration \nSet the files in " + System.getProperty("user.dir"));
        }

    }
}
