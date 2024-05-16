package MainPackage;

import Esperienza.Lingua;
import Esperienza.Tema;
import Title.*;


import java.io.IOException;

public class MainClass {
    
    public static boolean playing = false;
    
    public static void main(String[] args) {
        
        playing = true;
        //TEMA
        Tema.setupTema(1,0); //0-1: tema chiaro o scuro, 0-2 napoletane piacentine o siciliane

        //LINGUA
        try {
            Lingua.setupLanguage(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //MENU
        new TitleMenu();
        
    }
}