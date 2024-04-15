package Gioco;

public class CartaBot extends Carta{

    private boolean briscola;
    private boolean liscio;
    private int giocabilita = 0;

    public CartaBot(int seme, int numero) {
        super(seme, numero);
    }

    public boolean isBriscola() {
        return briscola;
    }

    public void setBriscola(boolean briscola) {
        this.briscola = briscola;
    }

    public boolean isLiscio() {
        return liscio;
    }

    public void setLiscio(boolean liscio) {
        this.liscio = liscio;
    }

    public int getGiocabilita() {
        return giocabilita;
    }

    public void setGiocabilita(int giocabilita) {
        this.giocabilita += giocabilita;
    }
}
