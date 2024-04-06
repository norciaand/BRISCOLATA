package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    private ArrayList<Carta> deck = new ArrayList<>();

    public static final int SEMI = 4;
    public static final int DECK = 10;

    public static final String[] rankOriginali = {"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re"};
    public static final String[] semiOriginali = {"Denari", "Spade", "Coppe","Bastoni"};

    public Mazzo() {
        riempi();
        mischia();
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

    private void mischia() {
        Collections.shuffle(deck);
    }

    public int semeBriscola()
    {
        return deck.get(0).getSeme();
    }

    public String semeBriscolaToString()
    {
        return semiOriginali[semeBriscola()];
    }

    public Carta pesca() {          //ESTRAE E RIMUOVE LA CARTA
        Carta x = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return x;
    }
    
}