package Gioco;

import java.util.ArrayList;

public class Partita {
    private Mazzo mazzo;
    private int nPlayer; //NUMERO DI GIOCATORI DELLA PARTITA
    private int nSquadre; //NUMERO DI SQUADRE
    private ArrayList<Squadra> squadre;

    public Partita(int nPlayer) {
        this.nPlayer = nPlayer;
        
        if (this.nPlayer%2==0) {
            nSquadre = 2;
        }
        else if (this.nPlayer == 3) {
            nSquadre = 3;
        }

        squadre = new ArrayList<>();
        
        for (int i = 0; i < nSquadre; i++) {
            squadre.add(new Squadra());
        }
        
        
    }
}
