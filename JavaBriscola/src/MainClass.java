import Menu.*;
import Title.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class MainClass {
    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        new TitleMenu("BRISCOLATA");
    }
}