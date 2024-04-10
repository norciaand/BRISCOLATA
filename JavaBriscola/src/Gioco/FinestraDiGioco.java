package Gioco;

import javax.swing.*;
import java.awt.*;

public class FinestraDiGioco extends JFrame {
    
    private PannelloDiGioco pannelloDiGioco;
    
    //CONSTRUCTOR
    
    public FinestraDiGioco(String nomeFinestra, Partita partitaInCorso, Squadra squadra, Giocatore giocatore) throws HeadlessException {
        setTitle("Briscola - " + nomeFinestra);
        pannelloDiGioco = new PannelloDiGioco(partitaInCorso, squadra ,giocatore);
        setSize(900,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pannelloDiGioco);
        setVisible(true);
    }
    
    
}
