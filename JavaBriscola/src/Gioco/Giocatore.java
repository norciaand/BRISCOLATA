package Gioco;

import java.util.ArrayList;

public class Giocatore extends Entita {
    
    private final ArrayList<Carta> mano = new ArrayList<>();

    private FinestraDiGioco gameFrame;
    
    private boolean PLAYER_STATE; //turno true/false

    public Giocatore(String nome,Squadra squadra, Partita partita) {
        super(nome, squadra, partita);
        PLAYER_STATE = false;
    }
    
    @Override
    public void prendiCarta(Carta x) {
        mano.add(x);
    }
    
    @Override
    public Carta giocaCarta() {
        if (gameFrame.getPannelloDiGioco().isPressingEnter()) {
            Carta cartaGiocata = mano.get(gameFrame.getPannelloDiGioco().getSelettore());
            mano.remove(gameFrame.getPannelloDiGioco().getSelettore());
            gameFrame.getPannelloDiGioco().setSelettore(0);
            return cartaGiocata;
        }
        return null;
    }
    
    public void mostraFrame(int x, int y){
        gameFrame = new FinestraDiGioco(getNome(),getPartita(), getSquadra(),this);
        gameFrame.setBounds(60+500*x, 100*y+60, 900, 900);
        
        if (x == -1){
            gameFrame.setLocationRelativeTo(null);
        }
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public boolean getPLAYER_STATE() {
        return PLAYER_STATE;
    }

    @Override
    public void assegnaTurno(){
        if (getPartita().getMATCH_STATE() == 2){
            gameFrame.getPannelloDiGioco().setSelettore(0);
        } else {
            gameFrame.getPannelloDiGioco().setSelettore(1);
        }
        
        PLAYER_STATE = true;
    }
    
    @Override
    public void finalizaTurno(){
        gameFrame.getPannelloDiGioco().setPressingEnter(false);
        PLAYER_STATE = false;
    }
}
