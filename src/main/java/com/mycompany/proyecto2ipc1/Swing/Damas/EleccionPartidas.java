package com.mycompany.proyecto2ipc1.Swing.Damas;

import com.mycompany.proyecto2ipc1.Swing.Damas.Users.MainWindow;
import com.mycompany.proyecto2ipc1.Swing.Damas.Users.Users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EleccionPartidas extends javax.swing.JFrame {

    private MainWindow mainWindow;

    private Users users;

    private int damas1[][] = new int[8][8];

    public EleccionPartidas(MainWindow mainWindow, Users users) {
        this.users = users;
        this.mainWindow = mainWindow;
        initComponents();
        this.jTextField1.setText("BIENVENID@ " + users.getFirstName().trim());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGame = new javax.swing.JButton();
        LoadGame = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        newGame.setText("Nueva Partida");
        newGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newGameMouseClicked(evt);
            }
        });
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        LoadGame.setText("Cargar Partida");
        LoadGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoadGameMouseClicked(evt);
            }
        });
        LoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadGameActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoadGame)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(newGame)
                .addGap(28, 28, 28)
                .addComponent(LoadGame)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameMouseClicked
        new Principal(mainWindow, users);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        mainWindow.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void LoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadGameActionPerformed

    private void LoadGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadGameMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("*.TXT", "txt"));
        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            String name = users.getFirstName().trim()+".txt";
            String fileName = fichero.getName().trim();
            if (fileName.equals(name)) {
                try {
                    //File file2 = new File(directorioUsuarios + "Usuarios" + ".html");
                    //if (file2.exists()) {
                    FileReader file = new FileReader(fichero);
                    BufferedReader lectura = new BufferedReader(file);
                    String cadena = "";

                    int tabla[][] = new int[8][8];
                    int i = 0;
                    while ((cadena = lectura.readLine()) != null) {
                        if (cadena != null) {
                            String[] vectorCadena = cadena.split(",");
                            for (int j = 0; j < 8; j++) {
                                tabla[i][j] = Integer.parseInt(vectorCadena[j].trim());
                            }
                            i++;
                        }

                    }
                    file.close();
                    lectura.close();
                    int cronometro[] = LoadCronometro();
                    int minutos = cronometro[0];
                    int segundos = cronometro[1];
                    new Principal(mainWindow, users, tabla, minutos, segundos);
                    this.dispose();
                    //}
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ERROR AL CARGAR FICHERO");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Partida Incorrecta \nEsta partida es de otro usuario");
            }
        }
    }//GEN-LAST:event_LoadGameMouseClicked

    private int[] LoadCronometro() { 
        
                    int tabla[] = new int[2];
                try {
                    String directorio = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/PartidasGuardadas/Cronometros/";
                    File file2 = new File(directorio+"Cronometro"+users.getFirstName().trim()+ ".txt");
                    //if (file2.exists()) {
                    FileReader file = new FileReader(file2);
                    BufferedReader lectura = new BufferedReader(file);
                    String cadena = "";

                    while ((cadena = lectura.readLine()) != null) {
                        if (cadena != null) {
                            String[] vectorCadena = cadena.split(",");
                            tabla[0]=Integer.parseInt(vectorCadena[0]);
                            tabla[1]=Integer.parseInt(vectorCadena[1]);
                        }

                    }
                    file.close();
                    lectura.close();
                    //}
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ERROR AL CARGAR FICHERO");
                }
                return tabla;
    } 
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadGame;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables
}
