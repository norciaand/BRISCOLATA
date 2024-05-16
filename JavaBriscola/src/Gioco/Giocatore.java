package Gioco;

import java.util.ArrayList;

public class Giocatore extends Entita {
    
    private final ArrayList<Carta> mano = new ArrayList<>();

    private FinestraDiGioco gameFrame;
    
    private boolean PLAYER_STATE; //turno true/false
    private boolean FINISHED;

    public Giocatore(String nome,Squadra squadra, Partita partita) {
        super(nome, squadra, partita);
        PLAYER_STATE = false;
        FINISHED = false;
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
        gameFrame = new FinestraDiGioco(getNome(),getPartita(),this);
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
        gameFrame.getPannelloDiGioco().setSelettore(1);
        
        if(gameFrame.getPannelloDiGioco().getSelettore() >= mano.size()){
            gameFrame.getPannelloDiGioco().setSelettore(mano.size()-1);
        }
        
        PLAYER_STATE = true;
    }
    
    @Override
    public void finalizaTurno(){
        gameFrame.getPannelloDiGioco().setPressingEnter(false);
        PLAYER_STATE = false;
    }
    
    public void cancellaFrame(){
        gameFrame.dispose();
        FINISHED = true;
    }
    
    public boolean isFINISHED() {
        return FINISHED;
    }
    
    public void chiusuraForzata(){
        gameFrame.getPannelloDiGioco().exitGameThread();
    }
}
