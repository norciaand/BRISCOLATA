package Gioco;

import java.util.ArrayList;

public class Giocatore {
    
    private String nome;
    private ArrayList<Carta> mano = new ArrayList<>();

    private FinestraDiGioco gameFrame;
    private Partita partita;
    private Squadra squadra;

    public Giocatore(String nome,Squadra squadra, Partita partita) {
        this.nome = nome;
        this.partita = partita;
        this.squadra = squadra;
        mano.clear();
    }

    public void prendi(Carta x) {
        mano.add(x);
    }

    public Carta getCarta(int index)
    {
        return mano.get(index);
    }

    public Carta giocaCarta()
    {
//        while (true){
            if (gameFrame.getPannelloDiGioco().isPressingEnter()) {
                Carta x = mano.get(gameFrame.getPannelloDiGioco().getSelector());
                mano.remove(gameFrame.getPannelloDiGioco().getSelector());
                return x;
            }
            return mano.get(0);
//        }
    }
    
    public void mostraFrame(int x, int y){
        gameFrame = new FinestraDiGioco(nome,partita, squadra,this);
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
