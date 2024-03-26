package Menu;

import javax.swing.*;
import java.awt.*;

public abstract class FrameMenu extends JFrame {
    public FrameMenu(String title) throws HeadlessException {
        super(title);
        setResizable(false);
        setVisible(true);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
