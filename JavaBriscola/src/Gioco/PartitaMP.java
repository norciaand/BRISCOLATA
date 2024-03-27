package Gioco;

public class PartitaMP extends Partita{

    Mazzo mazzo = new Mazzo();

    public PartitaMP(int nPlayer) {
        super(nPlayer);
        Bot bot = new Bot(mazzo);
    }
}
