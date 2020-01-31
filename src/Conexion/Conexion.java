package Conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dei
 */
public class Conexion {

    private Statement St;
    private String driver;
    private String user;
    private String pwd;
    private String cadena;
    private Connection con;

    public String getDriver() {
        return this.driver;
    }

    String getUser() {
        return this.user;
    }

    String getPwd() {
        return this.pwd;
    }

    String getCadena() {
        return this.cadena;
    }

    public Connection getConexion() {
        return this.con;
    }

    public Conexion() {

        File user = new File(System.getProperty("user.dir") + "\\dbconfig\\user.conf");
        File pwd = new File(System.getProperty("user.dir") + "\\dbconfig\\pwd.conf");
        File db = new File(System.getProperty("user.dir") + "\\dbconfig\\dbname.conf");

        try {
            if (!user.exists()) {
            user.createNewFile();
                guardarTXT(user, "postgres");
        }
        if (!pwd.exists()) {
            pwd.createNewFile();
            guardarTXT(pwd, "sa.1");
        }
        if (!db.exists()) {
            db.createNewFile();
            guardarTXT(db, "DB_SignText");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la configuración de la base de datos\nConfigure los archivos en "+System.getProperty("user.dir")+"\n"+e.getLocalizedMessage()+" "+e.toString()+" "+e.getMessage());
        }

        this.driver = "org.postgresql.Driver";
        this.user = leerTXT(user);
        this.pwd = leerTXT(pwd);
        this.cadena = "jdbc:postgresql://localhost:5432/" + leerTXT(db);
        this.con = this.crearConexion();

    }

    Connection crearConexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        try {
            Class.forName(getDriver()).newInstance();
            Connection con = DriverManager.getConnection(getCadena(), getUser(), getPwd());
            return con;
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null,"Error: " + ee.getMessage()+"\nRealice la configuración en Congifuration\\DB Config");
            return null;
        }
    }

    public String Ejecutar(String sql) {
        String error = "";
        try {
            St = getConexion().createStatement();
            St.execute(sql);
            error = "Datos insertados";
        } catch (Exception ex) {
            error = ex.getMessage();
        }
        return (error);
    }

    public String Eliminar(String sql) {
        String error = "";
        try {
            St = getConexion().createStatement();
            St.execute(sql);
            error = "DATOS ELIMINADOS";
        } catch (Exception ex) {
            error = ex.getMessage();
        }
        return (error);
    }

    public ResultSet Consulta(String sql) {
        String error = "";
        ResultSet reg = null;

        try {
            St = getConexion().createStatement();
            reg = St.executeQuery(sql);

        } catch (Exception ee) {
            error = ee.getMessage();
        }
        return (reg);
    }

    public void guardarTXT(File archivo, String parametros) {
        FileWriter writer = null;
        BufferedWriter bf = null;
        try {
            writer = new FileWriter(archivo, false);
            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo no existe se crea");
                archivo.createNewFile();
            }
            bf = new BufferedWriter(writer);
            bf.write(parametros);
            bf.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo cerrar el archivo");
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
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo " + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        if (br != null) {
            try {
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo cerrar el archivo");
            }
        }
        return acum;
    }

}
