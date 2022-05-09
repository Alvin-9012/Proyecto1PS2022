/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas.Users;

/**
 *
 * @author oliver
 */
public class Users {

    private String firstName, lastName;
    private int id, partidasGanadas=0, partidasPerdidas=0, partidasJugadas=0, totalMovimientos=0, movimientosCortos=100000, movimientosActuales=0;
    private double promedioMovimientos=0, mejorMinuto=10000, mejorSegundo=10000, minutosActuales, segundosActuales;
    

    public Users(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    
    public void Reiniciar(){
        minutosActuales=0;
        segundosActuales=0;
        movimientosActuales=0;
    }
    public void FinaPartida(int minutos, int segundos){
        minutosActuales=minutos;
        segundosActuales=segundos;
        if (this.movimientosActuales<this.movimientosCortos) {
            this.movimientosCortos = this.movimientosActuales;
            mejorMinuto=minutos;
            mejorSegundo=segundos;
        }
    }
    
    public void nuevaPArtida(){
        movimientosActuales=0;
    }
    
    public double promedioMovimientos(){
        return this.promedioMovimientos= this.totalMovimientos/this.partidasJugadas;
    }

    public void aumentarPartidasGanas(){
        this.partidasGanadas++;
    }
    
    public void aumentarPartidasPerdidas(){
        this.partidasPerdidas++;
    }
    
    public void aumentarPartidasJugadas(){
        this.partidasJugadas++;
    }
    
    public void aumentarTotalMovimeitnos(){
        this.totalMovimientos++;
    }
   
    public void aumentarTotalMovimeitnosActuales(){
        aumentarTotalMovimeitnos();
        this.movimientosActuales++;
    }
    
    @Override
    public String toString() {
        return  this.getId() + ", " + this.getFirstName() + ", " + this.getLastName()+"\n";
    }
    
    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName.toUpperCase();
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().length()>5)
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.toUpperCase();
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length()>5)
        this.lastName = lastName;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public int getMovimientosCortos() {
        return movimientosCortos;
    }

    public double getPromedioMovimientos() {
        return promedioMovimientos = totalMovimientos/partidasJugadas;
    }

    public double getMejorMinuto() {
        return mejorMinuto;
    }

    public double getMejorSegundo() {
        return mejorSegundo;
    }
    
    
}
