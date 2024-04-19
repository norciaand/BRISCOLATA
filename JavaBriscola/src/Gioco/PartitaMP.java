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
        for (int j = 0; j < 3; j++){
            for(Squadra squadra : getSquadres()){
                for (Giocatore giocatore: squadra.getGiocatores()) {
                    giocatore.prendi(getMazzo1().pesca());
                }
            }
        }
        
        //MOSTRA FRAME
        for (int i = 0; i < getSquadres().size(); i++) {
            for (int j = 0; j < getSquadres().get(i).getGiocatores().size(); j++){
                getSquadres().get(i).getGiocatores().get(j).mostraFrame(i,j);
            }
        }
        
    }

}
