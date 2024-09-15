
package com.mycompany.vocalesletras;

import java.util.*;

public class Vocalesletras {

    // Método para obtener el carácter que más veces se repite
    public static char obtenerCaracterMasRepetido(String linea) {
        Map<Character, Integer> frecuencia = new HashMap<>();
        
        // Contamos la frecuencia de cada carácter en la línea
        for (char c : linea.toCharArray()) {
            frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
        }
        
        // Buscamos el carácter con la mayor frecuencia
        char caracterMasRepetido = linea.charAt(0);
        int maxFrecuencia = 0;
        
        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                caracterMasRepetido = entry.getKey();
            }
        }
        
        return caracterMasRepetido;
    }

  
    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Leer la línea de caracteres
        System.out.println("Ingresa una linea de caracteres: ");
        String linea = scanner.nextLine();
        
        // Obtener el carácter que más se repite
        char caracterMasRepetido = obtenerCaracterMasRepetido(linea);        
        // Mostrar el resultado
        System.out.println("Caracter mas repetido: " + caracterMasRepetido);
    }
}
