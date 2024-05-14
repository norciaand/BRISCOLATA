package Gioco;

import java.util.ArrayList;

public class Chat {
    private ArrayList<Messaggio> contenuto;

    public Chat() {
        contenuto = new ArrayList<>();
    }
    
    public void scrivi(Giocatore giocatore, String messaggio){
        contenuto.add(new Messaggio(giocatore, messaggio));
    }

    public ArrayList<Messaggio> getContenuto() {
        return contenuto;
    }
}
