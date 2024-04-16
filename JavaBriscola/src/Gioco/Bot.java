package Gioco;
import java.util.ArrayList;
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
        int nWin = 0;
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
        //considerazioni semore vere
        if(nBri == 1){
            for (CartaBot cb:bMano){
                if(cb.isBriscola())
                    cb.setGiocabilita(-15);
            }
        }
        //se si e primi di mano
        if(firstMano){
            //se e la primisima mano
            if(p.getMazzo1().getSize() == 33){

            }
        }
        //se si e secondi di mano
        else{
            //controllo se ci sono carte vincenti
            for (CartaBot cb: bMano){
                if(p.scontro(p.getBanco(0),mano.get(bMano.indexOf(cb))) < 0){
                    if(!(cb.isBriscola() && cb.getPunti() >= 10))
                        nWin++;
                    cb.setWin(true);
                }
            }
            //se laversario gioca liscio
            if(p.getBanco(0).getPunti() == 0){
                for(CartaBot cb: bMano){
                    if(cb.getPunti() >= 10 && !cb.isBriscola() && cb.isWin()) //carico non di briscola puo prendere
                        cb.setGiocabilita(100 + cb.getPunti());
                    else if(!cb.isWin() && cb.getPunti() < 10)      //si lascia al aversario scegliendo il meno peggio
                        cb.setGiocabilita(100 - cb.getNumero());
                    else if(cb.isWin())                             //se non si puo lasciare si prendono piu punti possibile
                        if(cb.isBriscola())
                            cb.setGiocabilita(75 - cb.getPunti());
                        else
                            cb.setGiocabilita(75 + cb.getPunti());
                }
            }
            else if(p.getBanco(0).getPunti() > 0 && p.getBanco(0).getPunti() <=4){
                for (CartaBot cb:bMano){
                    if(!cb.isBriscola() && cb.isWin()) //non di briscola puo prendere
                        cb.setGiocabilita(100 + cb.getPunti());
                    else if(nBri > 1 && cb.isWin() && cb.getPunti() < 10) //prendere con una briscola non carico
                        cb.setGiocabilita(100 - cb.getPunti() - cb.getNumero());
                    else if(nWin == 0)       //gli lascia il meno peggio
                        cb.setGiocabilita(-cb.getPunti() - cb.getNumero()/2);
                }
            }
            //in caso giochi carichi
            else if(p.getBanco(0).getPunti() >= 10){
                for (CartaBot cb: bMano){
                    if(cb.isWin()){     //si sceglie la carta piu conveniente con cui prendere
                        if(cb.isBriscola()){
                            if (cb.getPunti() != 11)
                                cb.setGiocabilita(100 + cb.getPunti());
                            else
                                cb.setGiocabilita(100);
                        }
                        else
                            cb.setGiocabilita(115 + cb.getPunti());
                    }
                    else if (nWin == 0) //se non puo prendere nulla si sceglie il meno peggio
                        cb.setGiocabilita(-cb.getPunti() -cb.getNumero()/2);
                }
            }
        }
        //------------------------------------------------
        //Capisce quale carta abbia piu punti scelta e in caso di partita la randomizza
        index = 0;
        int v = bMano.get(0).getGiocabilita();
        if(bMano.size() > 1) {
            for (int i = 1; i < bMano.size(); i++) {
                if (v == bMano.get(i).getGiocabilita() && rd.nextBoolean() || bMano.get(i).getGiocabilita() > v){
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
