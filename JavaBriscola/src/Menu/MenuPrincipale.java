package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipale extends FrameMenu {
    public MenuPrincipale() throws HeadlessException {
        super("MENU PRINCIPALE");
        setLayout(new BorderLayout());

        JPanel centerPanel =  new JPanel();
        centerPanel.setLayout(new GridLayout(5,0, 20,10));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("BRISCOLATA"); // passa a immagine
        titlePanel.setLayout(new GridBagLayout());
        titleLabel.setFont(new Font("Arial",Font.PLAIN,20));
        titlePanel.add(titleLabel);
        
        JButton spButton = new JButton("SinglePlayer");
        JPanel spPanel = new JPanel();
        spPanel.add(spButton);
        spPanel.setLayout(new GridBagLayout());
        
        JButton mpButton = new JButton("MultiPlayer");
        JPanel mpPanel = new JPanel();
        mpPanel.add(mpButton);
        mpPanel.setLayout(new GridBagLayout());

        JButton opButton = new JButton("Opzioni");
        JPanel opPanel = new JPanel();
        opPanel.add(opButton);
        opPanel.setLayout(new GridBagLayout());

        JButton crButton = new JButton("Credit");
        JPanel crPanel = new JPanel();
        crPanel.add(crButton);
        crPanel.setLayout(new GridBagLayout());

        centerPanel.add(titlePanel);
        centerPanel.add(spPanel);
        centerPanel.add(mpPanel);
        centerPanel.add(opPanel);
        centerPanel.add(crPanel);

        add(centerPanel, BorderLayout.CENTER);

        spButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuSP();
                dispose();
            }
        });

        mpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMP();
                dispose();
            }
        });

        opButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuOpzioni();
                dispose();
            }
        });

        crButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuCrediti();
                dispose();
            }
        });
    }
}
