package Gioco;

import Esperienza.Lingua;
import Esperienza.Tema;
import MainPackage.MainClass;
import com.sun.tools.javac.Main;

import java.awt.*;
import java.util.ArrayList;

public abstract class Partita implements Runnable {
    
    //STATIC - SETTINGS
    private static int difficolta = 0;

    public static String[] nomiGiocatori = {"g1", "g2","g3","g4"};

    private int NORMAL_TURN; //turni di gioco "normali"
    private int MATCH_STATE;    //fase della partita
    private final int semeBriscola;
    private int numGiocatori;

    private final Mazzo mazzo;
    private final ArrayList<Carta> banco;
    private final ArrayList<Squadra> squadre;
    private ArrayList<Entita> tuttiGiocatori;
    private final Chat chat;

    //TOOLS PARTITA
    private final Thread matchThread;

    //COSTRUTTORE PARTITA
    public Partita(int tipoPartita) {
        squadre = new ArrayList<>();
        banco = new ArrayList<>();
        mazzo = new Mazzo();
        mazzo.mischia();
        semeBriscola = mazzo.getDeck().getFirst().getSeme();
        chat = new Chat();
        
        //FASE 0, setup
        MATCH_STATE = 0;
        
        //COSTANTI COLORI di esempio
        String[] coloriSquadre = new String[]{Lingua.getStringhe(18), Lingua.getStringhe(19), Lingua.getStringhe(20)};
        
        switch (tipoPartita) {
            case 0:
                squadre.add(new Squadra(coloriSquadre[0], Tema.getRosso()));
                squadre.add(new Squadra(coloriSquadre[1], Tema.getBlu()));
                NORMAL_TURN = 17;
                numGiocatori = 2;
                break;
            case 1:
                squadre.add(new Squadra(coloriSquadre[0],Tema.getRosso()));
                squadre.add(new Squadra(coloriSquadre[1],Tema.getBlu()));
                NORMAL_TURN = 7;
                numGiocatori = 4;
                break;
            case 2:
            case 3:
                squadre.add(new Squadra(coloriSquadre[0],Tema.getRosso()));
                squadre.add(new Squadra(coloriSquadre[1],Tema.getBlu()));
                squadre.add(new Squadra(coloriSquadre[2],Tema.getGiallo()));
                NORMAL_TURN = 10;
                numGiocatori = 3;
                break;
            case 4:
                //NON PENSIAMO DI FARLA
                numGiocatori = 5;
                break;
        }

        //assegnazione THREAD al metodo RUN della classe
        matchThread = new Thread(this);
        
        //METODO DI SETUP appartenente a MP o SP
        setupGameMode();
        
        //START THREAD
        matchThread.start();
    }

    public abstract void setupGameMode();
    
    public void formazioneGiocatori() {
        tuttiGiocatori = new ArrayList<>();
        for (int g = 0; g < squadre.getFirst().getGiocatori().size(); g++) {
            for (int s = 0; s < squadre.size(); s++) {
                tuttiGiocatori.add(squadre.get(s).getGiocatori().get(g));
            }
        }
    }
    
    public void distribuisci(){
        for (int i = 0; i < 3; i++) {
            for (int g = 0; g < getSquadre().getFirst().getGiocatori().size(); g++) {
                for (int s = 0; s < getSquadre().size(); s++) {
                    getSquadre().get(s).getGiocatori().get(g).prendiCarta(getMazzo().pesca());
                }
            }
        }
    }
    
    //DEPRECATED
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
    
    private int vincitoreScontro(Carta cartaBase, Carta cartaSopra){
        int indice = 0;        
        
        if (cartaBase.getSeme() == cartaSopra.getSeme()) {
            if ((cartaBase.getPunti() < cartaSopra.getPunti()) || (cartaBase.getPunti() == cartaSopra.getPunti() && cartaBase.getNumero() < cartaSopra.getNumero())) {
                indice = 1;
            }
        } else if (cartaSopra.getSeme() == semeBriscola) {
            indice = 1;
        }
        return indice;
    }
    
    private int vincitoreScontro(ArrayList<Carta> banco){
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
        
        //INIZIO PARTITA
        
        //FASE 1, gioco
        MATCH_STATE = 1;
        Entita giocatoreChePrende;
        
        int sfasamento = 0;
        int x; //giocatore puntato

        //turni di gioco "finali"
        int FINAL_TURN = 3;
        int turno;
        
        for (turno = 0; turno < NORMAL_TURN + FINAL_TURN; turno++){
            banco.clear();
            for (int i = sfasamento; i < tuttiGiocatori.size() + sfasamento; i++) {
                
                if (turno == NORMAL_TURN){
                    MATCH_STATE = 2;
                }
                
                x = i;
                if (x >= tuttiGiocatori.size()){
                    x -= tuttiGiocatori.size();
                }
                
                //TEMPO DI SLEEP PRIMA DI ASSEGNARE IL TURNO
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                
                tuttiGiocatori.get(x).assegnaTurno();
                
                if (tuttiGiocatori.get(x) instanceof Bot){
                    try {
                        Thread.sleep(300); //tempo pensiero del bot
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                
                Carta carta = null;
                while (carta == null) {
                    carta = tuttiGiocatori.get(x).giocaCarta();
                }
                
                banco.add(carta);
                
                //aggiornamento memoria bot
                if (tuttiGiocatori.get(x) instanceof Giocatore && this instanceof PartitaSP && banco.size() == 2) {
                    Bot bot = (Bot) getSquadre().get(1).getGiocatori().getFirst();
                    bot.aggiornaMemoria(banco.get(1));
                }
                
                tuttiGiocatori.get(x).finalizaTurno();
            }
            
            //RITROVAMENTO INDICE DEL VINCITORE e PRESA DEI PUNTI NELLA SUA SQUADRA
            sfasamento = vincitoreScontro(banco) + sfasamento;
            if (sfasamento >= tuttiGiocatori.size()) {
                sfasamento -= tuttiGiocatori.size();
            }            
            
            //vincitore
            giocatoreChePrende = tuttiGiocatori.get(sfasamento);

            try {
                Thread.sleep(800); //TEMPO DI ATTESA VISUALIZZAZIONE CARTE
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            giocatoreChePrende.getSquadra().prendiBanco(banco);
            
            //PESCA CARTE x TURNO SUCCESSIVO
            
            if (turno < NORMAL_TURN){
                for (int i = sfasamento; i < tuttiGiocatori.size() + sfasamento; i++){
                    x = i;
                    if (x >= tuttiGiocatori.size()){
                        x -= tuttiGiocatori.size();
                    }
                    tuttiGiocatori.get(x).prendiCarta(getMazzo().pesca());
                }
            }
        }
        
        banco.clear();
        //FASE 3, la conta
        MATCH_STATE = 3;
        
        // operazioni eseguite nei vari thread
        
        boolean finito = false;
        while (!finito){
            finito = true;
            for (Entita giocatore : tuttiGiocatori) {
                if (giocatore instanceof Giocatore){
                    if (!((Giocatore) giocatore).isFINISHED()) {
                        finito = false;
                    }
                }
            }
        }
        
        MainClass.main(null);
    }
    
    public Mazzo getMazzo() {
        return mazzo;
    }

    public Carta getCartaBriscola() {
        return mazzo.getDeck().getFirst();
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

    public ArrayList<Squadra> getSquadre() {
        return squadre;
    }

    public int getMATCH_STATE() {
        return MATCH_STATE;
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public static int getDifficolta() {
        return difficolta;
    }

    public static void setDifficolta(int difficolta) {
        Partita.difficolta = difficolta;
    }

    public static String[] getNomiGiocatori() {
        return nomiGiocatori;
    }

    public Chat getChat() {
        return chat;
    }
    
    public void chiusuraForzata (){
        for (Squadra squadra : squadre) {
            for (Entita giocatore : squadra.getGiocatori()) {
                if (giocatore instanceof Giocatore) {
                    ((Giocatore) giocatore).chiusuraForzata();
                }
            }
        }
        
        matchThread.interrupt();
    }

    public ArrayList<Entita> getTuttiGiocatori() {
        return tuttiGiocatori;
    }
}
