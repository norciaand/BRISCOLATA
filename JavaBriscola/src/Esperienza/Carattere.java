package Esperienza;

import java.awt.*; 

public class Carattere {
    
    private static final Font plain20 =  new Font("Arial", Font.PLAIN, 14);
    private static final Font bold20 =  new Font("Arial", Font.BOLD, 14);
    private static final Font utendoBold20 =  new Font("Utendo", Font.BOLD, 20);
    private static final Font utendoBold100 =  new Font("Utendo", Font.BOLD, 100);
    private static final Font utendoBold30 =  new Font("Utendo", Font.BOLD, 30);

    public static Font getPlain20() {
        return plain20;
    }

    public static Font getBold20() {
        return bold20;
    }
    
    public static Font getUtendoBold20() {
        return utendoBold20;
    }
    
    public static Font getUtendoBold100() {
        return utendoBold100;
    }
    
    public static Font getUtendoBold30() {
        return utendoBold30;
    }
}
