package Gioco;

import java.util.ArrayList;

public abstract class Partita implements Runnable {

    //COSTANTI COLORI di esempio
    private final String[] coloriSquadre = {"Rossa", "Blu", "Verde"};
    public final String[] nomiGiocatori = {"Andrea", "Alessandro","Giovanni","Filippo"};
    
    //INFO PARTITA
    private final int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    private int nPlayer;
    private int NORMAL_TURN;
    private final int FINAL_TURN = 3;
    private int MATCH_STATE;
    private final int semeBriscola;

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
        semeBriscola = mazzo1.getDeck().getFirst().getSeme();
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
                NORMAL_TURN = 10;
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
    
    public void distribuisci(){
        for (int i = 0; i < 3; i++) {
            for (int g = 0; g < getSquadres().getFirst().getGiocatores().size(); g++) {
                for (int s = 0; s < getSquadres().size(); s++) {
                    getSquadres().get(s).getGiocatores().get(g).prendiCarta(getMazzo1().pesca());
                }
            }
        }
    }
    
    //SCONTRO 1v1
    public int scontro(Carta cartaBase, Carta cartaSopra) {
        int risultato = cartaBase.getPunti() + cartaSopra.getPunti();
        if (risultato == 0) risultato = 1;

        if (cartaBase.getSeme() == cartaSopra.getSeme()) {
            
            if ((cartaBase.getPunti() < cartaSopra.getPunti()) || (cartaBase.getPunti() == cartaSopra.getPunti() && cartaBase.getNumero() < cartaSopra.getNumero())) {
                risultato *= -1;
            }
            
        } else if (cartaSopra.getSeme() == semeBriscola) {
            risultato *= -1;
        }
        return risultato;
    }
    
    //SECONDA FUNZIONE SCONTRO DI PROVA
    public int vincitoreScontro(Carta cartaBase, Carta cartaSopra){
        int indice = 0;        
        
        if (cartaBase.getSeme() == cartaSopra.getSeme()) {;
            if ((cartaBase.getPunti() < cartaSopra.getPunti()) || (cartaBase.getPunti() == cartaSopra.getPunti() && cartaBase.getNumero() < cartaSopra.getNumero())) {
                indice = 1;
            }
        } else if (cartaSopra.getSeme() == semeBriscola) {
            indice = 1;;
        }
        return indice;
    }
    
    public int vincitoreScontro(ArrayList<Carta> banco){
        int indice = 0;
        
        for (int x = 0; x < banco.size()-1; x++) {

            if (vincitoreScontro(banco.get(indice),banco.get(x+1)) == 1)
                indice = x + 1;

        }
        
        return indice;
    }


    //FUCNTION MATCH THREAD
    @Override
    public void run() {
        /*
        *   INIZIO PARTITA
        */
        MATCH_STATE = 1;
        int s,g;
        Entita giocatoreChePrende;
        final ArrayList<Entita> tuttiGiocatori = new ArrayList<>();
        for (g = 0; g < squadres.getFirst().getGiocatores().size(); g++) {
            for (s = 0; s < squadres.size(); s++) {
                tuttiGiocatori.add(squadres.get(s).getGiocatores().get(g));
            }
        }
        
        int sfasamento = 0;
        int x;
            
        for (int t = 0; t < NORMAL_TURN; t++){
            banco.clear();
            
            for (int i = sfasamento; i < tuttiGiocatori.size() + sfasamento; i++) {
                x = i;
                if (x >= tuttiGiocatori.size()){
                    x -= tuttiGiocatori.size();
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                
                tuttiGiocatori.get(x).assegnaTurno();
                
                if (tuttiGiocatori.get(x) instanceof Bot){
                    try {
                        Thread.sleep(300); //aumentiamo il delay del bot
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (i == sfasamento + 1){
                        System.out.println("AGGIORNA MEMORIA BOT");
                        ((Bot) tuttiGiocatori.get(x)).aggiornaMemoria(banco.getFirst());
                    }
                }
                
                Carta carta = null;
                while (carta == null) {
                    carta = tuttiGiocatori.get(x).giocaCarta();
                }
                
                banco.add(carta);

                tuttiGiocatori.get(x).finalizaTurno();
                
                
            }
            //RITROVAMENTO INDICE DEL VINCITORE e PRESA DEI PUNTI NELLA SUA SQUADRA
            sfasamento = vincitoreScontro(banco) + sfasamento;
            if (sfasamento >= tuttiGiocatori.size()) {
                sfasamento -= tuttiGiocatori.size();
            }            
            
            giocatoreChePrende = tuttiGiocatori.get(sfasamento);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            giocatoreChePrende.getSquadra().prendiBanco(banco);
            
            //PESCA CARTE x TURNO SUCCESSIVO
            for (int i = sfasamento; i < tuttiGiocatori.size() + sfasamento; i++){
                x = i;
                if (x >= tuttiGiocatori.size()){
                    x -= tuttiGiocatori.size();
                }
                tuttiGiocatori.get(x).prendiCarta(getMazzo1().pesca());
            }
        }
        /*
        * ESAURIMENTO DEL MAZZO, inizio endgame
        * */
        
        //IMPONIAMO AI FORM DI NON MOSTRARE PIU LA BRISCOLA E IL MAZZO
        //TURNI FINALI
        
        
        MATCH_STATE = 2;

        for (int t = 0; t < FINAL_TURN; t++){
            banco.clear();

            for (int i = sfasamento; i < tuttiGiocatori.size() + sfasamento; i++) {
                x = i;
                if (x >= tuttiGiocatori.size()){
                    x -= tuttiGiocatori.size();
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                tuttiGiocatori.get(x).assegnaTurno();

                Carta carta = null;
                while (carta == null) {
                    carta = tuttiGiocatori.get(x).giocaCarta();
                }
                banco.add(carta);

                tuttiGiocatori.get(x).finalizaTurno();

            }
            //RITROVAMENTO INDICE DEL VINCITORE e PRESA DEI PUNTI NELLA SUA SQUADRA
            sfasamento = vincitoreScontro(banco) + sfasamento;
            if (sfasamento >= tuttiGiocatori.size()) {
                sfasamento -= tuttiGiocatori.size();
            }
            
            giocatoreChePrende = tuttiGiocatori.get(sfasamento);
            System.out.println("GIOCATORE VINCENTE " + giocatoreChePrende.getNome());
            giocatoreChePrende.getSquadra().prendiBanco(banco);

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
        return semeBriscola;
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
