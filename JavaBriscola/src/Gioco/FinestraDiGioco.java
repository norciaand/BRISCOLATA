package Gioco;

import javax.swing.*;
import java.awt.*;

public class FinestraDiGioco extends JFrame {
    
    private PannelloDiGioco pannelloDiGioco;
    
    //CONSTRUCTOR
    
    public FinestraDiGioco(String nomeFinestra, Partita partitaInCorso, Squadra squadra, Giocatore giocatore) throws HeadlessException {
        super("Briscola - " + nomeFinestra);
        pannelloDiGioco = new PannelloDiGioco(partitaInCorso,squadra ,giocatore);
        setSize(900,900);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(53,101,77));
        setContentPane(pannelloDiGioco);
        
    }
    
    
}
