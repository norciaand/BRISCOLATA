package Gioco;
import java.util.ArrayList;
public class Bot extends Giocatore{

    Mazzo memoria;

    public Bot(Mazzo memoria) {
        super("Avversario");
        this.memoria = memoria;
    }

    public void PescataBot(Carta x){
        Prendi(x);
        memoria.remove(x);
    }


}
