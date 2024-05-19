package Gioco;

import Esperienza.Tema;

import javax.swing.*;
import java.util.ArrayList;

public class PartitaBastarda extends PartitaMP {

    private Giocatore bastardo;
    private Squadra squadraBastarda;
    private Squadra squadraAlleati;
    
    public PartitaBastarda() {
        super(3);
        bastardo = null;
        squadraBastarda = null;
        squadraAlleati = null;
        JOptionPane.showMessageDialog(null, "Partita bastarda!", "a", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void controlloBastarda(Carta carta, Giocatore giocatore) {
        
        if (bastardo == null && carta.getSeme() == getSemeBriscola()) {

            System.out.println("BECCATO IL BASTARDO");
            bastardo = giocatore;
            squadraBastarda = new Squadra("Bastardo", Tema.getRosso());
            squadraAlleati = new Squadra("Alleati", Tema.getBlu());

            ArrayList<Carta> carteBastardo = new ArrayList<>(bastardo.getSquadra().getCarteVinte());
            squadraBastarda.getGiocatori().add(bastardo);
            bastardo.setSquadra(squadraBastarda);
            squadraBastarda.setCarteVinte(carteBastardo);
            
            bastardo.refreshFrameTitle("Briscolata - " + bastardo.getNome().split(" - ")[0] + " - Team Bastardo");

            ArrayList<Carta> carteAlleati = new ArrayList<>();
            
            Giocatore[] giocatori = new Giocatore[2];
            int i = 0;
            for (Entita g : getTuttiGiocatori()){
                if (g != bastardo){
                    giocatori[i] = (Giocatore) g;
                    i++;
                }
            }
            carteAlleati.addAll(giocatori[0].getSquadra().getCarteVinte());
            carteAlleati.addAll(giocatori[1].getSquadra().getCarteVinte());
            
            for (Giocatore g: giocatori) {
                g.setSquadra(squadraAlleati);
                g.refreshFrameTitle("Briscolata - " + g.getNome().split(" - ")[0] + " - Team Alleati");
            }
            
            
            squadraAlleati.getGiocatori().add(giocatori[0]);
            squadraAlleati.getGiocatori().add(giocatori[1]);
            squadraAlleati.setCarteVinte(carteAlleati);
            
            getSquadre().clear();
            getSquadre().add(squadraBastarda);
            getSquadre().add(squadraAlleati);
            
        }
        
        
    }
    
    
    
    
}
