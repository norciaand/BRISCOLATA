package Gioco;
import java.util.ArrayList;
import java.util.Objects;
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



    public Carta giocaBot(int turno ,PartitaSP p){
        //Dichiarazione base
        final int VittoriaCarta = 100;
        Carta x = null;
        puntiMano = new ArrayList<>();
        int index = 0;

        //setta i punti scelta tutti a 0 e li crea in base al n carte
        for(int i = 0; i < mano.size();i++){
             puntiMano.add(0);
        }





        //se e il primo a giocare
        if(turno == 0){


        }
        //se e il secondo
        else{
            for (Carta c: mano){
                index = mano.indexOf(c);
                //asegnamento punti alle carte vincenti
                if(p.scontro(p.getBanco(0) , c) < 0){
                    puntiMano.set(index, puntiMano.get(index) + VittoriaCarta);
                }
                //si preferisce mantenere in mano le briscole piu grosse
                if(c.getSeme() == p.getBriscolaPartita()){
                    puntiMano.set(index, puntiMano.get(index) - c.getPunti());
                }
                //al contrario e meglio ottenere subito i punti delle altre carte
                else{
                    puntiMano.set(index, puntiMano.get(index) + c.getPunti());
                }
            }
        }
        //considerazioni sempre valide







        //Capisce quale carta abbia piu punti scelta e in caso di partita la randomizza
        index = 0;
        int v = puntiMano.get(0);
        for(int i = 0; i < mano.size();i++){
            for(int j = 0; i < mano.size(); j++ ){
                if(i != j){
                    if(Objects.equals(puntiMano.get(i), puntiMano.get(j))) {
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
        //effetua la giocata
        x = mano.get(index);
        mano.remove(x);
        return x;
    }
}
