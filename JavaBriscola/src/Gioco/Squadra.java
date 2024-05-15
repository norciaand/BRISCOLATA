package Gioco;

import Esperienza.Lingua;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;

public class Squadra {
    
    private ArrayList<Entita> giocatores;
    private ArrayList<Carta> carteVinte;
    private String nome;
    private Color colore;

    public Squadra(String nome, Color colore) {
        this.nome = nome;
        this.colore = colore;
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
        giocatores.add(new Giocatore(gName + " - " + Lingua.getStringhe(17) + " " + nome,this, partita));
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

    public Color getColore() {
        return colore;
    }
}
