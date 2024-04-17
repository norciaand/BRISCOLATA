package Gioco;

import java.util.ArrayList;

public abstract class Partita implements Runnable {
    
    //COSTANTI COLORI
    private final String[] coloriSquadre = {"Rossa", "Blu", "Verde"};
    
    //INFO PARTITA
    private Mazzo mazzo1; //MAZZO DELLA PARTITA
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    private int nPlayer;
    private ArrayList<Carta> banco;
    
    //TOOLS PARTITA
    private Thread matchThread;
    private ArrayList<Squadra> squadres;
    
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
                nPlayer = 5;
                break;
        }
        
        matchThread = new Thread(this);
    }

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
    
    public int getTipoPartita() {
        return tipoPartita;
    }

    public int getnPlayer() {
        return nPlayer;
    }

    public Mazzo getMazzo1() {
        return mazzo1;
    }
    
    public Carta getBanco(int index) {
        return banco.get(index);
    }

    public ArrayList<Carta> getAllBanco() {
        return banco;
    }

    public int getSemeBriscola(){
        return mazzo1.semeBriscola();
    }
    
    public Carta getCartaBriscola() {
        return mazzo1.getDeck().get(0);
    }

    public ArrayList<Squadra> getSquadres() {
        return squadres;
    }

    public Thread getMatchThread() {
        return matchThread;
    }
    
    //FUCNTION MATCH THREAD
    @Override
    public void run() {
        
        int s = 0;
        int g = 0;
        
        for (g = 0; g < squadres.get(0).getGiocatores().size(); g++){
            for (s = 0; s < squadres.size(); s++) {
                
                //DEBUG A CHI TOCCA
                System.out.println("G" + g + "S" + s);
                
                Carta carta = null;
                while (carta == null){
                    carta = squadres.get(s).getGiocatores().get(g).giocaCarta();
                }
                banco.add(carta);
                
                for (Squadra squadra : squadres){
                    for (Giocatore giocatore : squadra.getGiocatores()){
                        
                    }
                }
                
            }
        }
        
    }
}
