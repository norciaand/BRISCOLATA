package Gioco;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameFrame extends JFrame {
    
    public JButton[] cardButton;

    public GameFrame(String nomeGiocatore) {
        super();
        setTitle("Briscola - Giocatore " + nomeGiocatore);
        setResizable(false);
        setVisible(true);
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(53,101,77));
        JPanel buttonPanel = new JPanel();
        cardButton = new JButton[3];
        
        
        for (int i = 0; i < 3; i++) {
            cardButton[i] = new JButton("CARTA");
            buttonPanel.add(cardButton[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
