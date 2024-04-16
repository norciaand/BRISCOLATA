package Gioco;

public class CartaBot extends Carta{

    private boolean briscola = false;
    private boolean liscio = false;
    private boolean win = false;
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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
