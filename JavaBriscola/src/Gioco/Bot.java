package Gioco;
import java.util.ArrayList;
public class Bot extends Giocatore{

    ArrayList<Carta> memoria;

    public Bot() {
        super("Avversario");
    }

    public void PescataBot(Carta x){
        prendi(x);
        memoria.remove(x);
    }


}
