import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaTerminal contaTerminal = new ContaTerminal();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o número da conta !");
        contaTerminal.setNumero(scanner.nextInt());
        System.out.println("Por favor, digite o número da agência !");
        contaTerminal.setAgencia(scanner.next());
        System.out.println("Por favor, digite o nome do cliente !");
        contaTerminal.setNomeCliente(scanner.next());
        System.out.println("Por favor, digite o saldo !");
        contaTerminal.setSaldo(scanner.nextBigDecimal());
        scanner.close();
        System.out.println("Olá " + contaTerminal.getNomeCliente() +
                " obrigado por criar uma conta em nosso banco, sua agência é " + contaTerminal.getAgencia() +
                ", conta " + contaTerminal.getNumero() + " e seu saldo " + contaTerminal.getSaldo() +
                " já está disponível para saque");
    }
}