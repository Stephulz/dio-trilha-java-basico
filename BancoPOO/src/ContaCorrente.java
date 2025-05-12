public class ContaCorrente extends Conta {

    public ContaCorrente(String numero, String titular) {
        super(numero, titular);
    }

    public void transferencia(Conta conta, float valor) {
        if (valor > this.getSaldo()) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        this.sacar(valor);
        conta.depositar(valor);
        System.out.println("Transferindo para conta: " + conta.getNumero() + " valor: " + valor + " de " + this.getNumero());
    }

}
