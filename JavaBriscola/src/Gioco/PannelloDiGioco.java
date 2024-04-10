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
    private int selector;
    
    public PannelloDiGioco(Partita partita,Squadra squadra, Giocatore giocatore) {
        this.partita = partita;
        this.giocatore = giocatore;
        this.squadra = squadra;
        
        this.setBackground(new Color(53,101,77));
        
        selector = 1;
        
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
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
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
        
        BufferedImage[] m = new BufferedImage[giocatore.getMano().size()];
        BufferedImage briscola, mazzo, anonima;
        
        switch (partita.getTipoPartita()){
            case 0:
                try {
                    anonima = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("anonim.png")));
                    mazzo = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("mazzo.png")));
                    briscola = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + partita.getCartaBriscola().toString() + ".png")));
                
                    for(int i = 0; i < m.length; i++){
                        m[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + giocatore.getMano().get(i).toString() + ".png")));
                        graphics2D.drawImage(m[i],270 + (i*130),660,100,160,null);
                    }

                    //DISEGNO CARTE SOPRA
                    graphics2D.drawImage(anonima, 270,20,100,160,null);
                    graphics2D.drawImage(anonima, 400,20,100,160,null);
                    graphics2D.drawImage(anonima, 530,20,100,160,null);

                    //DISEGNO BRISCOLA
                    graphics2D.drawImage(briscola, 150,350,100,160,null);
                    graphics2D.drawImage(mazzo,50,340,120,180,null);
                    
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
                
                
                break;
            case 1:
                break;
            case 2:
            case 3:
                break;
        }
        
            
        //DISEGNO SELECTOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(2.5f));
        graphics2D.drawLine(260 + (selector*130),840, 260 + (selector*130) + 120, 840);
        
        graphics2D.setFont(new Font("Arial",Font.BOLD,20));
        graphics2D.drawString(giocatore.getMano().get(selector).getNome(),20,840);
        graphics2D.drawString("PUNTI: " + "20", 770,840);
            
        graphics2D.dispose();
        
    }
}
