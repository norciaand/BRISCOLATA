package Gioco;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class MPGameFrame extends JFrame implements ActionListener{
    
    public JButton[] cardButton;    
    private String[] prossimeFigure;

    public MPGameFrame(String nomeGiocatore) {
        super();
        setTitle("Briscola - Giocatore " + nomeGiocatore);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(53,101,77));
        JPanel buttonPanel = new JPanel();
        
        cardButton = new JButton[3];
        prossimeFigure = new String[3];
        
        
        for (int i = 0; i < 3; i++) {
            cardButton[i] = new JButton("CARTA");
            buttonPanel.add(cardButton[i]);
            cardButton[i].setSize(50,30);
        }

        add(buttonPanel, BorderLayout.SOUTH);
        
        /*gameThread = new Thread(this);
        gameThread.start();*/
    }

    public void impostaProssimeFigure(String s1,String s2, String s3){
        prossimeFigure[0] = s1;
        prossimeFigure[1] = s2;
        prossimeFigure[2] = s3;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;

        BufferedImage img1, img2, img3;
        
        try {
            img1 = ImageIO.read(getClass().getResourceAsStream("/napoletane/" + prossimeFigure[0] + ".png"));
            img2 = ImageIO.read(getClass().getResourceAsStream("/napoletane/" + prossimeFigure[1] + ".png"));
            img3 = ImageIO.read(getClass().getResourceAsStream("/napoletane/" + prossimeFigure[2] + ".png"));
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        graphics2D.drawImage(img1, 280,680,100,160,null);
        graphics2D.drawImage(img2, 400,680,100,160,null);
        graphics2D.drawImage(img3, 520,680,100,160,null);
        
        
    }
    
    
}
