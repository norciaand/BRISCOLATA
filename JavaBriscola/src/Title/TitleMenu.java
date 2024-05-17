package Title;

import Esperienza.Lingua;
import Gioco.PartitaMP;
import Gioco.PartitaSP;

import java.awt.*;

public class TitleMenu extends MyMenu {

    public TitleMenu() {
        super("BRISCOLATA");
        mpPanel.setVisible(false);
    }
    
    public void initComponents() {

        mpPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        p2Button = new javax.swing.JButton();
        p4Button = new javax.swing.JButton();
        p3Button = new javax.swing.JButton();
        p3bButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spButton = new javax.swing.JButton();
        mpButton = new javax.swing.JButton();
        crButton = new javax.swing.JButton();
        opButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Briscolata");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        jLabel2.setFont(new java.awt.Font("Utendo", Font.BOLD, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(Lingua.getStringhe(1));
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        p2Button.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        p2Button.setText(Lingua.getStringhe(4));
        p2Button.addActionListener(this::p2ButtonActionPerformed);

        p4Button.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        p4Button.setText(Lingua.getStringhe(5));
        p4Button.addActionListener(this::p4ButtonActionPerformed);

        p3Button.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        p3Button.setText(Lingua.getStringhe(6));
        p3Button.addActionListener(this::p3ButtonActionPerformed);

        p3bButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        p3bButton.setText(Lingua.getStringhe(7));
        p3bButton.addActionListener(this::p3bButtonActionPerformed);

        backButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        backButton.setText(Lingua.getStringhe(8));
        backButton.addActionListener(this::backButtonActionPerformed);

        javax.swing.GroupLayout mpPanelLayout = new javax.swing.GroupLayout(mpPanel);
        mpPanel.setLayout(mpPanelLayout);
        mpPanelLayout.setHorizontalGroup(
            mpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpPanelLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addGroup(mpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(p4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mpPanelLayout.createSequentialGroup()
                            .addComponent(p3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p3bButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        mpPanelLayout.setVerticalGroup(
            mpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpPanelLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(p2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3bButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jLabel1.setFont(new java.awt.Font("Utendo", Font.BOLD, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BRISCOLATA");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        spButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        spButton.setText(Lingua.getStringhe(0));
        spButton.addActionListener(this::spButtonActionPerformed);

        mpButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        mpButton.setText(Lingua.getStringhe(1));
        mpButton.addActionListener(this::mpButtonActionPerformed);

        crButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        crButton.setText(Lingua.getStringhe(2));
        crButton.addActionListener(this::crButtonActionPerformed);

        opButton.setFont(new java.awt.Font("Courier New", Font.PLAIN, 14)); // NOI18N
        opButton.setText(Lingua.getStringhe(3));
        opButton.addActionListener(this::opButtonActionPerformed);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spButton, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crButton, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opButton, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, crButton, jLabel1, mpButton, opButton, spButton);

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(spButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, crButton, mpButton, opButton, spButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }

    private void spButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new PartitaSP();
        dispose();
    }

    private void mpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainPanel.setVisible(false);
        mpPanel.setVisible(true);
    }

    private void crButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void opButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new Settings(this);
    }

    private void p2ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new PartitaMP(0);
        dispose();
    }

    private void p4ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new PartitaMP(1);
        dispose();
    }

    private void p3ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new PartitaMP(2);
        dispose();
    }

    private void p3bButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new PartitaMP(3);
        dispose();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mpPanel.setVisible(false);
        mainPanel.setVisible(true);
    }
    

    // Variables declaration 
    private javax.swing.JButton backButton;
    private javax.swing.JButton crButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton mpButton;
    private javax.swing.JPanel mpPanel;
    private javax.swing.JButton opButton;
    private javax.swing.JButton p2Button;
    private javax.swing.JButton p3Button;
    private javax.swing.JButton p3bButton;
    private javax.swing.JButton p4Button;
    private javax.swing.JButton spButton;
    // End of variables declaration//GEN-END:variables
}
