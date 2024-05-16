package Gioco;

import Esperienza.Carattere;
import Esperienza.Lingua;
import Esperienza.Tema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class PannelloDiGioco extends JPanel implements Runnable, MouseListener {

    //PANEL TOOLS
    private Thread paneThread;
    private final KeyHandler keyHandler;

    //INTERAZIONI
    private int frameCursor;
    private int selettore;
    private boolean isPressingEnter;
    
    //COMPONENTI PARTITA
    private final Partita partita;
    private final Giocatore giocatore;
    
    //IMMAGINI
    private BufferedImage immagineBriscola, immagineMazzo, immagineAnonima;
    private final BufferedImage[] immaginiMano;
    private final BufferedImage[] immaginiBanco;
    private BufferedImage[] immaginiCarteVinte;
    private BufferedImage immagineCartaVinta;
    
    //VARIABILI FASE 3
    private int puntiCartaVinta;
    private int puntiContatore;
    private boolean contaFinita;
    private String risultatoPartita;
    
    
    public PannelloDiGioco(Partita partita, Giocatore giocatore) {
        this.partita = partita;
        this.giocatore = giocatore;
        
        frameCursor = 0;
        selettore = 1;
        
        setBackground(new Color(53,101,77));
        setDoubleBuffered(true);
        setFocusable(true);
        
        //LISTENER
        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        keyHandler.setChatMode(false);
        addMouseListener(this);
        
        immaginiMano = new BufferedImage[3];
        immaginiBanco = new BufferedImage[4];
        
        
        
        
        startGameThread();
    }

    public void startGameThread(){
        paneThread = new Thread(this);
        paneThread.setName("THREAD di " + giocatore.getNome());
        paneThread.start();
    }

    @Override
    public void run() {     
        
        try {
            immagineAnonima = read(Objects.requireNonNull(getClass().getClassLoader().getResource("anonima.png")));
            immagineMazzo = read(Objects.requireNonNull(getClass().getClassLoader().getResource("mazzo.png")));
            immagineBriscola = read(Objects.requireNonNull(getClass().getResourceAsStream(Tema.getTipoCarta() + partita.getCartaBriscola().toString() + ".png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
        //FASE 1 (gioco), 2 (endgame), loop di update, repaint
        
        while (partita.getMATCH_STATE() >= 1 && partita.getMATCH_STATE() <= 2){
            update();
            repaint();
        }
        
        //MATCH STATE = 3
        
        immaginiCarteVinte = new BufferedImage[giocatore.getSquadra().getCarteVinte().size()];
        for (int i = 0; i < giocatore.getSquadra().getCarteVinte().size(); i++) {
            try {
                immaginiCarteVinte[i] = read(Objects.requireNonNull(getClass().getResourceAsStream(Tema.getTipoCarta() + giocatore.getSquadra().getCarteVinte().get(i).toString() + ".png")));
            } catch (IOException e) {
                System.out.println("ECCEZIONE CARICAMENTO PUNTI - " + paneThread.getName());
            }
        }
        
        contaFinita = false;
        puntiContatore = 0;
        for (int i = 0; i < giocatore.getSquadra().getCarteVinte().size(); i++) {
            immagineCartaVinta = immaginiCarteVinte[i];
            puntiCartaVinta = giocatore.getSquadra().getCarteVinte().get(i).getPunti();
            puntiContatore += puntiCartaVinta;
            repaint();
            try {
                Thread.sleep(Long.parseLong("700"));
            } catch (InterruptedException e) {
            }
        }

        try {
            Thread.sleep(Long.parseLong("1000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        contaFinita = true;
        if(puntiContatore > 60){
            risultatoPartita = "VITTORIA!";
        } else if (puntiContatore == 60){
            risultatoPartita = "PAREGGIO";
        } else {
            risultatoPartita = "SCONFITTA";
        }
        repaint();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        giocatore.cancellaFrame();
        paneThread.interrupt();
        
    }

    public void update() {
        //lettura input - chat
        if (!keyHandler.isChatMode()) {
            if (keyHandler.isPressedT()){
                keyHandler.setChatMode(true);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else if (giocatore.getPLAYER_STATE()){
                if (keyHandler.isPressed1()){
                    selettore = 0;
                } else if (keyHandler.isPressed2()){
                    selettore = 1;
                } else if (keyHandler.isPressed3()){
                    selettore = 2;
                }

                if (selettore >= giocatore.getMano().size()) {
                    selettore = giocatore.getMano().size()-1;
                }

                isPressingEnter = keyHandler.isPressedEnter();
            }
            
        } 
        else {
            if (frameCursor > 60)
            {
                frameCursor = 0;
            } else {
                frameCursor++;
            }
            
            if (keyHandler.isPressedEnter()){
                if (!keyHandler.getMessaggio().isEmpty()){
                    partita.getChat().scrivi(giocatore, keyHandler.getMessaggio());
                    keyHandler.resetMessaggio();
                    keyHandler.setChatMode(false);
                }
                keyHandler.setChatMode(false);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        //CARICAMENTO IMMAGINI NELLA MANO
        for (int i = 0; i < giocatore.getMano().size(); i++) {
            try {
                immaginiMano[i] = read(Objects.requireNonNull(getClass().getResourceAsStream(Tema.getTipoCarta() + giocatore.getMano().get(i).toString() + ".png")));
            } catch (IOException e) {
                // System.out.println("ECCEZIONE IN IMMAGINI MANO GAME PANEL - " + paneThread.getName());
            }
        }
        
        //CARICAMENTO IMMAGINI NEL BANCO
        for (int i = 0; i < partita.getAllBanco().size(); i++){
            try {
                immaginiBanco[i] = read(Objects.requireNonNull(getClass().getResourceAsStream(Tema.getTipoCarta() + partita.getBanco(i).toString() + ".png")));
            } catch (IOException e) {
                // System.out.println("ECCEZIONE IN BANCO MANO GAME PANEL - " + paneThread.getName());
            }
        }
        
        if (partita.getMATCH_STATE() == 2 || partita.getMATCH_STATE() == 3) {
            immagineMazzo = immagineBriscola = null;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.WHITE);
        
        //painter se la partita è finita, calcolo punti;
        if (partita.getMATCH_STATE() == 3){
            if (!contaFinita){
                graphics2D.drawImage(immagineCartaVinta, 200, 290,200,320, null);
                graphics2D.setFont(Carattere.getUtendoBold30());
                graphics2D.drawString("+ " + puntiCartaVinta,275,660);
                graphics2D.setFont(Carattere.getUtendoBold100());
                graphics2D.drawString(String.valueOf(puntiContatore),580,485);
                
            } else {
                graphics2D.setFont(Carattere.getUtendoBold100());
                graphics2D.drawString(risultatoPartita,100,485);
            }
        } 
        else 
        {
            //DISEGNO SELECTOR
            if (giocatore.getPLAYER_STATE()) {
                graphics2D.setStroke(new BasicStroke(2.5f));
                graphics2D.drawLine(260 + (selettore * 130), 840, 260 + (selettore * 130) + 120, 840);
            }
            
            //DISEGNO CARTE IN MANO
            for (int i = 0; i < giocatore.getMano().size(); i++) {
                if (immaginiMano[i] != null)
                    graphics2D.drawImage(immaginiMano[i], 270 + (i * 130), 660, 100, 160, null);
            }

            //DISEGNO CARTE SUL BANCONE
            for (int i = 0; i < partita.getAllBanco().size(); i++) {
                if (immaginiBanco[i] != null)
                    graphics2D.drawImage(immaginiBanco[i], 380 + (i * 40), 350, 100, 160, null);
            }

            //DISEGNO CARTE ANONIME SOPRA
            if (giocatore.getAvversarioFrontale() != null)
            {
                for (int i = 0; i < giocatore.getAvversarioFrontale().getMano().size(); i++) {
                    graphics2D.drawImage(immagineAnonima, 270 + (130 * i), 20, 100, 160, null);
                }
            }
            
            //DISEGNO BRISCOLA E MAZZO
            if (immagineMazzo != null) {
                graphics2D.drawImage(immagineBriscola, 150, 350, 100, 160, null);
                graphics2D.drawImage(immagineMazzo, 50, 340, 120, 180, null);
            }
            
            graphics2D.setFont(Carattere.getUtendoBold20());
            if (selettore < giocatore.getMano().size())
                graphics2D.drawString(giocatore.getMano().get(selettore).getNome(), 20, 840);
            graphics2D.drawString(Lingua.getStringhe(15) + " " + giocatore.getSquadra().calcoloPunti(), 770, 840);
            graphics2D.drawString(Lingua.getStringhe(16) + " " + partita.getMazzo().getSize(), 760, 40);
            
            //DISEGNA CHAT
            partita.getChat().draw(graphics2D);
            
            if (keyHandler.isChatMode()) {
                graphics2D.setColor(Tema.getSfondoChat());
                
                int x1 = 660, x2 = 870;
                graphics2D.fillRoundRect(x1, partita.getChat().posizioneFinale(), x2-x1, 30,10,10);

                graphics2D.setFont(Carattere.getPlain20());
                graphics2D.setColor(Color.WHITE);
                
                FontMetrics fontMetrics = graphics2D.getFontMetrics(Carattere.getPlain20());
                
                int x0 = x1 + (x2 - x1 - fontMetrics.stringWidth(keyHandler.getMessaggio()))/2;
                
                graphics2D.drawString(keyHandler.getMessaggio(),x0,partita.getChat().posizioneFinale() + 20);
                
                if (frameCursor > 30 && keyHandler.getMessaggio().length() < 14){
                    graphics2D.drawLine(x0 + fontMetrics.stringWidth(keyHandler.getMessaggio()),partita.getChat().posizioneFinale() + 20, x0 + fontMetrics.stringWidth(keyHandler.getMessaggio()), partita.getChat().posizioneFinale() + 10);
                }
            }
        }
        
        graphics2D.dispose();
    }
    
    public boolean isPressingEnter() { 
        return isPressingEnter; 
    }

    public void setPressingEnter(boolean pressingEnter) {
        isPressingEnter = pressingEnter;
    }

    public int getSelettore() {
        return selettore;
    }
    
    public void setSelettore(int selettore) {
        this.selettore = selettore;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        
        if (e.getButton() == MouseEvent.BUTTON1 && y > 660 && y < 820 && giocatore.getPLAYER_STATE()){
            
            if (x > 270 && x < 370){
                if (selettore != 0) {
                    selettore = 0;
                } else {
                    isPressingEnter  = true;
                }
            } else if (x > 400 && x < 500){
                if (selettore != 1) {
                    selettore = 1;
                } else {
                    isPressingEnter  = true;
                }
            } else if (x > 530 && x < 630) {
                if (selettore != 2) {
                    selettore = 2;
                } else {
                    isPressingEnter  = true;
                }
            }

            if (selettore >= giocatore.getMano().size() && !isPressingEnter) {
                selettore = giocatore.getMano().size()-1;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    public void exitGameThread () {
        paneThread.interrupt();
    }

    public Partita getPartita() {
        return partita;
    }
}
