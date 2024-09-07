package com.mycompany.estadisticas;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Estadisticas {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        // Solicitar el tamaño del arreglo
        System.out.print("Ingrese el tamano del arreglo: ");
        int tam = sc.nextInt();
        
        // Crear y llenar el arreglo con números aleatorios
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = rand.nextInt(100); // Rango de 0 a 99
        }
        
        // Mostrar el arreglo
        System.out.println("Arreglo generado: " + Arrays.toString(arr));
        
        // Cálculo de media
        double media = calcularMedia(arr);
        System.out.println("Media: " + media);
        
        // Cálculo de mediana
        double mediana = calcularMediana(arr);
        System.out.println("Mediana: " + mediana);
        
     
    }
    
    // Método para calcular la media
    public static double calcularMedia(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
        return (double) suma / arr.length;
    }
    
    // Método para calcular la mediana
    public static double calcularMediana(int[] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }
      
    
    }
