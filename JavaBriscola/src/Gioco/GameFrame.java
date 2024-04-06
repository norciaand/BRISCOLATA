package Gioco;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Gioco");
        setResizable(false);
        setVisible(true);
        setSize(800,500);
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
