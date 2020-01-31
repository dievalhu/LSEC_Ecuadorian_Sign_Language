/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import View.Update_New_View;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Controller_Update {

    Update_New_View view;

    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;
    String ruta_archivo, palabra;
    String ruta;
    File archivo;

    public Controller_Update(Update_New_View view) {
        this.view = view;
        init();
    }

    public void init() {
        view.setTitle("SignText - Gif Configuration");
        view.setLocationRelativeTo(null);
        bindUIListeners();
        view.btn_buscar.setEnabled(false);
        view.btn_editar.setEnabled(false);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(view.getClass().getResource("/img/icono.png")));
        view.setVisible(true);
        view.getContentPane().setBackground(Color.WHITE);
    }

    private void bindUIListeners() {

        /*Actulizar listener*/
        view.btn_editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descrp = view.txt_desc.getText();

                if (ruta_archivo == null) {
                    ruta_archivo = ruta;
                } else {
                }

                if (descrp.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please enter a description");
                } else {
                    try {
                        String sql = "UPDATE public.palabras 	SET \"descripción\"='" + descrp + "', gif='" + palabra
                                + ".gif'\n WHERE palabra='" + palabra + "';";
                        File destino = new File(System.getProperty("user.dir") + "\\gifs\\palabras\\" + palabra + ".gif");
                        Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        c.Ejecutar(sql);
                        JOptionPane.showMessageDialog(view, "Gif updated succesfully");
                        view.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, "Information has not been updated: " + ex.getMessage());
                    }

                }
            }
        });

        /*Buscar Listener*/
        view.btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon foto1;
                JFileChooser j = new JFileChooser();
                FileNameExtensionFilter fi = new FileNameExtensionFilter("gif", "gif");
                j.setFileFilter(fi);
                int se = j.showOpenDialog(view);
                if (se == JFileChooser.APPROVE_OPTION) {
                    archivo = j.getSelectedFile();
                    ruta_archivo = archivo.getAbsolutePath();

                    foto1 = new ImageIcon(ruta_archivo);
                    Icon Icono1 = new ImageIcon(foto1.getImage().getScaledInstance(view.label_gif.getWidth(), view.label_gif.getHeight(), Image.SCALE_DEFAULT));
                    view.label_gif.setIcon(Icono1);
                    view.label_gif.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(view.label_gif, "Gif not entered");
                }

            }
        });
        /*Cancelar listener*/
        view.btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        /*Combo palabra*/
        view.cbm_palabra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.btn_editar.setEnabled(true);
                palabra = (String) view.cbm_palabra.getSelectedItem();
            }
        });
        /*Editar listener*/
        view.btn_editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.btn_buscar.setEnabled(true);
                view.btn_editar.setEnabled(true);
                view.btn_editar.setEnabled(false);
                ImageIcon foto1;
                try {
                    String sql = " SELECT \"descripción\", gif 	FROM public.palabras where palabra='" + palabra + "';";
                    rs = c.Consulta(sql);
                    rs.next();
                    view.txt_desc.setText(String.valueOf(rs.getObject(1)));
                    ruta = rs.getString(2);
                    foto1 = new ImageIcon(ruta);
                    Icon Icono1 = new ImageIcon(foto1.getImage().getScaledInstance(view.label_gif.getWidth(), view.label_gif.getHeight(), Image.SCALE_DEFAULT));
                    view.label_gif.setIcon(Icono1);
                    view.btn_editar.setEnabled(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Update_New_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        /*Window open listener*/
        view.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                view.cbm_palabra.removeAllItems();
                try {
                    String sql = " SELECT palabra FROM public.palabras;";
                    rs = c.Consulta(sql);
                    while (rs.next()) {
                        view.cbm_palabra.addItem(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Update_New_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

}
