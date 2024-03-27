package Gioco;

import java.util.ArrayList;

public class Squadra {
    private ArrayList<Giocatore> squadra;
    private ArrayList<Carta> CarteVinte;

    public Squadra(Giocatore g1) {
        this.squadra.add(g1);
    }
    public Squadra(Giocatore g1, Giocatore g2) {
        this.squadra.add(g1);
        this.squadra.add(g2);
    }
    public Squadra(Giocatore g1, Giocatore g2 , Giocatore g3) {
        this.squadra.add(g1);
        this.squadra.add(g2);
        this.squadra.add(g3);
    }

    public void PrendiBanco(ArrayList<Carta> Banco){
        CarteVinte.addAll(Banco);
    }
    public int CalcoloPunti(){
        int totPunti = 0;
        for (Carta c: CarteVinte){
            totPunti += c.getPunti();
            //inserire qui eventuale roba per animazione graduale figa del callcolo dei punti
        }
        return totPunti;
    }
    public void AddToSquadra(Giocatore g) {
        squadra.add(g);
    }
}
