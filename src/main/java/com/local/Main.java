package com.local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(cifradoCesar("holaZ_*&", 1));
        System.out.println(romanoAEntero("IV"));
        System.out.println(emailValido("jaiderstyven@gmail.com"));
        System.out.println(convertirFechaUnix("12/10/2023"));
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