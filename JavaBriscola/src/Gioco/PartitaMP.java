package Gioco;


public class PartitaMP extends Partita{
    
    final String[] nomii = {"Andrea", "Fabio","Giovanni"};
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
        funzioniIniziali();
    }
    
    public void funzioniIniziali(){
        
        if(getnPlayer() == 2){
            squadres.get(0).aggiungiAllaSquadra("A");
            squadres.get(1).aggiungiAllaSquadra("B");
        } else if (getnPlayer() == 4) {
            squadres.get(0).aggiungiAllaSquadra("A1");
            squadres.get(0).aggiungiAllaSquadra("A2");
            squadres.get(1).aggiungiAllaSquadra("B1");
            squadres.get(1).aggiungiAllaSquadra("B2");
        }
        else if (getnPlayer() == 3){
            squadres.get(0).aggiungiAllaSquadra("A");
            squadres.get(1).aggiungiAllaSquadra("B");
            squadres.get(2).aggiungiAllaSquadra("C");
        }
        

        for (int i = 0; i < squadres.size(); i++) {

            for (int j = 0; j < squadres.get(i).getGiocatores().size(); j++){
                squadres.get(i).getGiocatores().get(j).mostraFrame(i,j);
            }
        }

        for (int j = 0; j < 3; j++){
            for(Squadra squadra :squadres){
                for (Giocatore giocatore: squadra.getGiocatores()) {
                    giocatore.prendi(getMazzo1().pesca());
                }
            }
        }

        for(Squadra squadra :squadres){
            for (Giocatore giocatore: squadra.getGiocatores()) {
                giocatore.update();
            }
        }
        
        
    }
    
    
}
