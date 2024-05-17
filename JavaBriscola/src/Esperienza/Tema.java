package Esperienza;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatPropertiesLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.nimbus.NimbusStyle;
import java.awt.*;

public class Tema {
    
    private static final Color rosso = new Color(221, 87, 70);
    private static final Color blu = new Color(0, 141, 218);
    private static final Color giallo = new Color(249, 232, 151);
    
    private static String tipoCarta;
    
    private static Color sfondoChat;
    private static int tema;
    private static int regione;
    
    public static void setupTema(int tema, int regione){
        Tema.tema = tema;
        Tema.regione = regione;
        if (tema == 0) {
            FlatMacLightLaf.setup();
            sfondoChat = new Color(255, 255, 255, 50);
        } else {
            FlatMacDarkLaf.setup();
            sfondoChat = new Color(0, 0, 0, 50);
        }
        
        switch (regione) {
            case 0:
                tipoCarta = "/napoletane/";
                break;
            case 1:
            default:
                tipoCarta = "/piacentine/";
                break;
            case 2:
                tipoCarta = "/siciliane/";
                break;
        }
    }

    public static Color getSfondoChat() {
        return sfondoChat;
    }

    public static Color getRosso() {
        return rosso;
    }

    public static Color getBlu() {
        return blu;
    }

    public static Color getGiallo() {
        return giallo;
    }

    public static String getTipoCarta() {
        return tipoCarta;
    }

    public static int getTema() {
        return tema;
    }

    public static int getRegione() {
        return regione;
    }

    public static void setTema(int tema) {
        Tema.tema = tema;
    }

    public static void setRegione(int regione) {
        Tema.regione = regione;
    }
}
