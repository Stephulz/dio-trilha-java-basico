package funcionalidades;

public interface ReprodutorMusical {

    default void tocar() {
        System.out.println("Tocando");
    }

    default void pausar() {
        System.out.println("Pausando");
    }

    default void selecionarMusica(String musica) {
        System.out.println("Selecionando música: " + musica);
    }
}
