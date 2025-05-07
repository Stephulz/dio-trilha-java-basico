import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        final int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        final int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }

    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        final int contagem = parametroDois - parametroUm;

        for (int a = 1; a <= contagem; a++) {
            System.out.println("Imprimindo o número " + a);
        }
    }
}