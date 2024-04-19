package Gioco;

import java.util.ArrayList;

public class Giocatore {
    
    private String nome;
    private final ArrayList<Carta> mano = new ArrayList<>();

    private FinestraDiGioco gameFrame;
    private final Partita partita;
    private final Squadra squadra;
    
    private boolean PLAYER_STATE; //turno true/false

    public Giocatore(String nome,Squadra squadra, Partita partita) {
        this.nome = nome;
        this.partita = partita;
        this.squadra = squadra;
        PLAYER_STATE = false;
    }

    public void prendiCarta(Carta x) {
        mano.add(x);
    }

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
        gameFrame = new FinestraDiGioco(nome,partita, squadra,this);
        gameFrame.setBounds(60+500*x, 100*y+60, 900, 900);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public boolean getPLAYER_STATE() {
        return PLAYER_STATE;
    }

    public Squadra getSquadra() {
        return squadra;
    }

    public void assegnaTurno(){
        gameFrame.getPannelloDiGioco().setSelettore(1);
        PLAYER_STATE = true;
    }
    
    public void finalizaTurno(){
        gameFrame.getPannelloDiGioco().setPressingEnter(false);
        PLAYER_STATE = false;
    }
}
