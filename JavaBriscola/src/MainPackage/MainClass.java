package MainPackage;

import Esperienza.Lingua;
import Esperienza.Tema;
import Gioco.Partita;
import Title.*;


import java.io.*;

public class MainClass {
    
    public static void main(String[] args) {
        
        BufferedReader bufferedReader;
        int lingua = 0, tema = 1, difficolta = 0, regione = 0;
        
        File file = new File("settings.briscolata");
        if (file.exists()){
            
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                lingua = Integer.parseInt(bufferedReader.readLine());
                tema = Integer.parseInt(bufferedReader.readLine());
                difficolta = Integer.parseInt(bufferedReader.readLine());
                regione = Integer.parseInt(bufferedReader.readLine());
                for (int i = 0; i < Partita.getNomiGiocatori().length; i++){
                    Partita.getNomiGiocatori()[i] = bufferedReader.readLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
        } 
        
        Partita.setDifficolta(difficolta);
        
        //TEMA
        Tema.setupTema(tema,regione); //0-1: tema chiaro o scuro, 0-2 napoletane piacentine o siciliane

        //LINGUA
        try {
            Lingua.setupLingua(lingua);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //MENU
        new TitleMenu();
        
    }
}