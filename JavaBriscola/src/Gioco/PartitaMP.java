package Gioco;

public class PartitaMP extends Partita{
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
    }

    @Override
    public void controlloBastarda(Carta carta, Giocatore giocatore){
    }

    //SETUP PARTITA MP
    @Override
    public void setupGameMode() {
        if(getNumGiocatori() == 2){
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this,0);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this,1);
        } else if (getNumGiocatori() == 4) {
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this,0);
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[1],this,3);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[2],this,1);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[3],this,2);
        }
        else if (getNumGiocatori() == 3){
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this,0);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this,1);
            getSquadre().get(2).aggiungiNuovoGiocatore(nomiGiocatori[2],this,2);
            
            //BRISCOLA A 3?, no problem
            
            for (Carta carta : getMazzo().getDeck()){
                if (carta.getNumero() == 1 && carta.getSeme() != getSemeBriscola()) {
                    getMazzo().getDeck().remove(carta);
                    break;
                }
            }
            
            
        }
        
        
        //DISTRIBUZIONE PRIME 3 CARTE
        distribuisci();
        formazioneGiocatori();
        
        if (getNumGiocatori() == 2){
            Giocatore g;
            for (int i = 1; i >= 0; i--) {
                g = (Giocatore) getSquadre().get(i).getGiocatori().getFirst();
                g.determinaAvversario();
                g.mostraFrame(i,0);
            }
            
        } else if (getNumGiocatori() == 3){
            Giocatore g;
            
            for (int i = 2; i >= 0; i--) {
                g = (Giocatore) getSquadre().get(i).getGiocatori().getFirst();
                g.determinaAvversario();
                g.mostraFrame(i,0);
            }
            
            
        } else if (getNumGiocatori() == 4){
            Giocatore g;
            
            g = (Giocatore) getSquadre().get(1).getGiocatori().get(1);
            g.determinaAvversario();
            g.mostraFrame(0,1);
            
            g = (Giocatore) getSquadre().get(0).getGiocatori().get(1);
            g.determinaAvversario();
            g.mostraFrame(1,1);

            g = (Giocatore) getSquadre().get(1).getGiocatori().get(0);
            g.determinaAvversario();
            g.mostraFrame(1,0);
            
            g = (Giocatore) getSquadre().get(0).getGiocatori().get(0);
            g.determinaAvversario();
            g.mostraFrame(0,0);
        }
        

        
    }

}
