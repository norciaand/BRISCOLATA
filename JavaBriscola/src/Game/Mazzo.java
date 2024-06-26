package Game;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    private final ArrayList<Carta> deck;

    public ArrayList<Carta> getDeck() {
        return deck;
    }

    public static final int SEMI = 4;
    public static final int DECK = 10;

    public static final String[] rankOriginali = {"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re"};
    public static final String[] semiOriginali = {"Denari", "Spade", "Coppe", "Bastoni"};

    public static final String[] rankOriginaliEN = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Jack", "Horse", "King"};
    public static final String[] semiOriginaliEN = {"Money", "Sword", "Cups", "Sticks"};
    
    
    public Mazzo() {
        deck = new ArrayList<>();
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
    

    public Carta pesca(){          //ESTRAE E RIMUOVE LA CARTA
        Carta x = deck.getLast();
        deck.removeLast();
        return x;
    }
    public int getSize(){
        return deck.size();
    }

}