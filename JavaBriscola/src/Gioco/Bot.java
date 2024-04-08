package Gioco;
import java.util.ArrayList;
import java.util.Random;


public class Bot{

    private Mazzo memoria;
    private ArrayList<Carta> mano = new ArrayList<>();
    private ArrayList<Integer> puntiMano;
    Random rd = new Random();
    private String nome;
    private int difficolta;

    public Bot(String nome, int difficolta) {
        this.nome = nome;
        this.difficolta = difficolta;
        memoria = new Mazzo();
    }

    public void prendiBot(Carta x){
        mano.add(x);
        memoria.getDeck().remove(x);
    }
    public Carta giocaBot(int turno){
        Carta x = null;
        puntiMano = new ArrayList<>();
        for(int i = 0; i < mano.size();i++){
             puntiMano.add(0);
        }

        /*
        * assegnazione punti;
        */

        int index = 0;
        int v = puntiMano.get(0);
        for(int i = 0; i < mano.size();i++){
            for(int j = 0; i < mano.size(); j++ ){
                if(i != j){
                    if(puntiMano.get(i) == puntiMano.get(j)) {
                        if (rd.nextBoolean()) {
                            index = i;
                        }else{
                            index = j;
                        }
                        v = puntiMano.get(i);
                    }
                    else if(puntiMano.get(i) < puntiMano.get(j)){
                        v = puntiMano.get(j);
                        index = j;
                    }
                }
            }
        }
        x = mano.get(index);
        mano.remove(x);
        return x;
    }
}
