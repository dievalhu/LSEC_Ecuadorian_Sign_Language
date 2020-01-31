/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author JoseGuerra
 */
public class Q1 {
    
    private char stringInput;
    private boolean isValid = true;

    public Q1() {
    }

    public Q1(char stringInput) {
        this.stringInput = stringInput;
        analizeQ1();
    }

    public char getStringInput() {
        return stringInput;
    }

    public void setStringInput(char stringInput) {
        this.stringInput = stringInput;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

 public void analizeQ1() {
        isValid = Character.toString(stringInput).matches("[a-zA-Z0-9áéíóúñ ]");
       // JOptionPane.showMessageDialog(null, "is valid q1? " + isValid);
    }   
    
    
    
    
}
