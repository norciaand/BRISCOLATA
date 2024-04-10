package Gioco;

import java.util.ArrayList;

public class Squadra {
    
    private ArrayList<Giocatore> giocatores;
    
    private ArrayList<Carta> carteVinte;
    private String nome;

    public Squadra(String nome) {
        this.nome = nome;
        giocatores = new ArrayList<>();
        giocatores.clear();
    }

    public void PrendiBanco(ArrayList<Carta> Banco){
        carteVinte.addAll(Banco);
    }
    
    public int CalcoloPunti(){
        int totPunti = 0;
        for (Carta c: carteVinte){
            totPunti += c.getPunti();
            //inserire qui eventuale roba per animazione graduale figa del callcolo dei punti
        }
        return totPunti;
    }
    
    public void aggiungiNuovoGiocatore(String gName, Partita partita) {
        giocatores.add(new Giocatore(gName + " - Squadra " + nome,this, partita));
    }

    public ArrayList<Giocatore> getGiocatores() {
        return giocatores;
    }

    public String getNomeSquadra() {
        return nome;
    }
}
