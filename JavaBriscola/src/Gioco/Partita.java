package Gioco;

import java.util.ArrayList;

public abstract class Partita {
    private Mazzo mazzo;
    private int nPlayer; //NUMERO DI GIOCATORI DELLA PARTITA
    private int nSquadre; //NUMERO DI SQUADRE
    private ArrayList<Squadra> squadre;

    public Partita(int nPlayer) {
        this.nPlayer = nPlayer;
        squadre = new ArrayList<>();

        if (this.nPlayer%2==0)
            nSquadre = 2;
        else if (this.nPlayer == 3)
            nSquadre = 3;


        for (int i = 0; i < nSquadre; i++) {
            squadre.add(new Squadra());
        }
    }
}
