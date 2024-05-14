package Gioco;

public class Messaggio {
    
    private Giocatore giocatore;
    private String testo;

    public Messaggio(Giocatore giocatore, String testo) {
        this.giocatore = giocatore;
        this.testo = testo;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public String getTesto() {
        return testo;
    }
}
