package Gioco;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(String nomeGiocatore) {
        setTitle("Briscola - Giocatore " + nomeGiocatore);
        setResizable(false);
        setVisible(true);
        setSize(900,600);
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(53,101,77));
        JPanel buttonPanel = new JPanel();
        JButton[] cardButton = new JButton[3];
        for (int i = 0; i < 3; i++) {
            cardButton[i] = new JButton("CARTA");
            buttonPanel.add(cardButton[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
