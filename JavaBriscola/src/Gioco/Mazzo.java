package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo extends ArrayList<Carta> {
    private ArrayList<Carta> mazzo = new ArrayList<>();

    public static final int SEMI = 4;
    public static final int DECK = 10;

    public static final String[] rankOriginali = {"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re"};
    public static final String[] semiOriginali = {"Denari", "Spade", "Coppe","Bastoni"};

    private void mischia()
    {
        Collections.shuffle(mazzo);
    }

    public Mazzo()
    {
        riempi();
        mischia();
    }

    private void riempi()
    {
        mazzo.clear();
        for (int i = 0; i < SEMI; i++)
        {
            for (int j = 0; j < DECK; j++)
            {
                mazzo.add(new Carta(i, j));
            }
        }
    }

    public int semeBriscola()
    {
        return mazzo.get(0).getSeme();
    }

    public String semeBriscolaToString()
    {
        return semiOriginali[semeBriscola()];
    }

    public Carta pesca()
    {
        Carta x = mazzo.get(mazzo.size()-1);
        mazzo.remove(mazzo.size()-1);
        return x;
    }

    /*
    @Override
    public String toString() {
        String s = "----------MAZZO---------\n";
        for (Carta x: data)
        {
            s += x.getNome() + "\n";
        }
        s += "------------------------\n";
        return s;
    }
    */
}