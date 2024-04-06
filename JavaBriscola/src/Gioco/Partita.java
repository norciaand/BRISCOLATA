package Gioco;
import java.util.ArrayList;

public abstract class Partita {
    
    private Mazzo mazzo1; //mazzo della partita
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    
    private ArrayList<Squadra> squadre;

   public Partita(int tipoPartita) {
       this.tipoPartita = tipoPartita;
       mazzo1 = new Mazzo();
   }
}
