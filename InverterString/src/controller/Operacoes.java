package controller;

public class Operacoes {

    public Operacoes() {
        super();
    }

    public String inverter(String inicial){
        StringBuilder buffer = new StringBuilder();

        char[] letras = inicial.toCharArray();

        int tam = letras.length;
        for(int i = tam-1; i >= 0; i--){
            buffer.append(letras[i]);
        }

        return buffer.toString();
    }
}
