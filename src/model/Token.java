package model;


public class Token {

    private Tipos tipo;
    private String valor;
    
    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "(" + tipo + ": " + valor + ")"; //To change body of generated methods, choose Tools | Templates.
    }

    
    

    enum Tipos {
        DIGITO ("[0-9]*"),
        LETRA("[a-zA-Záéíóúñ]*"),
        PALABRA("[a-zA-Z0-9áéíóúñ]*");

        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }

}