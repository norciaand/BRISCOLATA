package Game;

public class CartaBot extends Carta{

    //COSTRUTTORE
    private boolean briscola;
    private boolean liscio;
    private boolean win;
    private int giocabilita;

    private int nCarPred = 0;

    public CartaBot(int seme, int numero) {
        super(seme, numero);
        briscola = false;
        liscio = false;
        win = false;
        giocabilita = 0;
        
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

    public int getnCarPred() {
        return nCarPred;
    }

    public void setnCarPred(int nCarPred) {
        this.nCarPred = nCarPred;
    }

}
