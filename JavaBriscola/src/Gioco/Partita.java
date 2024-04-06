package Gioco;

import java.util.ArrayList;

public abstract class Partita {
    private Mazzo mazzo1;
    private int nPlayer; //NUMERO DI GIOCATORI DELLA PARTITA
    private int nSquadre; //NUMERO DI SQUADRE
    private ArrayList<Squadra> squadre;

    public Partita(int nPlayer, String modalita) {
        mazzo1 = new Mazzo();
        
        this.nPlayer = nPlayer;
        squadre = new ArrayList<>();

        /*if (this.nPlayer%2==0)
            nSquadre = 2;
        else if (this.nPlayer == 3)
            nSquadre = 3;*/

        switch (modalita) {
            case "1v1" -> {
                squadre.add(new Squadra())
            }
            case "2v2" -> {

            }
            case "1v1v1" -> {

            }
            case "bastarda" -> {

            }
            case "a5" -> {

            }
        }
        
        
        
        
        
    }
}
