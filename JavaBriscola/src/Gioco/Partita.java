package Gioco;

import java.util.ArrayList;

public abstract class Partita implements Runnable {

    //COSTANTI COLORI
    private final String[] coloriSquadre = {"Rossa", "Blu", "Verde"};
    public final String[] nomiGiocatori = {"Andrea", "Alessandro","Giovanni","Filippo"}; //ESEMPIO
    
    //INFO PARTITA
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    private int nPlayer;
    private int NORMAL_TURN;
    private final int FINAL_TURN = 3;
    private int MATCH_STATE;

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
        MATCH_STATE = 0;
        switch (tipoPartita) {
            case 0:
                nPlayer = 2;
                squadres.add(new Squadra(coloriSquadre[0]));
                squadres.add(new Squadra(coloriSquadre[1]));
                NORMAL_TURN = 17;
                break;
            case 1:
                nPlayer = 4;
                squadres.add(new Squadra(coloriSquadre[0]));
                squadres.add(new Squadra(coloriSquadre[1]));
                NORMAL_TURN = 7;
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
        *   INIZIO PARTITA
        */
        
        int s,g;
        MATCH_STATE = 1;        
        for (int t = 0; t < NORMAL_TURN; t++){
            
            banco.clear();

            System.out.println("CARTE NEL MAZZO: " + getMazzo1().getSize());
            
            for (g = 0; g < squadres.getFirst().getGiocatores().size(); g++){
                for (s = 0; s < squadres.size(); s++) {

                    Carta carta = null;
                    while (carta == null) {
                        carta = squadres.get(s).getGiocatores().get(g).giocaCarta();
                    }
                    banco.add(carta);

                }
            }
            
            /*
            * SCONTRO EFFETTIVO DELLE CARTE, vedere implementazione
            * */

            for (g = 0; g < squadres.getFirst().getGiocatores().size(); g++) {
                for (s = 0; s < squadres.size(); s++) {
                    squadres.get(s).getGiocatores().get(g).prendi(getMazzo1().pesca());
                }
            }
            
        }
        
        /*
        * ESAURIMENTO DEL MAZZO, inizio endgame
        * */
        
        //IMPONIAMO AI FORM DI NON MOSTRARE PIU LA BRISCOLA E IL MAZZO
        
        MATCH_STATE = 2;
        /*
        * TURNI FINALI,
        * */
        
        for (int t = 0; t < FINAL_TURN; t++){
            
            banco.clear();

            System.out.println("CARTE NEL MAZZO: " + getMazzo1().getSize());

            for (g = 0; g < squadres.getFirst().getGiocatores().size(); g++){
                for (s = 0; s < squadres.size(); s++) {

                    Carta carta = null;
                    while (carta == null) {
                        carta = squadres.get(s).getGiocatores().get(g).giocaCarta();
                    }
                    banco.add(carta);

                }
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

    public int getMATCH_STATE() {
        return MATCH_STATE;
    }
}
