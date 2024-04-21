package Title;

import javax.swing.*;

public abstract class MyMenu extends JFrame {
    public MyMenu(String title) {
        setTitle(title);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public abstract void initComponents();
}
