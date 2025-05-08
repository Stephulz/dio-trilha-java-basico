import funcionalidades.AparelhoTelefonico;
import funcionalidades.NavegadorInternet;
import funcionalidades.ReprodutorMusical;

public class Smartphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    private int percentualBateria;
    private String imei;

    public int getPercentualBateria() {
        return percentualBateria;
    }

    public void setPercentualBateria(int percentualBateria) {
        this.percentualBateria = percentualBateria;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void tocar() {
        System.out.println("Tocando");
    }

    public void pausar() {
        System.out.println("Pausando");
    }

    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música: " + musica);
    }

    public void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    public void atender() {
        System.out.println("Atendendo ligação");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }

    public void exibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }

    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba");
    }

    public void atualizarPagina() {
        System.out.println("Atualizando página");
    }
}
