package Gioco;

public class PartitaMP extends Partita{
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
    }


    //SETUP PARTITA MP
    @Override
    public void setupGameMode() {
        if(getNumGiocatori() == 2){
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
        } else if (getNumGiocatori() == 4) {
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[2],this);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[3],this);
        }
        else if (getNumGiocatori() == 3){
            getSquadre().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadre().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
            getSquadre().get(2).aggiungiNuovoGiocatore(nomiGiocatori[2],this);
        }
        
        //DISTRIBUZIONE PRIME 3 CARTE
        distribuisci();
        
        if (getNumGiocatori() == 2){
            Giocatore g;
            for (int i = 1; i >= 0; i--) {
                g = (Giocatore) getSquadre().get(i).getGiocatori().getFirst();
                g.mostraFrame(i,0);
            }
            
        } else if (getNumGiocatori() == 3){
            Giocatore g;
            
            for (int i = 2; i >= 0; i--) {
                g = (Giocatore) getSquadre().get(i).getGiocatori().getFirst();
                g.mostraFrame(i,0);
            }
            
            
        } else if (getNumGiocatori() == 4){
            Giocatore g;

            g = (Giocatore) getSquadre().get(1).getGiocatori().get(1);
            g.mostraFrame(0,1);
            
            g = (Giocatore) getSquadre().get(0).getGiocatori().get(1);
            g.mostraFrame(1,1);

            g = (Giocatore) getSquadre().get(1).getGiocatori().get(0);
            g.mostraFrame(1,0);
            
            g = (Giocatore) getSquadre().get(0).getGiocatori().get(0);
            g.mostraFrame(0,0);
        }
        

        
    }

}
