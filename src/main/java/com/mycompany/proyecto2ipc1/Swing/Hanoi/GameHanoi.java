/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Hanoi;

/**
 *
 * @author alvin
 */
import com.mycompany.proyecto2ipc1.Hanoi.classJava.Nodo;
import com.mycompany.proyecto2ipc1.Hanoi.classJava.Pila;
import com.mycompany.proyecto2ipc1.Swing.Damas.Damas1;
import java.io.FileWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GameHanoi extends javax.swing.JFrame {

    /**
     * Creates new form HanoiPrincipal
     */
    MainHanoi mainHanoi;
    int ContNumMov = 0;
    Pila PilaTorre1;
    Pila PilaTorre2;
    Pila PilaTorre3;

    int actualPila1 = 0;
    int actualPila2 = 0;
    int actualPila3 = 0;
    String[][] posisciones = new String[3][8];

    DefaultTableModel ModeloTorre1, ModeloTorre2, ModeloTorre3;
    int Objetivo = 0;
    boolean Stop = false;

    public GameHanoi(MainHanoi mainHanoi, int objetivo) {
        this.Objetivo = objetivo;
        this.mainHanoi = mainHanoi;

        initComponents();
        ModeloTorre1 = (DefaultTableModel) jTable1.getModel();
        ModeloTorre1.setRowCount(10);
        ModeloTorre2 = (DefaultTableModel) jTable2.getModel();
        ModeloTorre2.setRowCount(10);
        ModeloTorre3 = (DefaultTableModel) jTable3.getModel();
        ModeloTorre3.setRowCount(10);
        jTextMovimientos.setText("0");

        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(renderA);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(renderA);
        jTable3.getColumnModel().getColumn(0).setCellRenderer(renderA);
        Iniciar();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void mostrarPosiciones() {
        System.out.println("nuevo mostrar");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
            for (int j = 0; j < 8; j++) {
                try {

                    if (posisciones[i][j] != null) {

                        System.out.print(posisciones[i][j] + ",");
                    }
                } catch (Exception e) {
                }

            }
        }
    }

    public void Reinicar() {
        try {
            if (!jTextMovimientos.getText().equals("")) {
                Limpiar();
                Iniciar();
            }
        } catch (Exception e) {
        }
    }

    public void colocarPilas(int objetivo, int pila) {
        for (int i = objetivo; i >= 1; i--) {
            Nodo Plataforma = new Nodo();
            String Disco = "";

            for (int j = i; j > 0; j--) {
                Disco += "||";
                posisciones[0][i] = Disco;
                actualPila1++;
            }

            Plataforma.setDato(Disco);
            switch (pila) {
                case 1:
                    PilaTorre1.Push(Plataforma);
                    break;
                case 2:
                    PilaTorre2.Push(Plataforma);
                    break;
                case 3:
                    PilaTorre3.Push(Plataforma);
                    break;
            }
        }
    }

    public void Iniciar(int Objetivo, int pila1, int pila2, int pila3) {
        try {
            PilaTorre1 = new Pila();
            PilaTorre2 = new Pila();
            PilaTorre3 = new Pila();
            colocarPilas(pila1, 1);
            colocarPilas(pila2, 2);
            colocarPilas(pila3, 3);

            PresentarTorre1();
            PresentarTorre2();
            PresentarTorre3();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hubo un Error \n:(");
        }
    }

    public void writeFiles(String directorio, String nombreArchivo, String tipoArchivo, Damas1 damas1) {
        try {
            String dato[];
            dato = new String[8];
            FileWriter escribiendoFicheroTxt = new FileWriter(directorio + nombreArchivo + ".txt", false);
            for (int i = 0; i < 8; i++) {
                dato[i] = (damas1.verdamasArchivos(i, 0) + "," + damas1.verdamasArchivos(i, 1) + "," + damas1.verdamasArchivos(i, 2) + ","
                        + damas1.verdamasArchivos(i, 3) + "," + damas1.verdamasArchivos(i, 4) + "," + damas1.verdamasArchivos(i, 5) + ","
                        + damas1.verdamasArchivos(i, 6) + "," + damas1.verdamasArchivos(i, 7) + "\n");
            }
            String dato2;
            dato2 = dato[0] + dato[1] + dato[2] + dato[3] + dato[4] + dato[5] + dato[6] + dato[7];
            escribiendoFicheroTxt.write(dato2);
            escribiendoFicheroTxt.close();
            JOptionPane.showMessageDialog(this, "Guardado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se encontro Fichero");
        }
    }

    public void Iniciar() {
        try {
            PilaTorre1 = new Pila();
            PilaTorre2 = new Pila();
            PilaTorre3 = new Pila();
            for (int i = Objetivo; i >= 1; i--) {
                Nodo Plataforma = new Nodo();
                String Disco = "";

                for (int j = i; j > 0; j--) {
                    Disco += "||";
                }

                posisciones[0][actualPila1] = Disco;
                actualPila1++;
                Plataforma.setDato(Disco);
                PilaTorre1.Push(Plataforma);
            }

            PresentarTorre1();
            PresentarTorre2();
            PresentarTorre3();
            mostrarPosiciones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hubo un Error \n:(");
        }
    }

    public void PresentarTorre1() {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        ModeloTorre1.setRowCount(10);
        Nodo k;

        int RowDisco = (10 - PilaTorre1.getContNodo());

        if (PilaTorre1.getContNodo() > 0) {
            for (k = PilaTorre1.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre1.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }

            if (k.getAbajo() == null) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre1.insertRow(RowDisco, VectorNormal);
            }
        }

        jTable1.setModel(ModeloTorre1);
        ModeloTorre1.setRowCount(10);
    }

    public void PresentarTorre2() {
        ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
        ModeloTorre2.setRowCount(10);
        Nodo k;

        int RowDisco = (10 - PilaTorre2.getContNodo());

        if (PilaTorre2.getContNodo() > 0) {
            for (k = PilaTorre2.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre2.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }

            if (k.getAbajo() == null) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre2.insertRow(RowDisco, VectorNormal);
            }
        }

        jTable2.setModel(ModeloTorre2);
        ModeloTorre2.setRowCount(10);
    }

    public void PresentarTorre3() {
        ((DefaultTableModel) jTable3.getModel()).setRowCount(0);
        ModeloTorre3.setRowCount(10);
        Nodo k;

        int RowDisco = (10 - PilaTorre3.getContNodo());

        if (PilaTorre3.getContNodo() > 0) {
            for (k = PilaTorre3.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre3.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }

            if (k.getAbajo() == null) {
                String[] VectorNormal = {k.getDato()};
                ModeloTorre3.insertRow(RowDisco, VectorNormal);
            }
        }

        jTable3.setModel(ModeloTorre3);
        ModeloTorre3.setRowCount(10);
    }

    private void Limpiar() {
        ContNumMov = 0;
        jTextMovimientos.setText("0");
    }

    private void MostrarMovimientos() {
        ContNumMov++;
        jTextMovimientos.setText(String.valueOf(ContNumMov));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void MoverTorre1_2() {
        try {
            if (PilaTorre1.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre1.Peek());

                if (PilaTorre2.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre2.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[1][actualPila2] = posisciones[0][actualPila1];
                    posisciones[0][actualPila1] = null;
                    actualPila1--;
                    actualPila2++;
                }
                PilaTorre1.Pop();
                PilaTorre2.Push(Plataforma);
                PresentarTorre1();
                PresentarTorre2();
                MostrarMovimientos();

                if (PilaTorre3.getContNodo() == Objetivo) {
                    JOptionPane.showMessageDialog(this, "HA GANADO!");
                }
            }
        } catch (Exception e) {
        }
    }

    public void MoverTorre1_3() {
        try {
            if (PilaTorre1.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre1.Peek());

                if (PilaTorre3.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre3.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[2][actualPila3] = posisciones[0][actualPila1];
                    posisciones[0][actualPila1] = null;
                    actualPila1--;
                    actualPila3++;
                }
                PilaTorre1.Pop();
                PilaTorre3.Push(Plataforma);
                PresentarTorre1();
                PresentarTorre3();
                MostrarMovimientos();

                if (PilaTorre3.getContNodo() == Objetivo) {
                    JOptionPane.showMessageDialog(this, "HA GANADO!");
                }
            }
        } catch (Exception e) {
        }
    }

    public void MoverTorre2_1() {
        try {
            if (PilaTorre2.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre2.Peek());

                if (PilaTorre1.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre1.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[0][actualPila1] = posisciones[1][actualPila2];
                    posisciones[1][actualPila2] = null;
                    actualPila2--;
                    actualPila1++;
                }
                PilaTorre2.Pop();
                PilaTorre1.Push(Plataforma);
                PresentarTorre2();
                PresentarTorre1();
                MostrarMovimientos();
            }
        } catch (Exception e) {
        }
    }

    public void MoverTorre2_3() {
        try {
            if (PilaTorre2.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre2.Peek());

                if (PilaTorre3.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre3.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[2][actualPila3] = posisciones[1][actualPila2];
                    posisciones[1][actualPila2] = null;
                    actualPila2--;
                    actualPila3++;
                }

                PilaTorre2.Pop();
                PilaTorre3.Push(Plataforma);
                PresentarTorre2();
                PresentarTorre3();
                MostrarMovimientos();

                if (PilaTorre3.getContNodo() == Objetivo) {
                    JOptionPane.showMessageDialog(this, "HA GANADO!");
                }
            }
        } catch (Exception e) {
        }
    }

    public void MoverTorre3_2() {
        try {
            if (PilaTorre3.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre3.Peek());

                if (PilaTorre2.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre2.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[1][actualPila2] = posisciones[2][actualPila3];
                    posisciones[2][actualPila3] = null;
                    actualPila3--;
                    actualPila2++;
                }
                PilaTorre3.Pop();
                PilaTorre2.Push(Plataforma);
                PresentarTorre3();
                PresentarTorre2();
                MostrarMovimientos();
            }
        } catch (Exception e) {
        }
    }

    public void MoverTorre3_1() {
        try {
            if (PilaTorre3.getContNodo() > 0) {
                Nodo Plataforma = new Nodo();
                Plataforma.setDato(PilaTorre3.Peek());

                if (PilaTorre1.getContNodo() > 0) {
                    if (Plataforma.getDato().compareTo(PilaTorre1.Peek()) > 0) {
                        JOptionPane.showMessageDialog(this, "No se puede realizar Movimiento");
                        return;
                    }
                }
                if (PilaTorre1.getContNodo() != 0) {
                    posisciones[0][actualPila1] = posisciones[2][actualPila3];
                    posisciones[2][actualPila3] = null;
                    actualPila3--;
                    actualPila1++;
                }
                PilaTorre3.Pop();
                PilaTorre1.Push(Plataforma);
                PresentarTorre3();
                PresentarTorre1();
                MostrarMovimientos();
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButtonReiniciar = new javax.swing.JButton();
        jButtonResolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextMovimientos = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoscrolls(false);
        jTable2.setFocusable(false);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jTable1.setFocusable(false);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAutoscrolls(false);
        jTable3.setFocusable(false);
        jTable3.setRowSelectionAllowed(false);
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setText("TORRES");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mover a:", "Torre 2", "Torre 3" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mover a:", "Torre 1", "Torre 3" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mover a:", "Torre 1", "Torre 2" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButtonReiniciar.setText("Reiniciar");
        jButtonReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonReiniciarMouseClicked(evt);
            }
        });

        jButtonResolver.setText("Resolver");
        jButtonResolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonResolverMouseClicked(evt);
            }
        });

        jLabel2.setText("Movimientos");

        jTextMovimientos.setEditable(false);
        jTextMovimientos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMovimientosActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Salir");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setText("Mover");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jTextMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReiniciar)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButtonResolver)
                    .addComponent(jButtonReiniciar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMovimientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMovimientosActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            if (jComboBox1.getSelectedIndex() > 0 | jComboBox2.getSelectedIndex() > 0 | jComboBox3.getSelectedIndex() > 0) {
                if (jComboBox1.getSelectedIndex() == 1) {
                    MoverTorre1_2();
                    mostrarPosiciones();
                }
                if (jComboBox1.getSelectedIndex() == 2) {
                    MoverTorre1_3();
                    mostrarPosiciones();
                }
                if (jComboBox2.getSelectedIndex() == 1) {
                    MoverTorre2_1();
                    mostrarPosiciones();
                }
                if (jComboBox2.getSelectedIndex() == 2) {
                    MoverTorre2_3();
                    mostrarPosiciones();
                }
                if (jComboBox3.getSelectedIndex() == 1) {
                    MoverTorre3_1();
                    mostrarPosiciones();
                }
                if (jComboBox3.getSelectedIndex() == 2) {
                    MoverTorre3_2();
                    mostrarPosiciones();
                }
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un Movimiento");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al Mover");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    boolean stop = false;

    private void MoverPlataforma(Pila Origen, Pila Destino) {

        if (stop == false) {
            Nodo plataforma = new Nodo();
            plataforma.setDato(Origen.Peek());
            Origen.Pop();
            Destino.Push(plataforma);

            PresentarTorre1();
            PresentarTorre2();
            PresentarTorre3();
            MostrarMovimientos();
        }
    }

    private void Recursivo(int n, Pila Origen, Pila Auxiliar, Pila Destino) {
        if (n == 1) {
            MoverPlataforma(Origen, Destino);
        } else {
            Recursivo(n - 1, Origen, Destino, Auxiliar);
            MoverPlataforma(Origen, Destino);
            Recursivo(n - 1, Auxiliar, Origen, Destino);
        }
    }


    private void jButtonReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReiniciarMouseClicked
        //Reinicar();
        Limpiar();
        Iniciar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReiniciarMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        this.dispose();
        mainHanoi.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jButtonResolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResolverMouseClicked
        //if (!jTextMovimientos.getText().equals("") && PilaTorre3.getContNodo() != Objetivo) {
        Reinicar();
        Stop = false;

        Recursivo(Objetivo, PilaTorre1, PilaTorre2, PilaTorre3);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonResolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JButton jButtonResolver;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextMovimientos;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
