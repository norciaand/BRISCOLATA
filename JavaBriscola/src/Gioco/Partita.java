package Gioco;

import java.util.ArrayList;

public abstract class Partita {

    private final String[] coloriSquadre = {"Rossa", "Blu", "Verde"};

    private Mazzo mazzo1; //mazzo della partita
    private int tipoPartita; // 0: 1v1 | 1: 2v2 | 2: 1v1v1 | 3: 1v1v1 BASTARDA | 4: b5
    private int nPlayer;

    public ArrayList<Squadra> squadres;
    private ArrayList<Carta> banco;
    
    public Partita(int tipoPartita) {
        squadres = new ArrayList<>();
        this.tipoPartita = tipoPartita;
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
    }
    
    public void matchLoop(){
        ArrayList<Carta> carteAppoggiate = new ArrayList<>();
        
        int s = 0;
        int g = 0;
        
        for (g = 0; g < squadres.get(0).getGiocatores().size(); g++){
            for (s = 0; s < squadres.size(); s++) {
                System.out.println("G" + g + "S" + s);
                while (true){
                    if (squadres.get(s).getGiocatores().get(g).giocaCarta() != null){
                        carteAppoggiate.add(squadres.get(s).getGiocatores().get(g).giocaCarta());
                        break;
                    }
                }
            }
        }        
    }
    
    

    //SCONTRO 1v1
    public int scontro2(Carta cartaBase, Carta cartaSopra) {
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

    public void setTipoPartita(int tipoPartita) {
        this.tipoPartita = tipoPartita;
    }

    public int getnPlayer() {
        return nPlayer;
    }

    public void setnPlayer(int nPlayer) {
        this.nPlayer = nPlayer;
    }

    public Mazzo getMazzo1() {
        return mazzo1;
    }

    public void setMazzo1(Mazzo mazzo1) {
        this.mazzo1 = mazzo1;
    }

    public Carta getBanco(int index) {
        return banco.get(index);
    }

    public void setBanco(ArrayList<Carta> banco) {
        this.banco = banco;
    }

    public int getSemeBriscola(){
        return mazzo1.semeBriscola();
    }
    
    public Carta getCartaBriscola() {
        return mazzo1.getDeck().get(0);
    }


}
