package Gioco;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Bot{

    private Mazzo memoria;
    private ArrayList<Carta> mano = new ArrayList<Carta>();
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

    public Carta giocaBot(boolean firstMano , PartitaSP p){

        /*
        Appunti
        -per adesso piu da intendere come frammenti da riorganizare che come codice definitivo
        -fare in modo che in caso di licio si prefersica far vincere laversrario
        -fare in modo che mantenga briscole sui lisci ma prenda se altro seme
        -da riveder gestione briscole almeno 1 in mano
        */

        //Dichiarazione base
        Carta x = null;
        ArrayList<CartaBot> bMano = new ArrayList<CartaBot>();
        int nBri = 0;
        int nLis = 0;
        int index;
        //creazione array CartaBot
        for (Carta c : mano){
            CartaBot cb = new CartaBot(c.getSeme(), c.getNumero());
            if (c.getSeme() == p.getSemeBriscola()){
                cb.setBriscola(true);
                nBri++;
            }else
                cb.setBriscola(false);
            if(c.getPunti() == 0 && !cb.isBriscola()){
                cb.setLiscio(true);
                nLis++;
            }else
                cb.setLiscio(false);
            bMano.add(cb);
        }
        //------------------------------------------------
        //se si e primi di mano
        if(firstMano){
            //se e la primisima mano
            if(p.getMazzo1().getSize() == 33){

            }
        }
        //se si e secondi di mano
        else{
            //se laversario gioca liscio
            if(p.getBanco(0).getPunti() == 0){

            }
        }
        //------------------------------------------------
        //Capisce quale carta abbia piu punti scelta e in caso di partita la randomizza
        index = 0;
        int v = bMano.get(0).getGiocabilita();
        if(bMano.size() > 1) {
            for (int i = 1; i < bMano.size(); i++) {
                if (v == bMano.get(i).getGiocabilita() && rd.nextBoolean() || bMano.get(i).getGiocabilita() > v) {
                    index = i;
                    v = bMano.get(i).getGiocabilita();
                }
            }
        }
        //effetua la giocata
        x = mano.get(index);
        mano.remove(x);
        return x;
    }
}
