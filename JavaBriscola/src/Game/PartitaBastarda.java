package Game;

import Experience.Lingua;
import Experience.Tema;
import java.util.ArrayList;

public class PartitaBastarda extends PartitaMP {

    private Giocatore bastardo;
    private Squadra squadraBastarda;
    private Squadra squaraAlleati;
    
    public PartitaBastarda() {
        super(3);
        bastardo = null;
        squadraBastarda = null;
        squaraAlleati = null;
    }
    
    @Override
    public void controlloBastarda(Carta carta, Giocatore giocatore) {
        
        if (bastardo == null && carta.getSeme() == getSemeBriscola()) {
            System.out.println("BECCATO IL BASTARDO");
            bastardo = giocatore;
            squadraBastarda = new Squadra("Bastardo", Tema.getRosso());
            squaraAlleati = new Squadra("Alleati", Tema.getBlu());

            ArrayList<Carta> carteBastardo = new ArrayList<>(bastardo.getSquadra().getCarteVinte());
            squadraBastarda.getGiocatori().add(bastardo);
            bastardo.setSquadra(squadraBastarda);
            squadraBastarda.setCarteVinte(carteBastardo);
            
            bastardo.refreshFrameTitle("Briscolata - " + bastardo.getNome().split(" - ")[0] + " - " + Lingua.getStringhe(32));

            ArrayList<Carta> carteAlleati = new ArrayList<>();
            
            Giocatore[] giocatoriAlleati = new Giocatore[2];
            int i = 0;
            for (Entita g : getTuttiGiocatori()){
                if (g != bastardo){
                    giocatoriAlleati[i] = (Giocatore) g;
                    i++;
                }
            }
            carteAlleati.addAll(giocatoriAlleati[0].getSquadra().getCarteVinte());
            carteAlleati.addAll(giocatoriAlleati[1].getSquadra().getCarteVinte());
            
            for (Giocatore g: giocatoriAlleati) {
                g.setSquadra(squaraAlleati);
                g.refreshFrameTitle("Briscolata - " + g.getNome().split(" - ")[0] + " - " + Lingua.getStringhe(31));
            }
            
            squaraAlleati.getGiocatori().add(giocatoriAlleati[0]);
            squaraAlleati.getGiocatori().add(giocatoriAlleati[1]);
            squaraAlleati.setCarteVinte(carteAlleati);
            
            getSquadre().clear();
            getSquadre().add(squadraBastarda);
            getSquadre().add(squaraAlleati);
        }
        
    }    
}
