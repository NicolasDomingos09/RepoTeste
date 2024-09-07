package controller;

public class Operacoes {
    public void showPorcentagens() {
        double[] valores = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};
        String[] estados = {"SP","RJ","MG","ES","Outros"};

        double total = 0;
        for(double valor : valores) {
            total += valor;
        }

        for (int i = 0; i < 5; i++) {
            double porcentagem = (valores[i] / total) * 100;
            System.out.print("Representação do valor total do estado " + estados[i] + " ");
            System.out.format("%.2f", porcentagem);
            System.out.print("%\n");

        }

    }
}