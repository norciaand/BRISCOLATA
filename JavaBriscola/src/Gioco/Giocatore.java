package Gioco;

import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private ArrayList<Carta> mano = new ArrayList<>();
    private MPGameFrame gameFrame;


    public Giocatore(String nome) {
        this.nome = nome;
        mano.clear();
    }

    public void prendi(Carta x) {
        mano.add(x);
    }

    public Carta getCarta(int index)
    {
        return mano.get(index);
    }

    public Carta giocaCarta(int index)
    {
        Carta x = mano.get(index);
        mano.remove(index);
        return x;
    }
    
    public void mostraFrame(int x, int y){
        gameFrame = new MPGameFrame(nome);
        gameFrame.setBounds(60+500*x, 100*y+60, 900, 900);
    }
    
    public void updateMano() {
        if (mano.size() == 3){
            for(int i = 0; i < mano.size(); i++){
                gameFrame.cardButton[i].setText(mano.get(i).getNome());
            }
        }
    }
    
    public void disegnaMano(){
        gameFrame.impostaProssimeFigure(mano.get(0).toString(),mano.get(1).toString(),mano.get(2).toString());
        gameFrame.repaint();
    }
    
    public MPGameFrame getGameFrame() {
        return gameFrame;
    }
    
    
}
