/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas;

import com.mycompany.proyecto2ipc1.Swing.Damas.Users.MainWindow;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class SaveGame {

    private PanelBarraDeHerramientas panel;

    public SaveGame(PanelBarraDeHerramientas panel) {
        this.panel = panel;
    }

    public void writeFiles(String directorio, String nombreArchivo, String tipoArchivo, Damas1 damas1) {
        try {
            String dato[];
            dato = new String[8];
            FileWriter escribiendoFicheroTxt = new FileWriter(directorio + nombreArchivo + ".txt");
            for (int i = 0; i < 8; i++) {
                       dato[i] = (damas1.verdamasArchivos(i, 0)+","+damas1.verdamasArchivos(i, 1)+","+damas1.verdamasArchivos(i, 2)+","
                             +damas1.verdamasArchivos(i, 3)+","+damas1.verdamasArchivos(i, 4)+","+damas1.verdamasArchivos(i, 5)+","
                             +damas1.verdamasArchivos(i, 6)+","+damas1.verdamasArchivos(i, 7)+"\n");
            }
            String dato2;
            dato2 = dato[0]+dato[1]+dato[2]+dato[3]+dato[4]+dato[5]+dato[6]+dato[7];
                escribiendoFicheroTxt.write(dato2);
                escribiendoFicheroTxt.close();
            JOptionPane.showMessageDialog(panel, "Partida guardada con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "No se encontro Fichero");
        }
    }
}
