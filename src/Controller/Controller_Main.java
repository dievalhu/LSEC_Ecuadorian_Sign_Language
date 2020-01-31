/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import View.Database_New_View;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Lexer;
import model.Token;
import View.New_Interface;
import View.Save_New_View;
import View.Timers_New_View;
import View.Update_New_View;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author JoseGuerra
 */
public class Controller_Main extends Thread {

    public New_Interface view;
    public Lexer lexer;

    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;
    String ruta_archivo;
    public static int segundosPalabras = 2, segundosLetras = 1;
    int contador = 0;
    Timer timerPalabras, timerDeletreo;
    TimerTask tareaPalabras, tareaDeletreo;
    //Controller_Timer controller_Timer = new Controller_Timer(new Timers_View());
    File archivoPalabras = new File(System.getProperty("user.dir") + "\\timerPalabras.conf");
    File archivoDeletreo = new File(System.getProperty("user.dir") + "\\timerDeletreo.conf");

    public Controller_Main(New_Interface view, Lexer lexer) {
        this.view = view;
        this.lexer = lexer;
        init();
    }

    public void init() {
        view.setTitle("SignText");
        view.setLocationRelativeTo(null);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage(view.getClass().getResource("/img/icono.png")));
        view.btn_stop.setVisible(false);
        bindUIListeners();
        view.setVisible(true);
        asignarValores();
    }

    private void bindUIListeners() {

        /*Translate listener*/
        view.btn_translate.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!view.text.getText().isEmpty()) {
                    imprimirGifts();
                } else {
                    JOptionPane.showMessageDialog(view, "Please, enter the text to translate");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        /*Menu gift listener*/
        view.menuGuardarGift.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller_Save controller_Guardar = new Controller_Save(new Save_New_View());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setMenuPressedColor(view.menuGuardarGift);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMenuColor(view.menuGuardarGift);
            }
        });
        /*Menu actualizar gibt listener*/
        view.menuActualizarGift.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller_Update controller_Update = new Controller_Update(new Update_New_View());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setMenuPressedColor(view.menuActualizarGift);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMenuColor(view.menuActualizarGift);
            }
        });
        /*Menu configuracion timer listener*/
        view.menuTimers.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller_Timer controller_Timer = new Controller_Timer(new Timers_New_View());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setMenuPressedColor(view.menuTimers);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMenuColor(view.menuTimers);
            }
        });
        /*Menu configuracion dbconfiguration listener*/
        view.menuDbconfig.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller_DB controller_DB = new Controller_DB(new Database_New_View());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setMenuPressedColor(view.menuDbconfig);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMenuColor(view.menuDbconfig);
            }
        });

        /*Boton stop listener*/
        view.btn_stop.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    timerPalabras.cancel();
                    timerDeletreo.cancel();
                    view.labelGifts.setIcon(null);
                    view.btn_stop.setVisible(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    private void setMenuPressedColor(JPanel jpanel) {
        jpanel.setBackground(new Color(85, 65, 118));
    }

    private void resetMenuColor(JPanel jpanel) {
        jpanel.setBackground(new Color(64, 43, 100));
    }

    private void resetMenuColors() {
        resetMenuColor(view.menuActualizarGift);
        resetMenuColor(view.menuGuardarGift);
        resetMenuColor(view.menuTimers);
        resetMenuColor(view.menuDbconfig);

    }
    public void imprimirGifts() {
        try {
            c = new Conexion();
            view.btn_stop.setVisible(true);
            asignarValores();
            String frase = view.text.getText().toLowerCase();
            lexer = new Lexer(frase);
            lexer.lexerAnalizer();
            timerPalabras = new Timer();
            tareaPalabras = new TimerTask() {
                @Override
                public void run() {
                    try {
                        
                        String ruta;
                        Token token = lexer.getTokens().get(contador);
                        contador++;
                        ImageIcon foto1;
                        String sql = "SELECT gif FROM public.palabras where palabra='" + token.getValor() + "';";
                        rs = c.Consulta(sql);
                        boolean deletrear = true;
                        while (rs.next()) {
                            ruta = System.getProperty("user.dir") + "\\gifs\\palabras\\" + rs.getString(1);
                            deletrear = false;
                            if (!deletrear) {
                                foto1 = new ImageIcon(ruta);
                                Icon Icono1 = new ImageIcon(foto1.getImage().getScaledInstance(view.labelGifts.getWidth(), view.labelGifts.getHeight(), Image.SCALE_DEFAULT));
                                view.labelGifts.setIcon(Icono1);
                                view.labelGifts.setVisible(true);
                            }
                        }
                        
                        if(deletrear){
                            deletrear(token.getValor());
                        }
                    } catch (Exception e) {
                        contador = 0;
                        view.labelGifts.setIcon(null);
                        timerPalabras.cancel();
                    }

                }
            };
            timerPalabras.scheduleAtFixedRate(tareaPalabras, 0, segundosPalabras * 1000);
            //view.btn_stop.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please, do not enter special characters as '.', ',','ñ','á', etc");
            view.btn_stop.setVisible(false);
        }
    }

    public void deletrear(String palabra) {
        try {
            timerPalabras.cancel();
            final char arreglo_caracteres[] = palabra.toLowerCase().toCharArray();
            timerDeletreo = new Timer();
            tareaDeletreo = new TimerTask() {
                int cont = 0;

                @Override
                public void run() {
                    try {
                        char caracter = arreglo_caracteres[cont];
                        String ruta;
                        cont++;
                        ImageIcon foto1;
                        String sql = "SELECT gif FROM public.caracteres where caracter='" + caracter + "';";
                        rs = c.Consulta(sql);
                        while (rs.next()) {
                            ruta = System.getProperty("user.dir") + "\\gifs\\caracteres\\" + rs.getString(1).toLowerCase();
                            foto1 = new ImageIcon(ruta);
                            Icon Icono1 = new ImageIcon(foto1.getImage().getScaledInstance(view.labelGifts.getWidth(), view.labelGifts.getHeight(), Image.SCALE_DEFAULT));
                            view.labelGifts.setIcon(Icono1);
                            view.labelGifts.setVisible(true);
                        }
                    } catch (Exception e) {
                        view.labelGifts.setIcon(null);
                        timerDeletreo.cancel();
                        imprimirGifts();
                    }
                }
            };
            timerDeletreo.scheduleAtFixedRate(tareaDeletreo, 0, segundosLetras * 1000);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha finalizado " + e.getMessage());
        }
    }

    public void asignarValores() {
        try {
            if (!archivoPalabras.exists()) {
                archivoPalabras.createNewFile();
                guardarTXT(archivoPalabras, "1");
            }
            if (!archivoDeletreo.exists()) {
                archivoDeletreo.createNewFile();
                guardarTXT(archivoDeletreo, "1");
            }

            segundosPalabras = Integer.parseInt(leerTXT(archivoPalabras));
            segundosLetras = Integer.parseInt(leerTXT(archivoDeletreo));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }

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
            JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage());
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

}
