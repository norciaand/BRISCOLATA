package Gioco;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PannelloDiGioco extends JPanel implements Runnable {

    //THREAD
    private Thread gameThread;
    
    //INFO PARTITA
    private final Partita partita;
    private final Squadra squadra;
    private final Giocatore giocatore;
    
    //GRAPHICS ENGINE SETTINGS
    private final int FPS = 60;
    
    
    private String[] manoCard;
    
    
    public PannelloDiGioco(Partita partita,Squadra squadra, Giocatore giocatore) {
        this.partita = partita;
        this.giocatore = giocatore;
        this.squadra = squadra;
        manoCard = new String[3];
        
        startGameThread();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        
    }

    @Override
    public void run() {
        setBackground(Color.CYAN);
        
        double drawInterval = (double) 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while (gameThread != null){
            update();
            repaint();
            try {
                double remainingTime =  nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        //AGGIORNAMENTO MANOCARD
        for (int i = 0; i < giocatore.getMano().size(); i++){
            manoCard[i] = giocatore.getMano().get(i).toString();
        }
        
        
    }


    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D)g;
        
        BufferedImage briscola;
        BufferedImage m0, m1, m2;

        if (manoCard[0] != null && manoCard[1] != null && manoCard[2] != null){
            try {
                briscola = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + partita.getCartaBriscola().toString() + ".png")));
                m0 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + manoCard[0] + ".png")));
                m1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + manoCard[1] + ".png")));
                m2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + manoCard[2] + ".png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            graphics2D.drawImage(m0, 270,680,100,160,null);
            graphics2D.drawImage(m1, 400,680,100,160,null);
            graphics2D.drawImage(m2, 530,680,100,160,null);
            
            graphics2D.drawImage(briscola, 100,350,100,160,null);
            graphics2D.dispose();
        }
    }
    
}
