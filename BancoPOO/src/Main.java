public class Main {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("001", "Jose");
        ContaCorrente conta2 = new ContaCorrente("002", "Arthur");
        ContaPoupanca contaPoupanca = new ContaPoupanca("001-1", "Jose");

        conta1.depositar(10);
        conta1.transferencia(conta2, 5);
        conta1.consultarSaldo();

        conta2.sacar(2);
        conta2.transferencia(contaPoupanca, 6);

        contaPoupanca.depositar(1);
        contaPoupanca.rendimento();
    }
}
