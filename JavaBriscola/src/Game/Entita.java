package Game;

import java.util.ArrayList;

public abstract class Entita {
    
    public abstract void prendiCarta(Carta x);
    
    public abstract Carta giocaCarta();

    public abstract void assegnaTurno();

    public abstract void finalizaTurno();
    
    private final String nome;
    private final Partita partita;
    private Squadra squadra;

    public Entita(String nome, Squadra squadra, Partita partita) {
        this.nome = nome;
        this.partita = partita;
        this.squadra = squadra;
    }

    public String getNome() {
        return nome;
    }

    public Partita getPartita() {
        return partita;
    }

    public Squadra getSquadra() {
        return squadra;
    }
    
    public abstract ArrayList<Carta> getMano();

    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
    }
}
