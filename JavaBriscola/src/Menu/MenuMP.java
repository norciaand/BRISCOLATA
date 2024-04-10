package Menu;

import Gioco.PartitaMP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMP extends MioFrame {
    public MenuMP() throws HeadlessException {
        super("MP");
        setLayout(new BorderLayout());
        
        JPanel centerPanel =  new JPanel();
        centerPanel.setLayout(new GridLayout(7,0, 20,10));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("MULTY PLAYER");
        titlePanel.setLayout(new GridBagLayout());
        titleLabel.setFont(new Font("Arial",Font.PLAIN,20));
        titlePanel.add(titleLabel);

        JButton m1v1_Button = new JButton("1 vs 1");
        JPanel m1v1_Panel = new JPanel();
        m1v1_Panel.add(m1v1_Button);
        m1v1_Panel.setLayout(new GridBagLayout());

        JButton mBB_Button = new JButton("Briscola Bastarda");
        JPanel mBB_Panel = new JPanel();
        mBB_Panel.add(mBB_Button);
        mBB_Panel.setLayout(new GridBagLayout());

        JButton m1v1v1_Button = new JButton("1 vs 1 vs 1");
        JPanel m1v1v1_Panel = new JPanel();
        m1v1v1_Panel.add(m1v1v1_Button);
        m1v1v1_Panel.setLayout(new GridBagLayout());

        JButton m2v2_Button = new JButton("2 vs 2");
        JPanel m2v2_Panel = new JPanel();
        m2v2_Panel.add(m2v2_Button);
        m2v2_Panel.setLayout(new GridBagLayout());

        JButton a5_Button = new JButton("Briscola 5");
        JPanel a5_Panel = new JPanel();
        a5_Panel.add(a5_Button);
        a5_Panel.setLayout(new GridBagLayout());

        JButton GTS_Button = new JButton("Indietro");
        JPanel GTS_Panel = new JPanel();
        GTS_Panel.add(GTS_Button);
        GTS_Panel.setLayout(new GridBagLayout());

        centerPanel.add(titlePanel);
        centerPanel.add(m1v1_Panel);
        centerPanel.add(mBB_Panel);
        centerPanel.add(m1v1v1_Panel);
        centerPanel.add(m2v2_Panel);
        centerPanel.add(a5_Panel);
        centerPanel.add(GTS_Panel);

        add(centerPanel, BorderLayout.CENTER);

        m1v1_Button.addActionListener(new ActionListener() {           //Listener delle 1v1
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartitaMP(0);
                dispose();
            }
        });

        mBB_Button.addActionListener(new ActionListener() {             //Listener briscola bastarda
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartitaMP(3);
                dispose();
            }
        });
        m1v1v1_Button.addActionListener(new ActionListener() {          //listener briscola a 3
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartitaMP(2);
                dispose();
            }
        });
        m2v2_Button.addActionListener(new ActionListener() {            //listener briscola a 4
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartitaMP(1);
                dispose();
            }
        });
        a5_Button.addActionListener(new ActionListener() {          //Listener Briscola a 5
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        GTS_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        setVisible(true);
    }
}
