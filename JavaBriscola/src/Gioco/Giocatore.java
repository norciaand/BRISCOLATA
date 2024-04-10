package Gioco;

import java.util.ArrayList;

public class Giocatore {
    
    private String nome;
    private ArrayList<Carta> mano = new ArrayList<>();

    private FinestraDiGioco gameFrame;
    private Partita partita;

    public Giocatore(String nome, Partita partita) {
        this.nome = nome;
        this.partita = partita;
        mano.clear();
    }

    public void prendi(Carta x) {
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
    
    public void mostraFrame(int x, int y){
        gameFrame = new FinestraDiGioco(nome, partita,this);
        gameFrame.setBounds(60+500*x, 100*y+60, 900, 900);
    }

    public String getNome() {
        return nome;
    }

    public FinestraDiGioco getGameFrame() {
        return gameFrame;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }
}
