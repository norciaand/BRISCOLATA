package Gioco;

public class PartitaSP extends Partita{
    public PartitaSP() {
        super(0);
    }

    @Override
    public void setupGameMode() {
        getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0], this,0);
        getSquadre().get(1).aggiungiNuovoBot(this,0);

        //DISTRIBUZIONE PRIME 3 CARTE
        distribuisci();
        formazioneGiocatori();
        
        Giocatore player = (Giocatore) getSquadre().getFirst().getGiocatori().getFirst();
        player.determinaAvversario();
        player.mostraFrame(-1,0);
    }
}
