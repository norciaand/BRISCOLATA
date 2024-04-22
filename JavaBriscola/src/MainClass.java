import Title.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class MainClass {
    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
//        FlatMacLightLaf.setup();
//        FlatDarkLaf.setup();
//        FlatLightLaf.setup();
        new TitleMenu();
    }
}