import Esperienza.Lingua;
import Title.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        
        //TEMA
        FlatMacDarkLaf.setup();
        
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