package Gioco;

import java.util.ArrayList;

public class Squadra {
    
    private ArrayList<Entita> giocatores;
    private ArrayList<Carta> carteVinte;
    private String nome;

    public Squadra(String nome) {
        this.nome = nome;
        giocatores = new ArrayList<>();
        carteVinte = new ArrayList<>();
    }

    public void prendiBanco(ArrayList<Carta> Banco) {
        carteVinte.addAll(Banco);
    }
    
    public int calcoloPunti() {
        int totPunti = 0;
        for (Carta c: carteVinte){
            totPunti += c.getPunti();
            //inserire qui eventuale roba per animazione graduale figa del calcolo dei punti, NO
        }
        return totPunti;
    }
    
    public void aggiungiNuovoGiocatore(String gName, Partita partita) {
        giocatores.add(new Giocatore(gName + " - Squadra " + nome,this, partita));
    }
    
    public void aggiungiNuovoBot(Partita partita, int difficolta) {
        giocatores.add(new Bot("BOT - Squadra " + nome, this, partita, difficolta));
    }

    public ArrayList<Entita> getGiocatores() {
        return giocatores;
    }

    public ArrayList<Carta> getCarteVinte() {
        return carteVinte;
    }
}
