package Gioco;

import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private ArrayList<Carta> mano = new ArrayList<>();
    public GameFrame gameFrame = new GameFrame(nome);


    public Giocatore(String nome) {
        this.nome = nome;
        mano.clear();
    }

    public void prendi(Carta x)
    {
        mano.add(x);
    }

    public Carta getCarta(int index)
    {
        return mano.get(index);
    }

    public Carta giocaCarta(int index)
    {
        Carta x = mano.get(index);
        mano.remove(index);
        return x;
    }



}
