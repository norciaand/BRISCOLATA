package Gioco;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FinestraDiGioco extends JFrame {
    
    private PannelloDiGioco pannelloDiGioco;
    
    //CONSTRUCTOR
    
    public FinestraDiGioco(String nomeFinestra, Partita partitaInCorso, Giocatore giocatore) throws HeadlessException {
        super("Briscola - " + nomeFinestra);
        pannelloDiGioco = new PannelloDiGioco(partitaInCorso, giocatore);
        setSize(900,900);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(53,101,77));
        setContentPane(pannelloDiGioco);
        
    }
    
    
}
