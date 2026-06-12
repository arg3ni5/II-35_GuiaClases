/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) { // Caso base
//            System.out.print("!" + n + "\n");
            return 1;
        } else {
//            System.out.print(n + "! * ");
            System.out.println(n + " * factorial(" + (n - 1)+")");
            return n * factorial(n - 1); // Llamada recursiva
        }
    }
    // 4 * 3 * 2 * 1 * 1
    // 4 * factorial(3) + factorial(2) + factorial(1) + factorial(0)
    // factorial(3) = > 3 * factorial(2) 2 * factorial(1) 1 * factorial(0) 1 => 6
    // factorial(2) 2 * factorial(1) 1 * factorial(0) 1 => 2
    // factorial(1) 1 * factorial(0) 1
    // factorial(0) => 1
    public static void main(String[] args) {
        int number = 4;
        System.out.println("Factorial de " + number + " = " + factorial(number));
    }
}
