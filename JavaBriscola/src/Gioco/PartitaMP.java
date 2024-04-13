package Gioco;

public class PartitaMP extends Partita{
    
    final String[] nomii = {"Andrea", "Alessandro","Giovanni","Filippo"}; //ESEMPIO
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
        setup();
    }
    
    public void setup() {
        
        if(getnPlayer() == 2){
            squadres.get(0).aggiungiNuovoGiocatore(nomii[0],this);
            squadres.get(1).aggiungiNuovoGiocatore(nomii[1],this);
        } else if (getnPlayer() == 4) {
            squadres.get(0).aggiungiNuovoGiocatore(nomii[0],this);
            squadres.get(0).aggiungiNuovoGiocatore(nomii[1],this);
            squadres.get(1).aggiungiNuovoGiocatore(nomii[2],this);
            squadres.get(1).aggiungiNuovoGiocatore(nomii[3],this);
        }
        else if (getnPlayer() == 3){
            squadres.get(0).aggiungiNuovoGiocatore(nomii[0],this);
            squadres.get(1).aggiungiNuovoGiocatore(nomii[1],this);
            squadres.get(2).aggiungiNuovoGiocatore(nomii[2],this);
        }
        
        //DISTRIBUZIONE PRIME 3 CARTE
        for (int j = 0; j < 3; j++){
            for(Squadra squadra : squadres){
                for (Giocatore giocatore: squadra.getGiocatores()) {
                    giocatore.prendi(getMazzo1().pesca());
                }
            }
        }
        
        //MOSTRA FRAME
        for (int i = 0; i < squadres.size(); i++) {
            for (int j = 0; j < squadres.get(i).getGiocatores().size(); j++){
                squadres.get(i).getGiocatores().get(j).mostraFrame(i,j);
            }
        }
                
        
        
    }
    
    
    
    
}
