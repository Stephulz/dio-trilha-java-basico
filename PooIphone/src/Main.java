public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.ligar("190");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica("009 - Sound System");

        iphone.exibirPagina("https://www.google.com.br");
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}