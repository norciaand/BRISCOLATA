package Esperienza;


import java.io.*;
import java.util.Objects;

public class Lingua {

    private static final String[] stringhe = new String[21];
    
    private static int lang;

    public static void setupLingua(int lang) throws IOException {
        
        Lingua.lang = lang;
        InputStream allText;
        
        if (Lingua.lang == 0){
            allText = Lingua.class.getResourceAsStream("/lingue/en-US.briscolata");
        } else {
            allText = Lingua.class.getResourceAsStream("/lingue/it-IT.briscolata");
        }

        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(allText)));
        String linea;
        int c = 0;
        while ((linea = bufferedReader.readLine()) != null){
            stringhe[c] = linea;
            c++;
        }
    }

    public static String getStringhe(int index) {
        return stringhe[index];
    }

    public static int getLang() {
        return lang;
    }
}
