package com.mycompany.proyecto2ipc1.Swing.Damas;

import com.mycompany.proyecto2ipc1.Swing.Damas.Users.MainWindow;
import com.mycompany.proyecto2ipc1.Swing.Damas.Users.Users;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

    PanelDeJuego juego;

    PanelBarraDeHerramientas panel1;

    PanelImagen imagen;

    private int minutos;

    private int segundos;

    private MainWindow mainWindow;

    private Users users;

    private Damas1 damas;

    public Principal(MainWindow mainWindow, Users users) {
        super("Damas");
        this.mainWindow = mainWindow;
        this.users = users;
        this.users.Reiniciar();
        users.aumentarPartidasJugadas();
        iniciar();
        alinear();
        //setSize(685,531);
        setSize(480, 520);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public Principal(MainWindow mainWindow, Users users, int tabla[][], int minutos, int segundos) {
        super("Damas");
        this.mainWindow = mainWindow;
        this.users = users;
        this.minutos = minutos;
        this.segundos = segundos;
        this.users.Reiniciar();
        users.aumentarPartidasJugadas();
        iniciar(tabla);
        alinear();
        juego.setDamas(tabla);
        juego.dibujar_en_los_botones();
        //setSize(685,531);
        setSize(480, 520);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JOptionPane.showMessageDialog(this, "Seleccione el modo \n(Automatico/Manual)");

    }

    public void alinear() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Informacion")));
        panel.add(imagen);

        setLayout(new BorderLayout());
        add(juego, BorderLayout.CENTER);
        add(panel1, BorderLayout.NORTH);
        //	add(panel, BorderLayout.EAST);
    }

    public void Actualizar_botones() {
        juego.ResetearTablero();
        juego.dibujar_en_los_botones();
    }

    public void iniciar() {
        juego = new PanelDeJuego(users, this, mainWindow);
        panel1 = new PanelBarraDeHerramientas(this, juego, mainWindow, false, 0, 0);
        imagen = new PanelImagen();
    }

    public void iniciar(int tabla[][]) {
        juego = new PanelDeJuego(tabla, users, this, mainWindow);
        panel1 = new PanelBarraDeHerramientas(this, juego, mainWindow, true, minutos, segundos);
        imagen = new PanelImagen();
    }

    public Users getUsers() {
        return users;
    }

    public PanelDeJuego getJuego() {
        return juego;
    }

    public void IniciarCronometro() {
        panel1.IniciarCronometro();
    }

    public void DetenerCronometro() {
        panel1.DetenerCronometro();
    }

    public int getMinuts() {
        return panel1.getMinuts();
    }

    public int getSeconds() {
        return panel1.getSeconds();
    }

    public void CerrarCronometro() {
        panel1.CerrarCronometro();
    }

}
