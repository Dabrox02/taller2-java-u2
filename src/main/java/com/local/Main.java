package com.local;

public class Main {
    public static void main(String[] args) {
        System.out.println(cifradoCesar("holaZ_*&", 1));
    }

    static String cifradoCesar(String cadena, int desplazamiento) {
        char[] letras = cadena.toCharArray();
        desplazamiento = desplazamiento % 26; 
        for (int i = 0; i < letras.length; i++) {
            if(letras[i]  >= 'a' && letras[i] <= 'z'){
                if (letras[i] + desplazamiento > 'z') {
                    letras[i] = (char) (letras[i] + (desplazamiento - 26));
                }else{
                    letras[i] = (char) (letras[i] + (desplazamiento));
                }
            } else if(letras[i]  >= 'A' && letras[i] <= 'Z'){
                if (letras[i] + desplazamiento > 'Z') {
                    letras[i] = (char) (letras[i] + (desplazamiento - 26));
                }else{
                    letras[i] = (char) (letras[i] + (desplazamiento));
                }
            }
        }
        return String.valueOf(letras);
    }
}