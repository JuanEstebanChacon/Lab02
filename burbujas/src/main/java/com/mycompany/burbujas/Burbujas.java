

package com.mycompany.burbujas;



import java.util.Arrays;
import java.util.Random;

public class Burbujas {

    // Método de ordenamiento Burbuja
    public static void burbuja(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método de ordenamiento por Inserción
    public static void insercion(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Método de ordenamiento por Selección
    public static void seleccion(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Método de ordenamiento MergeSort
    public static void mergeSort(double[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            double[] left = Arrays.copyOfRange(arr, 0, mid);
            double[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    private static void merge(double[] arr, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Método para generar un arreglo de números aleatorios
    public static double[] generarArregloAleatorio(int tamano) {
        Random rand = new Random();
        double[] arr = new double[tamano];
        for (int i = 0; i < tamano; i++) {
            arr[i] = rand.nextDouble();
        }
        return arr;
    }

    // Método para copiar un arreglo
    public static double[] copiarArreglo(double[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // Método para medir el tiempo de ejecución
    public static long medirTiempo(Runnable metodoOrdenamiento) {
        long inicio = System.currentTimeMillis();
        metodoOrdenamiento.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }

    public static void main(String[] args) {
        int[] tamanos = {100, 500, 1000, 5000, 10000};

        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Tamaño", "Burbuja", "Insercion", "Seleccion", "MergeSort");

        for (int tamano : tamanos) {
            // Generar un arreglo aleatorio
            double[] original = generarArregloAleatorio(tamano);

            // Copias del arreglo para cada algoritmo
            double[] arregloBurbuja = copiarArreglo(original);
            double[] arregloInsercion = copiarArreglo(original);
            double[] arregloSeleccion = copiarArreglo(original);
            double[] arregloMergeSort = copiarArreglo(original);

            // Medir tiempo de Burbuja
            long tiempoBurbuja = medirTiempo(() -> burbuja(arregloBurbuja));

            // Medir tiempo de Inserción
            long tiempoInsercion = medirTiempo(() -> insercion(arregloInsercion));

            // Medir tiempo de Selección
            long tiempoSeleccion = medirTiempo(() -> seleccion(arregloSeleccion));

            // Medir tiempo de MergeSort
            long tiempoMergeSort = medirTiempo(() -> mergeSort(arregloMergeSort));

            // Mostrar resultados
            System.out.printf("%-10d %-10d %-10d %-10d %-10d\n", tamano, tiempoBurbuja, tiempoInsercion, tiempoSeleccion, tiempoMergeSort);
        }
    }
}

