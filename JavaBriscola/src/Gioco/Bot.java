package Gioco;
import java.util.ArrayList;
import java.util.Random;


public class Bot{
    private Mazzo memoria;
    private ArrayList<Carta> mano = new ArrayList<>();
    Random rd = new Random();
    Carta lastEnemy = null;     //quando il nemico gioca per secondo questa carta va settata con la carta giocata da lui;
    private String nome;
    private int difficolta;

    public Bot(String nome, int difficolta) {
        this.nome = nome;
        this.difficolta = difficolta;
        memoria = new Mazzo();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void aggiornaMemoria(Carta x){       //da implementare nel game loop quando laversario gioca per secondo
        this.memoria.getDeck().remove(x);
        lastEnemy = x;
    }

    public void prendiBot(Carta x){
        mano.add(x);
        memoria.getDeck().remove(x);
    }

    public Carta giocaBot(boolean firstMano , PartitaSP p){

        /*
        Appunti


        */

        //Dichiarazione base
        Carta x;
        ArrayList<CartaBot> bMano = new ArrayList<>();
        int nBri = 0;
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
            cb.setLiscio(c.getPunti() == 0 && !cb.isBriscola());
            bMano.add(cb);
        }
        //------------------------------------------------
        //considerazioni sempre vere
        if(nBri == 1){
            for (CartaBot cb:bMano){
                if(cb.isBriscola())
                    cb.setGiocabilita(-15);
            }
        }
        //se si e primi di mano
        if(firstMano){
            //se e la primisima mano si cerca di far prendere al aversario
            if(p.getMazzo1().getSize() == 33){
                for(CartaBot cb:bMano){
                    if(cb.getPunti()>=1 && cb.getPunti()<=4 && !cb.isBriscola())      //punticini non di briscola
                        cb.setGiocabilita(100 - cb.getPunti());
                    else if(cb.getPunti() == 0 && !cb.isBriscola())                   //lisci non briscola
                        cb.setGiocabilita(85 - cb.getNumero());
                    else if(cb.getPunti() == 0)                                        //lisci briscola
                        cb.setGiocabilita(70 - cb.getNumero());
                    else if(cb.getPunti()<=4)                                          //punticini brisccola
                        cb.setGiocabilita(50 - cb.getPunti());
                    else if(cb.getPunti() >= 10)                                       //carichi non briscola
                        cb.setGiocabilita(30 - cb.getPunti());
                }
            }
            else if(p.getMazzo1().getDeck().size() == 2){
                //se la penultima carta e meglio del'ultima si cerca di vincere per averla
                if(p.getCartaBriscola().getPunti() < p.getMazzo1().getDeck().get(1).getPunti() && p.getMazzo1().getDeck().get(1).getSeme() == p.getSemeBriscola()){

                }
                else{

                }
            }
            else if(p.getMazzo1().getDeck().isEmpty()){
                if(bMano.size() == 3){

                }
                else if(bMano.size() == 2){

                }
            }
            else{

            }
        }
        //se si e secondi di mano
        else{
            //rimuove dalla memoria la carta messa dal aversario
            memoria.getDeck().remove(p.getBanco(0));
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
                        cb.setGiocabilita(100 -cb.getPunti() - cb.getNumero()/2);
                    else if(cb.isWin())                             //se non si puo lasciare si prendono piu punti possibile
                        if(cb.isBriscola())
                            cb.setGiocabilita(85 -cb.getPunti() - cb.getNumero()/2);
                        else
                            cb.setGiocabilita(85 + cb.getPunti());
                }
            }
            //se laversario gioca punticini
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
