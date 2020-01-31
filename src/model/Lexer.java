package model;

import java.io.Console;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Token.Tipos;

public class Lexer {

    String textToTranslate;
    Q0 q0;
    Q1 q1;
    Q2 q2;
    ArrayList<Token> tokens;

    public Lexer(String textToTranslate) {
        this.textToTranslate = textToTranslate;
        tokens = new ArrayList<Token>();
    }

    public Lexer() {
    }

    public String getTextToTranslate() {
        return textToTranslate;
    }

    public void setTextToTranslate(String textToTranslate) {
        this.textToTranslate = textToTranslate;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public void lexerAnalizer() throws Exception {
        long startTime = System.currentTimeMillis();
        char characters[] = (textToTranslate + " ").toCharArray();
        String wordAcum = "";
        for (int i = 0; i < characters.length; i++) {
            if (i == 0) {
                q0 = new Q0(characters[i]);
                if (!q0.isIsValid()) {
                    throw new Exception("The text is not admited by the autmaton (Error Q0) for '" + characters[i] + "'");
                }
                wordAcum += Character.toString(characters[i]);
            } else {
                q1 = new Q1(characters[i]);
                if (!q1.isIsValid()) {
                    throw new Exception("The text is not admited by the autmaton (Error Q1) for '" + characters[i] + "'");
                }
                if (q1.getStringInput() != ' ') {
                    wordAcum += Character.toString(characters[i]);
                } else {
                    q2 = new Q2(q0.isIsValid(), q1.isIsValid());
                    if (!q2.isIsValid()) {
                        throw new Exception("The text is not admited by the autmaton (Error Q2) for '" + characters[i] + "'");
                    }
                    lex(wordAcum);
                    wordAcum = "";
                }
            }
        }
        long endTime = System.currentTimeMillis();

    }

    public void execute() {
        Lexer lexer = new Lexer();
        try {
            lexer.lexerAnalizer();
        } catch (Exception ex) {
            Logger.getLogger(Lexer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ArrayList<Token> tokens = lex(input);
    }

    private void lex(String input) {
        boolean matched = false;
        int cont = 0;
        String tkn = "";
        for (Tipos tokenTipo : Tipos.values()) {
            if (input.matches(tokenTipo.patron)) {
                cont++;
                if (cont == 1) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(input);
                    tokens.add(tk);
                    matched = true;
                    tkn = tk.getValor();
                }
            }
        }
        if (!matched) {
            throw new RuntimeException("Se encontró un token invalido.");
        }

    }

    private static ArrayList<Token> lex2(String input) {
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(input);

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if (matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                }
            }

            if (!matched) {
                throw new RuntimeException("Se encontró un token invalido.");
            }
        }

        return tokens;
    }

}
