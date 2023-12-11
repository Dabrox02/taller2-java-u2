package com.local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(cifradoCesar("holaZ_*&", 1));
        System.out.println(romanoAEntero("IgV"));
        System.out.println(emailValido("jaiderstyven@gmail.com") ? "Email valido": "Email Invalido");
        System.out.println(convertirFechaUnix("12/10/2023"));
        charUnion("ab", "cd");
    }

    static void generarCombinaciones(int[] arreglo, int indice) {
        if (indice == arreglo.length - 1) {
            char[] arregloChar = arrayIntChar(arreglo);
            System.out.println(Arrays.toString(arregloChar));
        } else {
            for (int i = indice; i < arreglo.length; i++) {
                int temp = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = temp;
                generarCombinaciones(arreglo, indice + 1);
                temp = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = temp;
            }
        }
    }

    static char[] arrayIntChar(int[] arreglo){
        char[] arrChar = new char[arreglo.length];
        for(int i = 0; i < arreglo.length; i++) {
            arrChar[i] = (char) arreglo[i];
        }
        return arrChar;
    }

    static void charUnion(String cad1, String cad2){
        int[] caracteres = new int[cad1.length() + cad2.length()];
        char[] charcad1 = cad1.toCharArray();
        char[] charcad2 = cad2.toCharArray();
        int i = 0;
        for (i = 0; i < charcad1.length; i++) {
            caracteres[i] = charcad1[i]; 
        }
        for (int j = 0; j < charcad2.length; j++) {
            caracteres[i] = charcad2[j]; 
            i++;
        }
        generarCombinaciones(caracteres, 0);
    }

    static String convertirFechaUnix(String fechaString){
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoEntrada.parse(fechaString);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
            return formatoSalida.format(fecha);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            return null; 
        }
    }

    static boolean emailValido(String email){
        String patronEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(patronEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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