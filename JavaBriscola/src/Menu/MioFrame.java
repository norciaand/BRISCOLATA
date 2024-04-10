package Menu;

import javax.swing.*;
import java.awt.*;

public abstract class MioFrame extends JFrame {
    public MioFrame(String title) throws HeadlessException {
        super(title);
        setResizable(false);
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
