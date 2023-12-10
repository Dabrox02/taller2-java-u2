package com.local;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(cifradoCesar("holaZ_*&", 1));
        System.out.println(romanoAEntero("IV"));
    
    }

    static int romanoAEntero(String romano){
        Map<Character, Integer> letrasRomanas = new HashMap<>();
        letrasRomanas.put('I', 1);
        letrasRomanas.put('V', 5);
        letrasRomanas.put('X', 10);
        letrasRomanas.put('L', 50);
        letrasRomanas.put('C', 100);
        letrasRomanas.put('D', 500);
        letrasRomanas.put('M', 1000);

        romano = romano.toUpperCase();
        char[] letras = romano.toCharArray();
        int entero = 0;
    
        for (int i = 0; i < letras.length; i++) {
            int valorActual = letrasRomanas.get(letras[i]);
    
            if (i < letras.length - 1 && letrasRomanas.get(letras[i + 1]) > valorActual) {
                entero += letrasRomanas.get(letras[i + 1]) - valorActual;
                i++;
            } else {
                entero += valorActual;
            }
        }
        return entero;
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