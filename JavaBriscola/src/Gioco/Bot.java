package Gioco;
import java.util.ArrayList;
import java.util.Random;


public class Bot extends Entita{
    private Mazzo memoria;
    private ArrayList<Carta> mano = new ArrayList<>();
    Random rd = new Random();
    Carta lastEnemy = null;     //quando il nemico gioca per secondo questa carta va settata con la carta giocata da lui;
    Carta lastFirstBot = null;
    private int strategia = 0;
    private int distanza = 0;
    private int difficult = 0;

    public Bot(String nome,Squadra squadra, Partita p,int difficult) {
        super(nome, squadra, p);
        this.difficult = difficult;
        memoria = new Mazzo();
    }

    @Override
    public void prendiCarta(Carta x) {
        mano.add(x);
        memoria.getDeck().remove(x);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }


    //DOPO OGNI GIOCATA di un giocatore
    public void aggiornaMemoria(Carta x){       //da implementare nel game loop quando l'avversario gioca per secondo
        this.memoria.getDeck().remove(x);

        lastEnemy = x;
    }


    //GIOCATA DELLA CARTA
    @Override
    public Carta giocaCarta(){
        /*
        Appunti
          aggiungi parte fase finale per quando giochi per secondo e per primo
          questa parte deve essere praticamente perfetta serve la supervisione di cammo
        */

        //Dichiarazione base
        Carta x;
        ArrayList<CartaBot> bMano = new ArrayList<>();
        int nBri = 0;
        boolean conStrate = true;
        int index;
        //creazione array CartaBot
        for (Carta c : mano){
            System.out.println(c.toString());
            CartaBot cb = new CartaBot(c.getSeme(), c.getNumero());
            if (c.getSeme() == getPartita().getSemeBriscola()){
                cb.setBriscola(true);
                nBri++;
            }else
                cb.setBriscola(false);
            cb.setLiscio(c.getPunti() == 0 && !cb.isBriscola());
            bMano.add(cb);
            //quante carte possono mangiare la carta considerando lo stesso seme;
            for(Carta b : memoria.getDeck()){
                if(c.getSeme() == b.getSeme())
                    if(getPartita().scontro(c , b) < 0)
                        cb.setnCarPred(cb.getnCarPred() + 1);
            }
        }
        //------------------------------------------------
        //normale
        if(difficult == 0){
            System.out.println("difficolta normale");
            //se si e primi di mano
            if (getPartita().getAllBanco().isEmpty()) {
                //se e la primissima mano si cerca di far prendere al avversario
                if (getPartita().getMazzo1().getSize() == 34) {
                    for (CartaBot cb : bMano) {
                        if (cb.getPunti() >= 1 && cb.getPunti() <= 4 && !cb.isBriscola())      //punticini non di briscola
                            cb.setGiocabilita(100 - cb.getPunti());
                        else if (cb.getPunti() == 0 && !cb.isBriscola())                   //lisci non briscola
                            cb.setGiocabilita(85 - cb.getNumero());
                        else if (cb.getPunti() == 0)                                        //lisci briscola
                            cb.setGiocabilita(70 - cb.getNumero());
                        else if (cb.getPunti() <= 4)                                          //punticini briscola
                            cb.setGiocabilita(50 - cb.getPunti());
                        else if (cb.getPunti() >= 10)                                       //carichi non briscola
                            cb.setGiocabilita(30 - cb.getPunti());
                    }
                }
                //procedura se ottenere o meno lultima carta
                else if (getPartita().getMazzo1().getDeck().size() == 2) {
                    for (CartaBot cb : bMano) {
                        if (getPartita().getMazzo1().getDeck().getFirst().getPunti() >= cb.getPunti() || !cb.isBriscola() && cb.getPunti() < 10)
                            if (!cb.isBriscola() && cb.getPunti() < 10)
                                cb.setGiocabilita(100 + cb.getPunti());
                            else
                                cb.setGiocabilita(-cb.getPunti() * 2 - cb.getNumero() / 2);
                        else
                            cb.setGiocabilita(-40 - cb.getPunti() * 2 - cb.getNumero() / 2);
                    }
                } else if (getPartita().getMazzo1().getDeck().isEmpty()) {
                    if (bMano.size() == 3) {
                        //da fare
                    } else if (bMano.size() == 2) {
                        //da fare
                    }
                }
                //situazione emergenza laversario non deve mai prendere punti
                //aggiungi else prima del if qunado le 2 sopra saranno concluse
                if (getPartita().getSquadres().getFirst().calcoloPunti() >= 49) {
                    for (CartaBot cb : bMano) {
                        if (cb.isBriscola()) {
                            //liscio briscola top
                            if (cb.isLiscio())
                                cb.setGiocabilita(85 + cb.getnCarPred());
                                //non gioco carico bri a caso
                            else if (cb.getPunti() >= 10)
                                cb.setGiocabilita(-70 + cb.getnCarPred());
                                //punti bri meglio di no ma se proprio
                            else
                                cb.setGiocabilita(50 - cb.getnCarPred());
                        } else {
                            if (cb.isLiscio()) {
                                int car = 0;
                                int ves = 0;
                                for (Carta c : memoria.getDeck()) {
                                    if (c.getSeme() == cb.getSeme()) {
                                        if (c.getPunti() >= 10)
                                            car++;
                                        else if (c.getPunti() > 0)
                                            ves++;
                                    }
                                }
                                if (car == 0 && ves == 0)
                                    cb.setGiocabilita(100 + cb.getnCarPred());
                                else if (car == 0)
                                    cb.setGiocabilita(70 - ves);
                                else
                                    cb.setGiocabilita(-30 - ves - car * 5);
                            } else if (cb.getPunti() >= 10)
                                cb.setGiocabilita(100 - cb.getPunti());
                            else
                                cb.setGiocabilita(10 - cb.getnCarPred());
                        }
                    }
                } else {
                    //strategia
                    if (strategia == 0) {
                        for (CartaBot cb : bMano) {
                            for (CartaBot cb2 : bMano) {
                                if ((cb.getPunti() >= 2 && cb.getPunti() <= 4) && cb2.isLiscio() && cb.getSeme() == cb2.getSeme()) {
                                    strategia = 1;
                                    cb2.setGiocabilita(100 + cb.getnCarPred());
                                    conStrate = false;
                                    break;
                                }
                            }
                        }
                    } else if (strategia == 1 && distanza <= 2) {
                        strategia = 0;
                        for (CartaBot cb : bMano) {
                            if (cb.getPunti() >= 2 && cb.getPunti() <= 4 && cb.getSeme() == lastFirstBot.getSeme()) {
                                cb.setGiocabilita(120 - cb.getPunti() + cb.getnCarPred());
                                strategia = 0;
                                distanza = 0;
                                conStrate = false;
                                break;
                            }
                        }
                    } else {
                        conStrate = true;
                        strategia = 0;
                        distanza = 0;
                    }
                    //svolgimento classico
                    if (conStrate) {
                        for (CartaBot cb : bMano) {
                            if (cb.isBriscola()) {
                                cb.setGiocabilita(-10);
                                if (nBri == 0)
                                    cb.setGiocabilita(-10);
                            }
                            if (cb.getPunti() > 0 && cb.getPunti() <= 4 && !cb.isBriscola())
                                cb.setGiocabilita(100 - cb.getnCarPred());
                            else if (cb.isLiscio())
                                cb.setGiocabilita(70 + cb.getnCarPred());
                            else if (cb.getPunti() > 0 && cb.getPunti() <= 4 && cb.isBriscola())
                                cb.setGiocabilita(40 - cb.getnCarPred());
                            else if (cb.getPunti() >= 10)
                                cb.setGiocabilita(-10 - cb.getnCarPred());
                        }
                    }
                }
            }
            //se si e secondi di mano
            else {
                //rimuove dalla memoria la carta messa dal aversario
                memoria.getDeck().remove(getPartita().getBanco(0));
                //controllo se ci sono carte vincenti
                for (CartaBot cb : bMano) {
                    if (getPartita().scontro(getPartita().getBanco(0), mano.get(bMano.indexOf(cb))) < 0)
                        cb.setWin(true);
                }
                //fine paritta
                if (getPartita().getMazzo1().getDeck().size() == 2) {
                    //la voglio devo perdere

                    //non la voglio devo vincere
                } else if (getPartita().getMazzo1().getDeck().isEmpty()) {
                    if (bMano.size() == 3) {
                        //da fare
                    } else if (bMano.size() == 2) {
                        //da fare
                    }
                }
                //situazione emergenza laversario non deve mai prendere punti
                //aggiungi else prima del if qunado le 2 sopra saranno concluse
                if (getPartita().getSquadres().getFirst().calcoloPunti() >= 49) {
                    if (getPartita().getBanco(0).getPunti() == 0) {
                        for (CartaBot cb : bMano) {
                            if (cb.isWin()) {
                                if (cb.isBriscola()) {
                                    if (cb.isLiscio())
                                        cb.setGiocabilita(50 + cb.getnCarPred());
                                    else if (cb.getPunti() >= 10)
                                        cb.setGiocabilita(-80 - cb.getnCarPred());
                                    else
                                        cb.setGiocabilita(30 + cb.getPunti());
                                } else {
                                    if (cb.isLiscio())
                                        cb.setGiocabilita(70 + cb.getnCarPred());
                                    else
                                        cb.setGiocabilita(100 + cb.getPunti());
                                }
                            } else {
                                if (cb.isBriscola()) {
                                    if (cb.isLiscio())
                                        cb.setGiocabilita(75 - cb.getnCarPred());
                                    else if (cb.getPunti() >= 10)
                                        cb.setGiocabilita(-95);
                                    else
                                        cb.setGiocabilita(-80 - cb.getnCarPred());
                                } else {
                                    if (cb.isLiscio())
                                        cb.setGiocabilita(90 - cb.getnCarPred());
                                    else if (cb.getPunti() >= 10)
                                        cb.setGiocabilita(-90 - cb.getnCarPred());
                                    else
                                        cb.setGiocabilita(-70 - cb.getnCarPred());
                                }
                            }
                        }
                    } else {
                        for (CartaBot cb : bMano) {
                            if (cb.isWin()) {
                                if (cb.isBriscola()) {
                                    cb.setGiocabilita(50 + cb.getnCarPred());
                                } else {
                                    cb.setGiocabilita(100 + cb.getPunti());
                                }
                            } else {
                                if (cb.isBriscola() && cb.getPunti() == 10)
                                    cb.setGiocabilita(-100);
                                cb.setGiocabilita(-cb.getPunti());
                            }
                        }
                    }
                }
                //partita normale
                //se laversario gioca liscio
                else if (getPartita().getBanco(0).getPunti() == 0) {
                    for (CartaBot cb : bMano) {
                        if (cb.isWin()) {
                            //briscole
                            if (cb.isBriscola())
                                cb.setGiocabilita(-50 + cb.getnCarPred());       //si evita di usare briscole per carte lisce caso peggiore
                                //non briscole
                            else {
                                //carichi vincenti
                                if (cb.getPunti() >= 10)
                                    cb.setGiocabilita(120 + cb.getPunti());     //si approfitta per fare tanti punti
                                    //lsici vincenti
                                else if (cb.isLiscio())
                                    cb.setGiocabilita(-10 + cb.getnCarPred());  //non ha senso dover giocare per primi senza aver guadagnato
                                    //punticini vincenti
                                else
                                    cb.setGiocabilita(40 + cb.getPunti());      //meglio prendere con punticini se propio
                            }
                        }
                        //carte perdenti da preferire per far giocare laversario per primo se non si hanno punti interesanti
                        else {
                            if (cb.isBriscola())
                                cb.setGiocabilita(30 + cb.getnCarPred());
                            else {
                                //evitare di ussare carichi
                                if (cb.getPunti() >= 10)
                                    cb.setGiocabilita(-70 + cb.getnCarPred());
                                    //meglio dar liscio miglior caso
                                else if (cb.isLiscio())
                                    cb.setGiocabilita(100 + cb.getnCarPred());
                                    //punticini se proprio proprio
                                else
                                    cb.setGiocabilita(90 - cb.getnCarPred());
                            }
                        }
                    }
                }
                //se laversario gioca punticini
                else if (getPartita().getBanco(0).getPunti() > 0 && getPartita().getBanco(0).getPunti() <= 4) {
                    for (CartaBot cb : bMano) {
                        if (cb.isWin()) {
                            if (cb.isBriscola()) {
                                if (cb.getPunti() >= 10)
                                    cb.setGiocabilita(-120 + cb.getnCarPred());
                                else if (cb.getPunti() + getPartita().getBanco(0).getPunti() >= 5 && nBri > 1)
                                    cb.setGiocabilita(70 + cb.getnCarPred());
                                else
                                    cb.setGiocabilita(-70 + cb.getnCarPred());
                            } else {
                                if (cb.getPunti() >= 10)
                                    cb.setGiocabilita(100 - cb.getnCarPred());
                                else if (cb.isLiscio())
                                    cb.setGiocabilita(20 + cb.getPunti());
                                else if (cb.getPunti() + getPartita().getBanco(0).getPunti() >= 5)
                                    cb.setGiocabilita(85 + cb.getnCarPred());
                                else
                                    cb.setGiocabilita(50 + cb.getnCarPred());
                            }
                        }
                        //perde
                        else {
                            if (cb.isBriscola()) {
                                cb.setGiocabilita(-80 + cb.getnCarPred());
                            } else {
                                if (cb.getPunti() >= 10)
                                    cb.setGiocabilita(-100 + cb.getnCarPred());
                                else if (cb.isLiscio())
                                    cb.setGiocabilita(70 + cb.getnCarPred());
                                else
                                    cb.setGiocabilita(cb.getnCarPred());
                            }
                        }
                    }
                }
                //in caso giochi carichi
                else if (getPartita().getBanco(0).getPunti() >= 10) {
                    for (CartaBot cb : bMano) {
                        if (cb.isWin()) {     //si sceglie la carta piu conveniente con cui prendere
                            if (cb.isBriscola())
                                if (cb.getPunti() <= 10)
                                    cb.setGiocabilita(100 + cb.getPunti());
                                else
                                    cb.setGiocabilita(80);
                            else
                                cb.setGiocabilita(120 + cb.getPunti());
                        } else {
                            cb.setGiocabilita(-cb.getPunti());
                        }
                    }
                    for (CartaBot cb : bMano) {
                        for (CartaBot cb2 : bMano) {
                            if (cb.getPunti() == cb2.getPunti()) {
                                if (cb.isBriscola())
                                    cb.setGiocabilita(-1);
                                else if (cb2.isBriscola())
                                    cb.setGiocabilita(-1);
                                else if (cb.getnCarPred() > cb2.getnCarPred())
                                    cb.setGiocabilita(1);
                                else
                                    cb.setGiocabilita(1);
                            }
                        }
                    }
                }
            }
        }
        //_______________________________________________
        //facile
        else if(difficult == 1){
            System.out.println("difficolta facile");
            if(getPartita().getAllBanco().isEmpty()){
                for (CartaBot cb : bMano){
                    if(cb.getPunti() >= 10 && cb.isBriscola())
                        cb.setGiocabilita(- cb.getPunti());
                    else if(cb.isBriscola())
                        cb.setGiocabilita(50 - cb.getPunti());
                    else{
                        cb.setGiocabilita(100-cb.getPunti());
                        if(cb.getPunti() >= 10)
                            cb.setGiocabilita(-90);
                    }
                }
            }else{
                for (CartaBot cb : bMano) {
                    if (getPartita().scontro(getPartita().getBanco(0), mano.get(bMano.indexOf(cb))) < 0)
                        cb.setWin(true);
                }
                for(CartaBot cb : bMano){
                    if(cb.isWin()){
                        cb.setGiocabilita(+cb.getPunti());
                    }
                    else{
                        cb.setGiocabilita(-cb.getPunti());
                    }
                }
                for (CartaBot cb : bMano) {
                    for (CartaBot cb2 : bMano) {
                        if(cb.getPunti() == cb2.getPunti() && cb.isWin() && cb2.isWin()) {
                            if (cb.isBriscola())
                                cb.setGiocabilita(-1);
                            else if (cb2.isBriscola())
                                cb.setGiocabilita(-1);
                        }
                    }
                }
            }
        }
        //se dificolata ha un valore diverso si randomiza diretamente quindi e una cazzata
        //------------------------------------------------
        //Capisce quale carta abbia piu punti scelta e in caso di partita la randomizza
        index = 0;
        int v = bMano.getFirst().getGiocabilita();
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
        distanza++;
        if(getPartita().getAllBanco().isEmpty())
            lastFirstBot = x;
        mano.remove(x);
        return x;
    }

    @Override
    public void assegnaTurno() {

    }

    @Override
    public void finalizaTurno() {

    }
}