package view;

import controller.Operacoes;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Operacoes op = new Operacoes();
        Scanner scan = new Scanner(System.in);

        System.out.println("Qual a string que será inserida?");
        String inicial = scan.nextLine();

        String invertida = op.inverter(inicial);
        System.out.println(invertida);
        scan.close();
    }
}
