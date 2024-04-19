package Gioco;

import java.util.ArrayList;

public abstract class Partita implements Runnable {

    //COSTANTI COLORI
    private final String[] coloriSquadre = {"Rossa", "Blu", "Verde"};
    public final String[] nomiGiocatori = {"Andrea", "Alessandro","Giovanni","Filippo"}; //ESEMPIO
    
    //INFO PARTITA
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    private int nPlayer;

    private Mazzo mazzo1; //MAZZO DELLA PARTITA
    private ArrayList<Carta> banco;
    private ArrayList<Squadra> squadres;

    //TOOLS PARTITA
    private Thread matchThread;

    //COSTRUTTORE PARTITA
    public Partita(int tipoPartita) {
        this.tipoPartita = tipoPartita;
        squadres = new ArrayList<>();
        banco = new ArrayList<>();
        mazzo1 = new Mazzo();
        mazzo1.mischia();

        switch (tipoPartita) {
            case 0:
                nPlayer = 2;
                squadres.add(new Squadra(coloriSquadre[0]));
                squadres.add(new Squadra(coloriSquadre[1]));
                break;
            case 1:
                nPlayer = 4;
                squadres.add(new Squadra(coloriSquadre[0]));
                squadres.add(new Squadra(coloriSquadre[1]));
                break;
            case 2:
            case 3:
                nPlayer = 3;
                squadres.add(new Squadra(coloriSquadre[0]));
                squadres.add(new Squadra(coloriSquadre[1]));
                squadres.add(new Squadra(coloriSquadre[2]));
                break;
            case 4:
                //NON PENSIAMO DI FARLA
                nPlayer = 5;
                break;
        }

        //assegnazione THREAD al metodo RUN della classe
        matchThread = new Thread(this);

        //METODO DI SETUP appartenente a MP o SP
        setup();
        
        //START THREAD
        matchThread.start();

        
    }

    public abstract void setup();

    //SCONTRO 1v1
    public int scontro(Carta cartaBase, Carta cartaSopra) {
        int risultato = cartaBase.getPunti() + cartaSopra.getPunti();
        if (risultato == 0) risultato = 1;

        if (cartaBase.getSeme() == cartaSopra.getSeme()) {
            if ((cartaBase.getPunti() < cartaSopra.getPunti()) || (cartaBase.getPunti() == cartaSopra.getPunti() && cartaBase.getNumero() < cartaSopra.getNumero())) {
                risultato *= -1;
            }
        } else if (cartaSopra.getSeme() == mazzo1.semeBriscola()) {
            risultato *= -1;
        }
        return risultato;
    }


    //FUCNTION MATCH THREAD
    @Override
    public void run() {
        
        /*
        *   INIZIO TURNO
        */

        int t = 0;
        
//        while (matchThread != null) {}
        
        
        int s = 0;
        int g = 0;

        for (g = 0; g < squadres.getFirst().getGiocatores().size(); g++){
            for (s = 0; s < squadres.size(); s++) {

                //DEBUG A CHI TOCCA GIOCARE LA CARTA
                System.out.println("G" + g + "S" + s);

                Carta carta = null;
                while (carta == null) {
                    carta = squadres.get(s).getGiocatores().get(g).giocaCarta();
                }
                banco.add(carta);
                
            }
        }
    }



    public int getnPlayer() {
        return nPlayer;
    }

    public Mazzo getMazzo1() {
        return mazzo1;
    }

    public Carta getCartaBriscola() {
        return mazzo1.getDeck().getFirst();
    }

    public int getSemeBriscola(){
        return mazzo1.semeBriscola();
    }

    
    public Carta getBanco(int index) {
        return banco.get(index);
    }

    public ArrayList<Carta> getAllBanco() {
        return banco;
    }

    public ArrayList<Squadra> getSquadres() {
        return squadres;
    }
    
}
