package Gioco;

public class PartitaMP extends Partita{
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
    }


    //SETUP PARTITA MP
    @Override
    public void setup() {
        if(getnPlayer() == 2){
            getSquadres().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadres().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
        } else if (getnPlayer() == 4) {
            getSquadres().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadres().get(0).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
            getSquadres().get(1).aggiungiNuovoGiocatore(nomiGiocatori[2],this);
            getSquadres().get(1).aggiungiNuovoGiocatore(nomiGiocatori[3],this);
        }
        else if (getnPlayer() == 3){
            getSquadres().get(0).aggiungiNuovoGiocatore(nomiGiocatori[0],this);
            getSquadres().get(1).aggiungiNuovoGiocatore(nomiGiocatori[1],this);
            getSquadres().get(2).aggiungiNuovoGiocatore(nomiGiocatori[2],this);
        }
        
        //DISTRIBUZIONE PRIME 3 CARTE
        distribuisci();
        
        
        for (int s = 0; s < getSquadres().size(); s++) {
            for (int g = 0; g < getSquadres().get(s).getGiocatores().size(); g++) {

                int x,y;

                if (s == 0 && g == 0){
                    x = 0;
                    y = 0;
                } else if (s == 1 && g == 1){
                    x = 0;
                    y = 1;
                } else if (s == 0 && g == 1){
                    x = 1;
                    y = 1;
                } else {
                    x = 1;
                    y = 0;
                }
                
                Giocatore giocatore = (Giocatore) getSquadres().get(s).getGiocatores().get(g);
                giocatore.mostraFrame(x, y);
            }
        }
        
    }

}
