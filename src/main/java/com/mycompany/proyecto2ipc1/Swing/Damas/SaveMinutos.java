/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas;

import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class SaveMinutos {
    private PanelBarraDeHerramientas panel;

    public SaveMinutos(PanelBarraDeHerramientas panel) {
        this.panel = panel;
    }

    public void writeFiles(String directorio, String nombreArchivo, String tipoArchivo, int minutos, int segundos) {
        try {
            String dato[];
            dato = new String[2];
            FileWriter escribiendoFicheroTxt = new FileWriter(directorio + nombreArchivo + ".txt");
            dato[0] = String.valueOf(minutos);
            dato[1] = String.valueOf(segundos);
            String dato2;
            dato2 = dato[0]+","+dato[1];
                escribiendoFicheroTxt.write(dato2);
                escribiendoFicheroTxt.close();
            JOptionPane.showMessageDialog(panel, "Cronometro guardado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "No se encontro Fichero");
        }
    }
    
}
