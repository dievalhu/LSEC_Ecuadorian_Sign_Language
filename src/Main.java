
import Controller.Controller_Main;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Lexer;
import View.New_Interface;
import javax.swing.plaf.ColorUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JoseGuerra
 */
public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
            UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
            UIManager.put("OptionPane.font", new ColorUIResource(54, 33, 89));
            UIManager.put("OptionPane.font", new ColorUIResource(54, 33, 89));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Look and fell error: " + e.getMessage());
        }
        New_Interface view = new New_Interface();
        Lexer lexer = new Lexer();
        Controller_Main controller = new Controller_Main(view, lexer);

    }
}
