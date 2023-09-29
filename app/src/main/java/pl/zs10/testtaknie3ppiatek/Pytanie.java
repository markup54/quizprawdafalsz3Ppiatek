package pl.zs10.testtaknie3ppiatek;
public class Pytanie {
    private String trescPytania;
    private boolean odpowiedz;
    private String podpowiedz;
    private int idObrazu;
    private boolean czyOdpowiedzianoPoprawnie;

    public Pytanie(String trescPytania, boolean odpowiedz, String podpowiedz, int idObrazu) {
        this.trescPytania = trescPytania;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        this.idObrazu = idObrazu;
        czyOdpowiedzianoPoprawnie = false;
    }

    public void setCzyOdpowiedzianoPoprawnie(boolean czyOdpowiedzianoPoprawnie) {
        this.czyOdpowiedzianoPoprawnie = czyOdpowiedzianoPoprawnie;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public int getIdObrazu() {
        return idObrazu;
    }

    public boolean isCzyOdpowiedzianoPoprawnie() {
        return czyOdpowiedzianoPoprawnie;
    }
}
