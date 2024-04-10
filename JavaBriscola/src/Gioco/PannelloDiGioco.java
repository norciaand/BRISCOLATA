package Gioco;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PannelloDiGioco extends JPanel implements Runnable {

    //PANEL TOOLS
    private Thread gameThread;
    private KeyHandler keyHandler;
    private final int FPS = 60;
    
    //INFO PARTITA
    private final Partita partita;
    private final Squadra squadra;
    private final Giocatore giocatore;
        
    //CARTE MANO
    private String[] manoCard;
    private int selector;
    private int pressorLeft;
    private int pressorRight;
    
    public PannelloDiGioco(Partita partita,Squadra squadra, Giocatore giocatore) {
        this.partita = partita;
        this.giocatore = giocatore;
        this.squadra = squadra;
        
        this.setBackground(new Color(53,101,77));
        manoCard = new String[3];
        
        selector = 1;
        pressorLeft = 0;
        pressorRight = 0;
        
        setDoubleBuffered(true);
        setFocusable(true);
        
        keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        startGameThread();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while (gameThread != null){
            update();
            
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
                throw new RuntimeException(e);
            }
            repaint();
        }
    }

    public void update(){
        //AGGIORNAMENTO MANOCARD
        for (int i = 0; i < giocatore.getMano().size(); i++){
            manoCard[i] = giocatore.getMano().get(i).toString();
        }
        
        /*if (keyHandler.isLeftPressed()){
            pressorLeft++;
            if (selector != 0 && pressorLeft > FTSK) {
                selector--;
                pressorLeft = 0;
            }
        } 
        else if (keyHandler.isRightPressed()) {
            pressorRight++;
            if (selector != 2 && pressorRight > FTSK) {
                selector++;
                pressorRight = 0;
            }
        }*/
        
        if (keyHandler.isPressed1()){
            selector = 0;
        } else if (keyHandler.isPressed2()){
            selector = 1;
        } else if (keyHandler.isPressed3()){
            selector = 2;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        
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
            
            //DISEGNO MANO
            graphics2D.drawImage(m0, 270,660,100,160,null);
            graphics2D.drawImage(m1, 400,660,100,160,null);
            graphics2D.drawImage(m2, 530,660,100,160,null);
            
            //DISEGNO BRISCOLA
            graphics2D.drawImage(briscola, 100,350,100,160,null);
            
            //DISEGNO SELECTOR
            graphics2D.setColor(Color.WHITE);
            graphics2D.setStroke(new BasicStroke(2.5f));
//            graphics2D.drawRect(260 + (selector*130) ,630,120,180);
            graphics2D.drawLine(260 + (selector*130),840, 260 + (selector*130) + 120, 840);
            
            graphics2D.setFont(new Font("Arial",Font.BOLD,20));
            graphics2D.drawString(giocatore.getMano().get(selector).getNome(),20,840);
            graphics2D.drawString("PUNTI: " + "20", 770,840);
            
        }
        graphics2D.dispose();
    }
    
}
