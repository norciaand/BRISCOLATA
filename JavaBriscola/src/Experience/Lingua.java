package Experience;

import java.io.*;
import java.util.Objects;

public class Lingua {

    private static String[] stringhe;
    
    private static int lang;

    public static void setupLingua(int lang) throws IOException {
        
        Lingua.lang = lang;
        InputStream allText;
        
        if (Lingua.lang == 0){
            allText = Lingua.class.getResourceAsStream("/lingue/en-US.briscolata");
        } else {
            allText = Lingua.class.getResourceAsStream("/lingue/it-IT.briscolata");
        }
        
        stringhe = new BufferedReader(new InputStreamReader(Objects.requireNonNull(allText))).lines().toArray(String[]::new);
    }

    public static String getStringhe(int index) {
        return stringhe[index];
    }

    public static int getLang() {
        return lang;
    }

    public static void setLang(int lang) {
        Lingua.lang = lang;
    }
}
