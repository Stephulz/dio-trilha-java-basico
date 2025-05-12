public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, String titular) {
        super(numero, titular);
    }

    public void rendimento() {
        System.out.println("Rendimento poupança");
    }
}
