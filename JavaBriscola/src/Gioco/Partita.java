package Gioco;
import java.util.ArrayList;

public abstract class Partita {
    
    private Mazzo mazzo1; //mazzo della partita
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: bà
    private int nPlayer;
    
    private ArrayList<Squadra> squadre;

    /*dovremmo far arrivare al costruttore anche una lista di giocatori gia formata, fatta di nome in modo 
    * da associarli ad una squadra*/
    
    
    
    public Partita(int tipoPartita) {
       this.tipoPartita = tipoPartita;
       mazzo1 = new Mazzo();
       
       switch (tipoPartita) {
           case 0:
               nPlayer = 2;
               break;
           case 1:
               nPlayer = 4;
               break;
           case 2:
           case 3:
               nPlayer = 3;
               break;
           case 4:
               nPlayer = 5;
               break;
       }
       
   }

    public int getTipoPartita() {
        return tipoPartita;
    }

    public void setTipoPartita(int tipoPartita) {
        this.tipoPartita = tipoPartita;
    }

    public int getnPlayer() {
        return nPlayer;
    }

    public void setnPlayer(int nPlayer) {
        this.nPlayer = nPlayer;
    }

    public Mazzo getMazzo1() {
        return mazzo1;
    }

    public void setMazzo1(Mazzo mazzo1) {
        this.mazzo1 = mazzo1;
    }
}
