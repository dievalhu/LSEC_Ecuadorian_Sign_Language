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
public class Q0 {

    private char stringInput;
    private boolean isValid = false;

    public Q0() {
    }

    public Q0(char stringInput) {
        this.stringInput = stringInput;
        analizeQ0();
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

    public void analizeQ0() {
        isValid = Character.toString(stringInput).matches("[a-zA-z0-9áéíóúñ]");
    }

}
