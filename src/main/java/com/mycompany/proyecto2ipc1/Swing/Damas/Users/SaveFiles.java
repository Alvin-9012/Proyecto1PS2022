/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class SaveFiles {

    private MainWindow MainWindow;

    public SaveFiles(MainWindow MainWindow) {
        this.MainWindow = MainWindow;
    }

    public void writeFiles(String directorio, String nombreArchivo, String tipoArchivo, String datoHaGuardar) {
        try {
            FileWriter escribiendoFichero = new FileWriter(directorio + nombreArchivo.trim() + tipoArchivo, false);
            FileWriter escribiendoFicheroTxt = new FileWriter(directorio + nombreArchivo + ".txt", false);
            escribiendoFichero.write(datoHaGuardar);
            escribiendoFicheroTxt.write(datoHaGuardar);
            escribiendoFichero.close();
            escribiendoFicheroTxt.close();
            JOptionPane.showMessageDialog(MainWindow, "Guardado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainWindow, "No se encontro Fichero");
        }
    }

    /**public ArrayUsers readFiles(String directorio, String nombreArchivo, String tipoArchivo) {
        ArrayUsers datos = new ArrayUsers();
        try {
            File file2 = new File(directorio + nombreArchivo + tipoArchivo);
            if (file2.exists()) {
                FileReader file = new FileReader(directorio + nombreArchivo + tipoArchivo);
                BufferedReader lectura = new BufferedReader(file);
                String cadena;
                while ((cadena = lectura.readLine()) != null) {
                    String[] vectorCadena = cadena.split(",");
                    datos.addUser(vectorCadena[1], vectorCadena[2]);
                }
            }

        } catch (Exception e) {

        }
        return datos;
    }*/
}
