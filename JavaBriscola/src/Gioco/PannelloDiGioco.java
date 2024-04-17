package Gioco;

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
    
    //OGGETTI PARTITA
    private final Partita partita;
    private final Squadra squadra;
    private final Giocatore giocatore;
    
    //IMMAGINI
    private BufferedImage briscola, mazzo, anonima;
    private BufferedImage[] immaginiMano;
    private BufferedImage[] immaginiBanco;
        
    //CARTE MANO
    private int selettore;
    private boolean isPressingEnter;
    
    public PannelloDiGioco(Partita partita,Squadra squadra, Giocatore giocatore) {
        this.partita = partita;
        this.giocatore = giocatore;
        this.squadra = squadra;

        selettore = 1;
        
        setBackground(new Color(53,101,77));
        setDoubleBuffered(true);
        setFocusable(true);
        
        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        immaginiMano = new BufferedImage[3];
        immaginiBanco = new BufferedImage[4];
        startGameThread();
        
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.setName(giocatore.getNome() + " - THREAD");
        gameThread.start();
    }

    @Override
    public void run() {        
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

    public void update() {
        if (keyHandler.isPressed1()){
            selettore = 0;
        } else if (keyHandler.isPressed2()){
            selettore = 1;
        } else if (keyHandler.isPressed3()){
            selettore = 2;
        }
        
        if (keyHandler.isPressedEnter()){
            isPressingEnter = true;
        } else {
            isPressingEnter = false;
        }
        
        for (int i = 0; i < giocatore.getMano().size(); i++){
            try {
                immaginiMano[i] = read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + giocatore.getMano().get(i).toString() + ".png")));
            } catch (IOException e) {
                System.out.println("ECCEZIONE IN IMMAGINI MANO GAME PANEL - " + gameThread.getName());
            }
        }
        
        for (int i = 0; i < partita.getAllBanco().size(); i++){
            try {
                immaginiBanco[i] = read(Objects.requireNonNull(getClass().getResourceAsStream("/napoletane/" + partita.getBanco(i).toString() + ".png")));
            } catch (IOException e) {
                System.out.println("ECCEZIONE IN BANCO MANO GAME PANEL - " + gameThread.getName());
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
        graphics2D.drawLine(260 + (selettore *130),840, 260 + (selettore *130) + 120, 840);
        
        
        //DISEGNO CARTE IN MANO
        for(int i = 0; i < giocatore.getMano().size(); i++){
            if (immaginiMano[i] != null)
                graphics2D.drawImage(immaginiMano[i],270 + (i*130),660,100,160,null);
        }
        
        //DISEGNO CARTE SUL BANCONE
        for (int i = 0; i < partita.getAllBanco().size();i++){
            if (immaginiBanco[i] != null)
                graphics2D.drawImage(immaginiBanco[i],400 + (i*40),350,100,160,null);
        }
        
        //DISEGNO CARTE ANONIME SOPRA
        graphics2D.drawImage(anonima, 270,20,100,160,null);
        graphics2D.drawImage(anonima, 400,20,100,160,null);
        graphics2D.drawImage(anonima, 530,20,100,160,null);


        //DISEGNO BRISCOLA E MAZZO
        graphics2D.drawImage(briscola, 150,350,100,160,null);
        graphics2D.drawImage(mazzo,50,340,120,180,null);
        
        graphics2D.setFont(new Font("Arial",Font.BOLD,20));
        graphics2D.drawString(giocatore.getMano().get(selettore).getNome(),20,840);
        graphics2D.drawString("PUNTI: " + "20", 770,840);
        
        
        
        
        graphics2D.dispose();
    }

    public boolean isPressingEnter() {
        return isPressingEnter;
    }

    public int getSelettore() {
        return selettore;
    }
    
    public void setSelettore(int selettore) {
        this.selettore = selettore;
    }
}
