package Gioco;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FinestraDiGioco extends JFrame implements WindowListener {
    
    private final PannelloDiGioco pannelloDiGioco;
    
    //CONSTRUCTOR
    public FinestraDiGioco(String nomeFinestra, Partita partita, Giocatore giocatore) throws HeadlessException {
        setTitle("Briscolata - " + nomeFinestra);
        pannelloDiGioco = new PannelloDiGioco(partita ,giocatore);
        setSize(900,900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        add(pannelloDiGioco);
        addWindowListener(this);
        setVisible(true);
    }
    
    
    //GETTER DEL GAMEPANEL
    public PannelloDiGioco getPannelloDiGioco() {
        return pannelloDiGioco;
    }


    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        pannelloDiGioco.getPartita().chiusuraForzata();
        System.out.println("USCITA FORZATA");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
