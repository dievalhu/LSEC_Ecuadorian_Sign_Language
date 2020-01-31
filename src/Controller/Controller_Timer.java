/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Timers_New_View;
import java.awt.Color;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Toolkit;

/**
 *
 * @author JoseGuerra
 */
public class Controller_Timer {

    public Timers_New_View view;
    File archivoPalabras = new File(System.getProperty("user.dir") + "\\timerPalabras.conf");
    File archivoDeletreo = new File(System.getProperty("user.dir") + "\\timerDeletreo.conf");

    public Controller_Timer(Timers_New_View view) {
        this.view = view;
        init();
    }

    public void init() {
        view.setTitle("SignText - Timers configuration");
        view.setLocationRelativeTo(null);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(view.getClass().getResource("/img/icono.png")));
        view.setVisible(true);
        bindUIListeners();
        asignarValores();
        view.getContentPane().setBackground(Color.WHITE);
    }

    private void bindUIListeners() {
        view.sliderTimerPalabras.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = view.sliderTimerPalabras.getValue();
                guardarTXT(archivoPalabras, String.valueOf(value));
                asignarValores();
            }
        });
        view.sliderTimerLetras.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = view.sliderTimerLetras.getValue();
                guardarTXT(archivoDeletreo, String.valueOf(value));
                asignarValores();
            }
        });
        view.btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
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
            JOptionPane.showMessageDialog(null, "Error while saving data");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "The file could not be closed");
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
            JOptionPane.showMessageDialog(null, "The file could not be closed " + e.getMessage());
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
            if (!archivoPalabras.exists()) {
                archivoPalabras.createNewFile();
                guardarTXT(archivoPalabras, "2");
            }
            if (!archivoDeletreo.exists()) {
                archivoDeletreo.createNewFile();
                guardarTXT(archivoDeletreo, "1");
            }

            view.sliderTimerPalabras.setValue(Integer.parseInt(leerTXT(archivoPalabras)));
            view.sliderTimerLetras.setValue(Integer.parseInt(leerTXT(archivoDeletreo)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
            view.dispose();
        }

    }
}
