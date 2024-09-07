package controller;

public class Fibonacci {

    public Fibonacci() {
        super();
    }

    public void termoFib(int num){
        int valor1 = 0, valor2 = 1, resultado = 0, termo = 0;

        while(resultado < num){
            for(int i = 1; i <= num; i++){
                resultado = valor1 + valor2;
                valor2 = valor1;
                valor1 = resultado;
                termo = i;
                if(resultado == num)
                    break;
            }
            if(resultado == num){
                System.out.println("O número pertece à sequência de fibonacci e é o " + termo + "o. termo");
            }else{
                System.out.println("O número não pertece à sequência de fibonacci");
            }
        }
    }
}
