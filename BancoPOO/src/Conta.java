public class Conta {
    private final String numero;
    private final String titular;
    private float saldo;

    public void depositar(float valor) {
        this.saldo = saldo + valor;
        System.out.println("Depositando: " + valor + " para " + this.getNumero());
    }

    public void sacar(float valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        this.saldo = saldo - valor;
        System.out.println("Sacando: " + valor + " de " + this.getNumero());
    }

    public void consultarSaldo() {
        System.out.println("Saldo: " + saldo + " de " + this.getNumero());
    }

    public float getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Conta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }
}
