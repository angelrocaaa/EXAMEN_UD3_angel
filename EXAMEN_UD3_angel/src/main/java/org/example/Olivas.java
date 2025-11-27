package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Olivas {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("*** BIENVENIDO AL OLIVÓMETRO ****");
        System.out.println("Introduce el tamaño de tu bancal...");


        System.out.println("Ancho:");
        int ancho = teclado.nextInt();
        System.out.println("Largo:");
        int largo = teclado.nextInt();

        int matriz[][] = new int[largo][ancho];

        System.out.println("Introduce (por hileras) los kg por árbol de tu bancal");

        teclado.nextLine();

        externo:
        for (int i = 0; i < matriz.length; i++) {
            String numeros = teclado.nextLine();
            String filas[] = numeros.split(" ");

            interno:
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Integer.parseInt(filas[j]);
                if (matriz[i][j] > 50 && matriz[i][j] < 1) {
                    System.out.println("ERROR. Número mayor que 50 o menos que 1. Vuelve a introduce la fila");
                    i--;
                    continue externo;
                }
            }

        }

        System.out.println("=============================================");
        System.out.println("MAPA tu bancal actual");

        for (int fila[] : matriz){
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int suma=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }

        System.out.println("Total kg generados " + suma + " kg");
        System.out.println("Litros totales obtenidos: " + (double) (suma/8) + " L");
        System.out.println("Litros por hilera...");

        for (int i = 0; i < matriz.length; i++) {
            suma=0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j] / 8;
            }

            System.out.println("- Hilera " + (i+1) + ": " + (double) suma + " L");
        }

        System.out.println("Olivos más productivos (>35kg:)");

        for (int i = 0; i < matriz.length; i++) {
            suma=0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
                if (suma>35) {
                    System.out.println(" En la posicion " + "(" + i + "," + j + ") " + suma + "kg");
                }
            }
        }

        System.out.println("=============================================");
        System.out.println("Mapa para replantar: ");

        for (int i[] : matriz) {
            for (int sust : i) {
                if (sust<5) {
                    System.out.print("X" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }

        System.out.println("=============================================");
        System.out.println("Mapa estimación después de replantar: ");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 5) {
                    matriz[i][j] = aleatorio.nextInt(21)+15;
                }
            }
        }

        for (int mostrar[] : matriz) {
            for (int num : mostrar) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
