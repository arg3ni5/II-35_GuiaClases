/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonaccicondetalles;

/**
 *
 * @author fbarg
 */
import java.util.Scanner;

public class FibonacciConDetalles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la posición hasta donde desea imprimir la sucesión de Fibonacci: ");
        int n = scanner.nextInt();

        System.out.println("Sucesión de Fibonacci hasta la posición " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print("fib(" + i + ") = " + fibonacci(i) + " ");
        }
        System.out.println(); // Nueva línea al final
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            System.out.println("fib(" + n + ") = " + n); // Imprimir el caso base
            return n; // Caso base
        }

        // Llamadas recursivas
        int fibNMinus1 = fibonacci(n - 1);
        int fibNMinus2 = fibonacci(n - 2);

        // Mostrar el cálculo
        System.out.println("n=" + n + " | fib(" + (n - 1) + ")=" + fibNMinus1 + " + fib(" + (n - 2) + ")=" + fibNMinus2 + " | " + (fibNMinus1 + fibNMinus2));

        return fibNMinus1 + fibNMinus2; // Caso recursivo
    }
}
