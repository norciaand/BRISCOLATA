package Game;

import Experience.Lingua;

import java.awt.*;
import java.util.ArrayList;

public class Squadra {
    
    private final ArrayList<Entita> giocatori;
    private ArrayList<Carta> carteVinte;
    private final String nome;
    private final Color colore;

    public Squadra(String nome, Color colore) {
        this.nome = nome;
        this.colore = colore;
        giocatori = new ArrayList<>();
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
    
    public void aggiungiNuovoGiocatore(String gName, Partita partita, int indiceGiocatore) {
        
        if (Lingua.getLang() == 0){
            giocatori.add(new Giocatore(gName + " - " + nome + " " + Lingua.getStringhe(17)  ,this, partita, indiceGiocatore));
        } else {
            giocatori.add(new Giocatore(gName + " - " + Lingua.getStringhe(17) + " " + nome,this, partita, indiceGiocatore));
        }
                
    }
    
    public void aggiungiNuovoBot(Partita partita, int difficolta) {
        giocatori.add(new Bot("BOT - Squadra " + nome, this, partita, difficolta));
    }

    public ArrayList<Entita> getGiocatori() {
        return giocatori;
    }

    public ArrayList<Carta> getCarteVinte() {
        return carteVinte;
    }

    public Color getColore() {
        return colore;
    }
    
    public void setCarteVinte (ArrayList<Carta> carteVinte) {
        this.carteVinte = carteVinte;
    }
}
