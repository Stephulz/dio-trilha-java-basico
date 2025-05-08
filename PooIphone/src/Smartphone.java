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
}
