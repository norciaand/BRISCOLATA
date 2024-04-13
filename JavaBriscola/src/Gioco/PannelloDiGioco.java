package Gioco;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class PannelloDiGioco extends JPanel implements Runnable {

    //PANEL TOOLS
    private Thread gameThread;
    private KeyHandler keyHandler;
    
    //INFO PARTITA
    private final Partita partita;
    private final Squadra squadra;
    private final Giocatore giocatore;
    
    private BufferedImage briscola, mazzo, anonima;
    private BufferedImage[] m;
        
    //CARTE MANO
    private int selector;
    
    private boolean isPressingEnter;
    
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
        
        m = new BufferedImage[3];
        
        try {
            anonima = read(Objects.requireNonNull(getClass().getClassLoader().getResource("anonim.png")));
            mazzo = read(Objects.requireNonNull(getClass().getClassLoader().getResource("mazzo.png")));
            briscola = read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + partita.getCartaBriscola().toString() + ".png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (gameThread != null){
            update();
            repaint();
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
        
        if (keyHandler.isPressedEnter()){
            isPressingEnter = true;
        } else {
            isPressingEnter = false;
        }
        
        for (int i = 0; i < giocatore.getMano().size(); i++){
            try {
                m[i] = read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + giocatore.getMano().get(i).toString() + ".png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        //DISEGNO SELECTOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(2.5f));
        graphics2D.drawLine(260 + (selector*130),840, 260 + (selector*130) + 120, 840);

        
        for(int i = 0; i < m.length; i++){
            graphics2D.drawImage(m[i],270 + (i*130),660,100,160,null);
        }
        
        //DISEGNO CARTE SOPRA
        graphics2D.drawImage(anonima, 270,20,100,160,null);
        graphics2D.drawImage(anonima, 400,20,100,160,null);
        graphics2D.drawImage(anonima, 530,20,100,160,null);

        if(partita.getTipoPartita() == 0){
            
            //DISEGNO BRISCOLA
            graphics2D.drawImage(briscola, 150,350,100,160,null);
            graphics2D.drawImage(mazzo,50,340,120,180,null);
        }

        
        graphics2D.setFont(new Font("Arial",Font.BOLD,20));
        graphics2D.drawString(giocatore.getMano().get(selector).getNome(),20,840);
        graphics2D.drawString("PUNTI: " + "20", 770,840);
        
        graphics2D.dispose();
        
    }

    public boolean isPressingEnter() {
        return isPressingEnter;
    }

    public int getSelector() {
        return selector;
    }
}
