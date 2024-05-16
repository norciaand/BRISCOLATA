package MainPackage;

import Esperienza.Lingua;
import Esperienza.Tema;
import Title.*;


import java.io.IOException;

public class MainClass {
    
    public static void main(String[] args) {
        
        //TODO LETTURA DA FILE
        
        
        //TEMA
        Tema.setupTema(1,0); //0-1: tema chiaro o scuro, 0-2 napoletane piacentine o siciliane

        //LINGUA
        try {
            Lingua.setupLingua(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //MENU
        new TitleMenu();
        
    }
}