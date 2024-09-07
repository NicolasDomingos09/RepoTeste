package view;
import controller.Fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o número a ser procurado na sequência de fibonnaci: ");
        int numero = scan.nextInt();

        Fibonacci fib = new Fibonacci();
        fib.termoFib(numero);
    }

}
