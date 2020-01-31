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
public class Q2 {
    
    private boolean isValidQ0;
    private boolean isValidQ1;
    private boolean isValid;

    public Q2() {
    }

    public Q2(boolean isValidQ0, boolean isValidQ1) {
        this.isValidQ0 = isValidQ0;
        this.isValidQ1 = isValidQ1;
        analizeQ2();
    }

    public void analizeQ2(){
        isValid = isValidQ0 && isValidQ1;
    }

    public boolean isIsValidQ0() {
        return isValidQ0;
    }

    public void setIsValidQ0(boolean isValidQ0) {
        this.isValidQ0 = isValidQ0;
    }

    public boolean isIsValidQ1() {
        return isValidQ1;
    }

    public void setIsValidQ1(boolean isValidQ1) {
        this.isValidQ1 = isValidQ1;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
   
    
    
    
    
    
}
