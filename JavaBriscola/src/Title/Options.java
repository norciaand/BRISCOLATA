package Title;

import Esperienza.Lingua;
import Gioco.Partita;

import javax.swing.*;

public class Options extends javax.swing.JFrame {


    public Options(JFrame x) {
        initComponents();
        jSlider1.setValue(Partita.getDifficolta());
        giocatore1.setText(Partita.getNomiGiocatori()[0]);
        giocatore2.setText(Partita.getNomiGiocatori()[1]);
        giocatore3.setText(Partita.getNomiGiocatori()[2]);
        giocatore4.setText(Partita.getNomiGiocatori()[3]);
        setLocationRelativeTo(x);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }


    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        Facile = new javax.swing.JLabel();
        Facile1 = new javax.swing.JLabel();
        Facile2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        giocatore1 = new javax.swing.JTextField();
        giocatore2 = new javax.swing.JTextField();
        giocatore4 = new javax.swing.JTextField();
        giocatore3 = new javax.swing.JTextField();
        Facile3 = new javax.swing.JLabel();
        Facile4 = new javax.swing.JLabel();
        Facile5 = new javax.swing.JLabel();
        Facile6 = new javax.swing.JLabel();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Utendo", 1, 24)); // NOI18N
        jLabel1.setText(Lingua.getStringhe(3));

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(2);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(0);
        jSlider1.setInverted(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(Lingua.getStringhe(9));

        Facile.setText(Lingua.getStringhe(10));
        Facile.setToolTipText("");

        Facile1.setText(Lingua.getStringhe(11));
        Facile1.setToolTipText("");

        Facile2.setText(Lingua.getStringhe(12));
        Facile2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText(Lingua.getStringhe(13));

        Facile3.setText("G1");
        Facile3.setToolTipText("");

        Facile4.setText("G2");
        Facile4.setToolTipText("");

        Facile5.setText("G3");
        Facile5.setToolTipText("");

        Facile6.setText("G4");
        Facile6.setToolTipText("");

        save.setText(Lingua.getStringhe(14));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(Facile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Facile1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Facile2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Facile5)
                                .addGap(18, 18, 18)
                                .addComponent(giocatore3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Facile4)
                                .addGap(18, 18, 18)
                                .addComponent(giocatore2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Facile3)
                                .addGap(18, 18, 18)
                                .addComponent(giocatore1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Facile6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giocatore4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(save)
                                        .addGap(90, 90, 90)))))))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Facile)
                    .addComponent(Facile2)
                    .addComponent(Facile1))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(giocatore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Facile3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giocatore2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Facile4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giocatore3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Facile5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giocatore4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Facile6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {
        Partita.setDifficolta(jSlider1.getValue());
        Partita.getNomiGiocatori()[0] = giocatore1.getText();
        Partita.getNomiGiocatori()[1] = giocatore2.getText();
        Partita.getNomiGiocatori()[2] = giocatore3.getText();
        Partita.getNomiGiocatori()[3] = giocatore4.getText();
        dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Facile;
    private javax.swing.JLabel Facile1;
    private javax.swing.JLabel Facile2;
    private javax.swing.JLabel Facile3;
    private javax.swing.JLabel Facile4;
    private javax.swing.JLabel Facile5;
    private javax.swing.JLabel Facile6;
    private javax.swing.JTextField giocatore1;
    private javax.swing.JTextField giocatore2;
    private javax.swing.JTextField giocatore3;
    private javax.swing.JTextField giocatore4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
