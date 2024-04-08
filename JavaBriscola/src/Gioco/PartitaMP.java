package Gioco;

public class PartitaMP extends Partita{
    
    final String[] nomii = {"Andrea", "Alessandro","Giovanni","Filippo"};
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
        setup();
    }
    
    public void setup(){
        
        if(getnPlayer() == 2){
            squadres.get(0).aggiungiAllaSquadra(nomii[0]);
            squadres.get(1).aggiungiAllaSquadra(nomii[1]);
        } else if (getnPlayer() == 4) {
            squadres.get(0).aggiungiAllaSquadra(nomii[0]);
            squadres.get(0).aggiungiAllaSquadra(nomii[1]);
            squadres.get(1).aggiungiAllaSquadra(nomii[2]);
            squadres.get(1).aggiungiAllaSquadra(nomii[3]);
        }
        else if (getnPlayer() == 3){
            squadres.get(0).aggiungiAllaSquadra(nomii[0]);
            squadres.get(1).aggiungiAllaSquadra(nomii[1]);
            squadres.get(2).aggiungiAllaSquadra(nomii[2]);
        }
        
        //CREAZIONE FINESTRE PER OGNI GIOCATORE PER OGNI SQUADRA
        for (int i = 0; i < squadres.size(); i++) {
            for (int j = 0; j < squadres.get(i).getGiocatores().size(); j++){
                squadres.get(i).getGiocatores().get(j).mostraFrame(i,j);
            }
        }
        
        //DISTRIBUZIONE PRIME 3 CARTE
        for (int j = 0; j < 3; j++){
            for(Squadra squadra :squadres){
                for (Giocatore giocatore: squadra.getGiocatores()) {
                    giocatore.prendi(getMazzo1().pesca());
                }
            }
        }
        
        //SCRITTURA JBUTTON
        for(Squadra squadra :squadres){
            for (Giocatore giocatore: squadra.getGiocatores()) {
                giocatore.updateMano();
                giocatore.disegnaMano();
            }
        }
    }
    
    
    
    
}
