/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.PrincipalMain;
import com.mycompany.proyecto2ipc1.Swing.Damas.Principal;
import com.mycompany.proyecto2ipc1.Swing.Damas.Users.ArrayUsers;
import com.mycompany.proyecto2ipc1.Swing.Damas.Users.MainWindow;
import com.mycompany.proyecto2ipc1.Swing.Hanoi.MainHanoi;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class PrincipalMain extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalMain
     */
    
    
    private ArrayUsers arrayUser = new ArrayUsers();
    private String directorioUsuarios = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/Usuarios/";
    
    public PrincipalMain() {
        initComponents();
        verificarArchivos();
        this.setLocationRelativeTo(null);
        imagenes();
        this.setVisible(true);
    }

    public void imagenes(){
        //Imagen Label Bienvenido
        ImageIcon imagenes = new ImageIcon("/home/alvin/NetBeansProjects/Proyecto2Ipc1/Imagenes/Bienvenido.jpeg");
        this.LabelWelcome.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(255, 100, Image.SCALE_SMOOTH)));
        
        //Imagen Boton Damas
        imagenes = new ImageIcon("/home/alvin/NetBeansProjects/Proyecto2Ipc1/Imagenes/damas.png");
        //this.ButtonDamas.setBorderPainted(false);
        this.ButtonDamas.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        
        //Imagen Boton Hanoi
        imagenes = new ImageIcon("/home/alvin/NetBeansProjects/Proyecto2Ipc1/Imagenes/Hanoi.jpg");
        //this.ButtonHanoi.setBorderPainted(false);
        this.ButtonHanoi.setIcon(new ImageIcon(imagenes.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        
        //Imagen de fondo
        this.jPanel1.setBackground(Color.black);
        
    }
    
    public void verificarArchivos() {
        try {
            //File file2 = new File(directorioUsuarios + "Usuarios" + ".html");
            //if (file2.exists()) {
            FileReader file = new FileReader(directorioUsuarios + "Usuarios" + ".txt");
            BufferedReader lectura = new BufferedReader(file);
            String cadena = "";
            while ((cadena = lectura.readLine()) != null) {
                if (cadena != null) {
                    String[] vectorCadena = cadena.split(",");
                    String valName = vectorCadena[1];
                    String valLastName = vectorCadena[2].trim();
                    arrayUser.addUser(valName, valLastName);
                }

            }
            file.close();
            lectura.close();
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se encontro fichero");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelWelcome = new javax.swing.JLabel();
        LabelJuegos = new javax.swing.JLabel();
        LabelJuego1 = new javax.swing.JLabel();
        LabelJuego2 = new javax.swing.JLabel();
        ButtonDamas = new javax.swing.JButton();
        ButtonHanoi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelJuegos.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        LabelJuegos.setForeground(new java.awt.Color(255, 255, 255));
        LabelJuegos.setText("Juegos");

        LabelJuego1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        LabelJuego1.setForeground(new java.awt.Color(204, 204, 255));
        LabelJuego1.setText("Damas");

        LabelJuego2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        LabelJuego2.setForeground(new java.awt.Color(204, 204, 255));
        LabelJuego2.setText("Hanoi");

        ButtonDamas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonDamasMouseClicked(evt);
            }
        });
        ButtonDamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDamasActionPerformed(evt);
            }
        });

        ButtonHanoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHanoiActionPerformed(evt);
            }
        });

        jButton1.setText("SALIR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButtonReportes.setText("Reportes");
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(LabelJuegos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelJuego2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelJuego1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonDamas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonHanoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonReportes)
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(LabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonDamas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(LabelJuego1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonHanoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(LabelJuego2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonReportes))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDamasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonDamasActionPerformed

    private void ButtonHanoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHanoiActionPerformed
        this.setVisible(false);
        new MainWindow(arrayUser, this, 2);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonHanoiActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void ButtonDamasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDamasMouseClicked
        this.setVisible(false);
        new MainWindow(arrayUser, this,1);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonDamasMouseClicked

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        new MainWindow(arrayUser, this, 3);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReportesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDamas;
    private javax.swing.JButton ButtonHanoi;
    private javax.swing.JLabel LabelJuego1;
    private javax.swing.JLabel LabelJuego2;
    private javax.swing.JLabel LabelJuegos;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonReportes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
