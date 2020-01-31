/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import View.Save_New_View;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JoseGuerra
 */
public class Controller_Save {

    Save_New_View view;
    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;
    String ruta_archivo;
    FileInputStream fileInputStream;
    int longitudByte;
    File archivo;

    public Controller_Save(Save_New_View view) {
        this.view = view;
        init();
    }

    public void init() {
        view.setTitle("SignText - Gif configuration");
        view.setLocationRelativeTo(null);
        bindUIListeners();
        view.btn_guardar.setEnabled(false);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(view.getClass().getResource("/img/icono.png")));
        view.setVisible(true);
        view.getContentPane().setBackground(Color.WHITE);
    }

    private void bindUIListeners() {
        /*Boton Guardar Listener*/
        view.btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo, descrp, ruta;

                tipo = view.txt_tipo.getText();
                descrp = view.txt_desc.getText();
                ruta = ruta_archivo;
                if (tipo.isEmpty() || descrp.isEmpty() || ruta.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor ingrese los datos");
                } else {
                    try {
                        String sql = "INSERT INTO public.palabras VALUES ('" + tipo + "','" + descrp + "','" + tipo + ".gif' );";
                        view.txt_tipo.setText("");
                        view.txt_desc.setText("");
                        view.label_gif.setVisible(false);
                        File destino = new File(System.getProperty("user.dir") + "\\gifs\\palabras\\" + tipo + ".gif");
                        Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        c.Ejecutar(sql);
                        JOptionPane.showMessageDialog(view, "The Gif has been saved");
                        //view.dispose();
                        archivo = null;
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "The file could not be saved: " + ex.toString());
                    }

                }
            }
        });
        /*Boton Bucar Listener*/
        view.btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon foto1;
                JFileChooser j = new JFileChooser();
                FileNameExtensionFilter fi = new FileNameExtensionFilter("gif", "gif");
                j.setFileFilter(fi);
                int se = j.showOpenDialog(view);
                view.label_gif.setVisible(true);
                if (se == JFileChooser.APPROVE_OPTION) {
                    try {
                        archivo = j.getSelectedFile();
                        ruta_archivo = archivo.getAbsolutePath();
                        fileInputStream = new FileInputStream(archivo);
                        longitudByte = (int) archivo.length();
                        foto1 = new ImageIcon(ruta_archivo);
                        Icon Icono1 = new ImageIcon(foto1.getImage().getScaledInstance(view.label_gif.getWidth(), view.label_gif.getHeight(), Image.SCALE_DEFAULT));
                        view.label_gif.setIcon(Icono1);
                        view.label_gif.setVisible(true);
                        view.btn_guardar.setEnabled(true);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Controller_Save.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(view.label_gif, "Gif not entered");
                }
            }
        });
        /*Boton Cancelar Listener*/
        view.btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }
}
