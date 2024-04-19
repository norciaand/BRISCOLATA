package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    private ArrayList<Carta> deck = new ArrayList<>();

    public ArrayList<Carta> getDeck() {
        return deck;
    }

    public static final int SEMI = 4;
    public static final int DECK = 10;

    public static final String[] rankOriginali = {"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re"};
    public static final String[] semiOriginali = {"Denari", "Spade", "Coppe","Bastoni"};

    public Mazzo() {
        riempi();
    }

    private void riempi() {
        deck.clear();
        for (int i = 0; i < SEMI; i++)
        {
            for (int j = 0; j < DECK; j++)
            {
                deck.add(new Carta(i, j));
            }
        }
    }

    public void mischia() {
        Collections.shuffle(deck);
    }

    public int semeBriscola()
    {
        return deck.getFirst().getSeme();
    }

    public String semeBriscolaToString()
    {
        return semiOriginali[semeBriscola()];
    }

    public Carta pesca(){          //ESTRAE E RIMUOVE LA CARTA
        Carta x = deck.getLast();
        deck.removeLast();
        return x;
    }
    public int getSize(){
        return deck.size();
    }

    public int nSeme(int seme){
        int count = 0;
        for(Carta c : this.deck){
            if(c.getSeme() == seme)
                count++;
        }
        return count;
    }

}