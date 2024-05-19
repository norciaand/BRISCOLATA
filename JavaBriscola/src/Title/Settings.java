package Title;

import Experience.Lingua;
import Experience.Tema;
import Game.Partita;
import MainPackage.MainClass;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Settings extends JFrame {
    
    private final JFrame parent;
    
    public Settings(JFrame parent) {
        initComponents();
        this.parent = parent;
        slider.setValue(Partita.getDifficolta());
        p1Field.setText(Partita.getNomiGiocatori()[0]);
        p2Field.setText(Partita.getNomiGiocatori()[1]);
        p3Field.setText(Partita.getNomiGiocatori()[2]);
        p4Field.setText(Partita.getNomiGiocatori()[3]);
        slider.setValue(Partita.getDifficolta());
        
        
        switch (Tema.getRegione()){
            case 0:
                napoletane.setSelected(true);
                break;
            case 1:
                piacentine.setSelected(true);
                break;
            case 2:
                siciliane.setSelected(true);
                break;
        }
        
        if (Lingua.getLang() == 0){
            engRadio.setSelected(true);
        } else {
            ItRadio.setSelected(true);
        }
        
        if (Tema.getTema() == 0) {
            lightRadio.setSelected(true);
        } else {
            darkRadio.setSelected(true);
        }
        
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents() {
        langGroup = new javax.swing.ButtonGroup();
        themeGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        game = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p1Field = new javax.swing.JTextField();
        p2Field = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        p3Field = new javax.swing.JTextField();
        p4Field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ui = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        engRadio = new javax.swing.JRadioButton();
        ItRadio = new javax.swing.JRadioButton();
        lightRadio = new javax.swing.JRadioButton();
        darkRadio = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        napoletane = new javax.swing.JRadioButton();
        siciliane = new javax.swing.JRadioButton();
        piacentine = new javax.swing.JRadioButton();
        import_settings = new javax.swing.JPanel();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel4.setText(Lingua.getStringhe(9));

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel5.setText(Lingua.getStringhe(13));

        slider.setMaximum(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setValue(0);
        slider.setInverted(true);

        jLabel7.setText(Lingua.getStringhe(10));

        jLabel8.setText(Lingua.getStringhe(11));

        jLabel9.setText(Lingua.getStringhe(12));

        jLabel6.setText("1:");

        jLabel10.setText("2:");

        jLabel11.setText("3:");

        p3Field.setToolTipText("");

        jLabel12.setText("4:");

        javax.swing.GroupLayout gameLayout = new javax.swing.GroupLayout(game);
        game.setLayout(gameLayout);
        gameLayout.setHorizontalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(gameLayout.createSequentialGroup()
                                    .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(p3Field)
                                        .addComponent(p4Field, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                                .addGroup(gameLayout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(p2Field)))
                            .addComponent(slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(gameLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(p1Field))
                                .addGroup(gameLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(gameLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(157, 157, 157)))
                .addGap(16, 16, 16))
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(p1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(p2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(p3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(p4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab(Lingua.getStringhe(25), game);

        jLabel13.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel13.setText(Lingua.getStringhe(21));

        jLabel14.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel14.setText(Lingua.getStringhe(22));

        langGroup.add(engRadio);
        engRadio.setText("English");

        langGroup.add(ItRadio);
        ItRadio.setText("Italiano");

        themeGroup.add(lightRadio);
        lightRadio.setText(Lingua.getStringhe(28));

        themeGroup.add(darkRadio);
        darkRadio.setText(Lingua.getStringhe(29));

        jLabel15.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel15.setText(Lingua.getStringhe(30));

        buttonGroup1.add(napoletane);
        napoletane.setText("Napoletane");

        buttonGroup1.add(siciliane);
        siciliane.setText("Siciliane");

        buttonGroup1.add(piacentine);
        piacentine.setText("Piacentine");

        javax.swing.GroupLayout uiLayout = new javax.swing.GroupLayout(ui);
        ui.setLayout(uiLayout);
        uiLayout.setHorizontalGroup(
            uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(darkRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lightRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(uiLayout.createSequentialGroup()
                        .addComponent(ItRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(piacentine, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(uiLayout.createSequentialGroup()
                        .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(engRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(uiLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(napoletane, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addGroup(uiLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(siciliane, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        uiLayout.setVerticalGroup(
            uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12)
                .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(engRadio)
                    .addComponent(napoletane))
                .addGap(5, 5, 5)
                .addGroup(uiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItRadio)
                    .addComponent(piacentine))
                .addGap(5, 5, 5)
                .addComponent(siciliane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lightRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(darkRadio)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(Lingua.getStringhe(26), ui);

        importButton.setText(Lingua.getStringhe(23));
        importButton.addActionListener(this::importButtonActionPerformed);

        exportButton.setText(Lingua.getStringhe(24));
        exportButton.addActionListener(this::exportButtonActionPerformed);

        javax.swing.GroupLayout import_settingsLayout = new javax.swing.GroupLayout(import_settings);
        import_settings.setLayout(import_settingsLayout);
        import_settingsLayout.setHorizontalGroup(
            import_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, import_settingsLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(import_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        import_settingsLayout.setVerticalGroup(
            import_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(import_settingsLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportButton)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(Lingua.getStringhe(27), import_settings);

        jLabel1.setFont(new java.awt.Font("Utendo", Font.BOLD, 24)); // NOI18N
        jLabel1.setText(Lingua.getStringhe(3));

        saveButton.setText(Lingua.getStringhe(14));
        saveButton.addActionListener(this::saveButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void scrittoreFile (BufferedWriter bufferedWriter){
        try {
            bufferedWriter.write(Lingua.getLang() + "\n");
            bufferedWriter.write(Tema.getTema() + "\n");
            bufferedWriter.write(Partita.getDifficolta() + "\n");
            bufferedWriter.write(Tema.getRegione() + "\n");
            for (int i = 0; i < Partita.getNomiGiocatori().length; i++) {
                bufferedWriter.write(Partita.getNomiGiocatori()[i]+"\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Partita.setDifficolta(slider.getValue());
        
        Partita.getNomiGiocatori()[0] = p1Field.getText();
        Partita.getNomiGiocatori()[1] = p2Field.getText();
        Partita.getNomiGiocatori()[2] = p3Field.getText();
        Partita.getNomiGiocatori()[3] = p4Field.getText();
        
        if (napoletane.isSelected()) {
            Tema.setRegione(0);
        }
        else if (piacentine.isSelected()) {
            Tema.setRegione(1);
        }
        else {
            Tema.setRegione(2);
        }
        
        if (engRadio.isSelected()) {
            Lingua.setLang(0);
        } else {
            Lingua.setLang(1);
        }
        
        if (lightRadio.isSelected()) {
            Tema.setTema(0);
        } else {
            Tema.setTema(1);
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter  = new BufferedWriter(new FileWriter("settings.briscolata"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        scrittoreFile(bufferedWriter);
        
        dispose();
        parent.dispose();
        MainClass.main();
    }

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt)  {
        
        JFileChooser fc = new JFileChooser();
        int flag = fc.showOpenDialog(this);
        if(flag == JFileChooser.APPROVE_OPTION) {

            String nomeGiocatore;
            int nGiocatori = 0;

            File f = fc.getSelectedFile();

            FileReader fr;
            try {
                fr = new FileReader(f);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw;
            try {
                fw = new FileWriter("settings.briscolata");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            
            
            try {
                Lingua.setLang(Integer.parseInt(br.readLine()));
                Tema.setTema(Integer.parseInt(br.readLine()));
                Partita.setDifficolta(Integer.parseInt(br.readLine()));
                Tema.setRegione(Integer.parseInt(br.readLine()));
                while((nomeGiocatore = br.readLine()) != null){
                    Partita.setNomiGiocatori(nomeGiocatore,nGiocatori);
                    nGiocatori++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            scrittoreFile(bw);
            
            try {
                fr.close();
                br.close();
                fw.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
            JOptionPane.showMessageDialog(this  , "File selezionato non valido" , "ERRORE" , JOptionPane.ERROR_MESSAGE);
        MainClass.main();
    }

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String sourceFilePath = "settings.briscolata";

        // Apri il file chooser per selezionare la directory di destinazione
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();

            //percorso completo per il file di destinazione
            File sourceFile = new File(sourceFilePath);
            File destFile = new File(selectedDirectory, sourceFile.getName());

            // Copia il file
            try {
                Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            JOptionPane.showMessageDialog(this  , "Esportazione fallita" , "ERRORE" , JOptionPane.ERROR_MESSAGE);
        }
    }

    private javax.swing.JRadioButton ItRadio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton darkRadio;
    private javax.swing.JRadioButton engRadio;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel game;
    private javax.swing.JButton importButton;
    private javax.swing.JPanel import_settings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.ButtonGroup langGroup;
    private javax.swing.JRadioButton lightRadio;
    private javax.swing.JRadioButton napoletane;
    private javax.swing.JTextField p1Field;
    private javax.swing.JTextField p2Field;
    private javax.swing.JTextField p3Field;
    private javax.swing.JTextField p4Field;
    private javax.swing.JRadioButton piacentine;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton siciliane;
    private javax.swing.JSlider slider;
    private javax.swing.ButtonGroup themeGroup;
    private javax.swing.JPanel ui;
}
