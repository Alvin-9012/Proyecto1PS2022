/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas.Users;

import com.mycompany.proyecto2ipc1.Swing.Damas.EleccionPartidas;
import com.mycompany.proyecto2ipc1.Swing.Damas.Principal;
import com.mycompany.proyecto2ipc1.Swing.Hanoi.GameHanoi;
import com.mycompany.proyecto2ipc1.Swing.Hanoi.MainHanoi;
import com.mycompany.proyecto2ipc1.Swing.PrincipalMain.PrincipalMain;
import com.mycompany.proyecto2ipc1.Swing.PrincipalMain.Reportes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author oliver
 */
public class MainWindow extends javax.swing.JFrame {

    private int tipoJuego;
    private ArrayUsers arrayUser = new ArrayUsers();
    private SaveFiles saveFiles = new SaveFiles(this);
    private PrincipalMain mainWindow;
    private String directorioUsuarios = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/Usuarios/";
    private String directorioPartidasGuardadas = "/home/alvin/NetBeansProjects/Proyecto2Ipc1/ArchivosJuegos/PartidasGuardadas/";

    /**
     * Creates new form MainWindow
     */
    public MainWindow(ArrayUsers users, PrincipalMain mainWindow, int tipoJuego) {
        this.tipoJuego = tipoJuego;
        this.mainWindow = mainWindow;
        this.arrayUser = users;
        initComponents();
        this.listados.setText(arrayUser.toString());
        //verificarArchivos();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listados = new javax.swing.JTextArea();
        Refrescar = new javax.swing.JButton();
        idusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ButtonSaveFiles = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idusuarioIniciar = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("main window");
        setBounds(new java.awt.Rectangle(300, 300, 800, 800));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jButton1.setText("Crear usuario");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listados.setEditable(false);
        listados.setColumns(20);
        listados.setRows(5);
        jScrollPane1.setViewportView(listados);

        Refrescar.setText("Refrescar");
        Refrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefrescarMouseClicked(evt);
            }
        });
        Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefrescarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id usuario: ");

        actualizar.setText("actualizar");
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jButton2.setText("Iniciar ");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ButtonSaveFiles.setText("Guardar Usuarios");
        ButtonSaveFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSaveFilesMouseClicked(evt);
            }
        });
        ButtonSaveFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveFilesActionPerformed(evt);
            }
        });

        jLabel2.setText("Id de Usuario para Iniciar");

        Salir.setText("Salir");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(actualizar)
                                .addGap(18, 18, 18)
                                .addComponent(Refrescar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(idusuarioIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ButtonSaveFiles)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Salir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refrescar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonSaveFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idusuarioIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Salir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

// TODO add your handling code here:
        this.revalidate();
        this.repaint();

        System.out.println(arrayUser.toString());
        System.out.println("entre");
        this.setVisible(false);
        AddUser tmp = new AddUser(arrayUser, this);


    }//GEN-LAST:event_jButton1MouseClicked

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
            this.listados.setText(arrayUser.toString());
            file.close();
            lectura.close();
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se encontro fichero");
        }
    }


    private void RefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefrescarMouseClicked
        this.listados.setText(arrayUser.toString());
    }//GEN-LAST:event_RefrescarMouseClicked

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        // TODO add your handling code here:
        if (this.idusuario.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Esta vacio");
            return;
        }

        int idUpdate;
        try {
            idUpdate = Integer.parseInt(this.idusuario.getText().trim());
        } catch (Exception e) {
            idUpdate = -1;
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero");
            return;
            //numero no es valido 
        }

        if (!ArrayUsers.isValid(idUpdate)) {
            //hay error nporque el id no existe
            //avisar al usuario
            JOptionPane.showMessageDialog(this, "el id no es valido");
            return;
        }

        this.setVisible(false);
        EditUser tmpedit = new EditUser(arrayUser.getUser(idUpdate), this);


    }//GEN-LAST:event_actualizarMouseClicked

    public void setFocus() {
        this.setVisible(true);
        this.listados.setText(arrayUser.toString());
    }

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        this.setVisible(true);
        this.listados.setText(arrayUser.toString());
    }//GEN-LAST:event_formFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        if (arrayUser.getUser(0) == null) {
            JOptionPane.showMessageDialog(this, "Se Necesita un Usuario como Minimo");
        } else {
            if (this.idusuarioIniciar.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Esta vacio \nIngrese Id de Usuario");
                return;
            }

            int idUpdate;
            try {
                idUpdate = Integer.parseInt(this.idusuarioIniciar.getText().trim());
            } catch (Exception e) {
                idUpdate = -1;
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero");
                return;
                //numero no es valido 
            }

            if (!ArrayUsers.isValid(idUpdate)) {
                //hay error nporque el id no existe
                //avisar al usuario
                JOptionPane.showMessageDialog(this, "el id no es valido");
                return;
            }
            switch (tipoJuego) {
                case 1:

                    new EleccionPartidas(this, arrayUser.getUser(idUpdate));
                    this.setVisible(false);
                    break;
                case 2:
                    new MainHanoi(this, arrayUser.getUser(idUpdate));
                    this.setVisible(false);
                    break;
                case 3:
                    new Reportes(arrayUser.getUser(idUpdate), this);
                    this.setVisible(false);
                    break;
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ButtonSaveFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSaveFilesActionPerformed

    private void ButtonSaveFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSaveFilesMouseClicked
        saveFiles.writeFiles(directorioUsuarios, "Usuarios", ".html", arrayUser.toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSaveFilesMouseClicked

    private void RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefrescarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefrescarActionPerformed

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        this.mainWindow.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSaveFiles;
    private javax.swing.JButton Refrescar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField idusuario;
    private javax.swing.JTextField idusuarioIniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listados;
    // End of variables declaration//GEN-END:variables
}