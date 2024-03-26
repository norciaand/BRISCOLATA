package Gioco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    private ArrayList<Carta> data = new ArrayList<>();

    public static final int SEMI = 4;
    public static final int DECK = 10;

    public static final String[] rankOriginali = {"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Fante", "Cavallo", "Re"};
    public static final String[] semiOriginali = {"Denari", "Spade", "Coppe","Bastoni"};

    private void mischia()
    {
        Collections.shuffle(data);
    }

    public Mazzo()
    {
        riempi();
        mischia();
    }

    private void riempi()
    {
        data.clear();
        for (int i = 0; i < SEMI; i++)
        {
            for (int j = 0; j < DECK; j++)
            {
                data.add(new Carta(i, j));
            }
        }
    }

    public int semeBriscola()
    {
        return data.get(0).getSeme();
    }

    public String semeBriscolaToString()
    {
        return semiOriginali[semeBriscola()];
    }

    public Carta pesca()
    {
        Carta x = data.get(data.size()-1);
        data.remove(data.size()-1);
        return x;
    }

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

}