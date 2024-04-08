package Gioco;

import javax.swing.*;
import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private ArrayList<Carta> mano = new ArrayList<>();
    public GameFrame gameFrame;


    public Giocatore(String nome) {
        this.nome = nome;
        mano.clear();
    }

    public void prendi(Carta x)
    {
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
        gameFrame = new GameFrame(nome);
        gameFrame.setBounds(60+500*x, 100*y+60, 800, 500);
    }
    
    public void update() {
        if (mano.size() == 3){
            for(int i = 0; i < mano.size(); i++){
                gameFrame.cardButton[i].setText(mano.get(i).getNome());
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"X");
        }
    }
    
}
