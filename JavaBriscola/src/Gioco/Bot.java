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
        final int Sacrificabile = 50;
        Carta x = null;
        puntiMano = new ArrayList<>();
        int index = 0;

        //setta i punti scelta tutti a 0 e li crea in base al n carte
        for(int i = 0; i < mano.size();i++){
             puntiMano.add(0);
        }





        //se e il primo a giocare
        if(turno == 0){
            for(Carta c: mano){
                index = mano.indexOf(c);
                if(c.getPunti() == 11  || c.getPunti() == 10 || c.getPunti() == 4 && c.getSeme() == p.getSemeBriscola() || c.getPunti() == 3 && c.getSeme() == p.getSemeBriscola()){
                    puntiMano.set(index, puntiMano.get(index) - VittoriaCarta - c.getPunti());
                }


                //rivedere molt
                    if (c.getSeme() == p.getSemeBriscola() && c.getPunti() == 0) {
                        puntiMano.set(index, puntiMano.get(index) - c.getNumero() + 20);
                    } else {
                        puntiMano.set(index, puntiMano.get(index) + c.getNumero());
                    }

                //scolegato
            }
        }
        //se e il secondo
        else{
            for (Carta c: mano){
                index = mano.indexOf(c);
                //asegnamento punti alle carte vincenti
                if((p.scontro(p.getBanco(0) , c) < 0 && p.getBanco(0).getPunti() > 0 && c.getSeme() == p.getSemeBriscola() )||( p.scontro(p.getBanco(0) , c) < 0 && c.getSeme() != p.getSemeBriscola())){
                    puntiMano.set(index, puntiMano.get(index) + VittoriaCarta);
                    //si preferisce mantenere in mano le briscole piu grosse
                    if(c.getSeme() == p.getSemeBriscola()){
                        puntiMano.set(index, puntiMano.get(index) - c.getPunti()*5 - c.getNumero());
                    }
                    //al contrario e meglio ottenere subito i punti delle altre carte
                    else{
                        puntiMano.set(index, puntiMano.get(index) + c.getPunti()*2);
                    }
                }
                //assegnamento alle carte perdenti
                else{
                    //i lisci sono i piu sacrificabili
                    if(c.getPunti() == 0  && c.getSeme() != p.getSemeBriscola() ){
                        puntiMano.set(index, puntiMano.get(index) + Sacrificabile - c.getNumero());
                    }
                    //se non sono disponibili si sceglie il meno peggio
                    else{
                        puntiMano.set(index, puntiMano.get(index) - c.getPunti());
                        if(c.getPunti() == 0 && c.getSeme() == p.getSemeBriscola()){
                            puntiMano.set(index, puntiMano.get(index) - 2);
                        }else{
                            puntiMano.set(index, puntiMano.get(index) - c.getPunti());
                        }
                    }
                }
            }
        }
        //considerazioni sempre valide


        /*
        Appunti
        -per adesso piu da intendere come frammenti da riorganizare che come codice definitivo
        -fare in modo che in caso di licio si prefersica far vincere laversrario
        -fare in modo che mantenga briscole sui lisci ma prenda se altro seme
        -da riveder gestione briscole
        */




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
