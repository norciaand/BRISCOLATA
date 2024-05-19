package Game;

import Experience.Carattere;
import Experience.Tema;

import java.awt.*;
import java.util.ArrayList;

public class Chat {
    private final ArrayList<Messaggio> contenuto;

    public Chat() {
        contenuto = new ArrayList<>();
    }
    
    public void scrivi(Giocatore giocatore, String messaggio) {
        contenuto.add(new Messaggio(giocatore, messaggio));
        if (contenuto.size() > 10 ) {
            contenuto.removeFirst();
        }
    }
    
    public int posizioneFinale (){
        return 430 - (contenuto.size() * 10) + 20 * contenuto.size();
    }
    
    public void draw (Graphics2D g2){
        FontMetrics fm = g2.getFontMetrics(Carattere.getPlain20());
        
        final int yStart = 430 - (contenuto.size() * 10);
        final int yEnd = yStart + 20 * contenuto.size();
        final int xStart = 670; final int xEnd = 860;
        
        g2.setColor(Tema.getSfondoChat());
        
        if (!contenuto.isEmpty()){
            g2.fillRoundRect(xStart - 10 ,yStart - 20, xEnd-xStart + 20 , yEnd-yStart + 10 , 10, 10);
        }
        
        for (int i = 0; i < contenuto.size(); i++) {
            g2.setColor(contenuto.get(i).giocatore().getSquadra().getColore());
            g2.setFont(Carattere.getBold20());
            g2.drawString(contenuto.get(i).giocatore().getNome().split(" - ")[0], xStart,yStart + 20*i);
            g2.setFont(Carattere.getPlain20());
            g2.setColor(Color.white);
            g2.drawString(contenuto.get(i).testo(),xEnd -  fm.stringWidth(contenuto.get(i).testo()),yStart + 20*i);

        }
        
    }

}
