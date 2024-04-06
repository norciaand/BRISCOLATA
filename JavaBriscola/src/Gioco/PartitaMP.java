package Gioco;


public class PartitaMP extends Partita{
    
    public PartitaMP(int tipoPartita) {
        super(tipoPartita);
        GameFrame[] gameFrames = new GameFrame[getnPlayer()];
        
        for (int i = 0; i < getnPlayer(); i++)
        {
            gameFrames[i] = new GameFrame();
            gameFrames[i].setBounds(60+500*i, 60+60*i+60, 800, 500);
        }
        
        
        
    }
    
    
}
