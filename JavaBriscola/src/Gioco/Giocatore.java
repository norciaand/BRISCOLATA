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

    public Carta giocaCarta() {
        if (gameFrame.getPannelloDiGioco().isPressingEnter()) {
            Carta cartaGiocata = mano.get(gameFrame.getPannelloDiGioco().getSelettore());
            mano.remove(gameFrame.getPannelloDiGioco().getSelettore());
            if (gameFrame.getPannelloDiGioco().getSelettore() >= mano.size())
            {
                gameFrame.getPannelloDiGioco().setSelettore(mano.size()-1);
            }
            System.out.println("BUONO");
            return cartaGiocata;
        }
        return null;
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
