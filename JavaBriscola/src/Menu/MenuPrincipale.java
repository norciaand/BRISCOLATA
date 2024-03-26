package Menu;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipale extends FrameMenu {
    public MenuPrincipale() throws HeadlessException {
        super("MENU PRINCIPALE");
        setLayout(new BorderLayout());

        JPanel pannelloTitolo = new JPanel();
        JLabel title = new JLabel("BRISCOLATA");
        pannelloTitolo.add(title);
        
        add(pannelloTitolo, BorderLayout.NORTH);
        
        
    }
}
