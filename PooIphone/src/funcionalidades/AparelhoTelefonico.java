package funcionalidades;

public interface AparelhoTelefonico {
    default void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    default void atender() {
        System.out.println("Atendendo ligação");
    }

    default void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }
}
