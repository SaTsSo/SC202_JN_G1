/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author matia
 */
public class Actividad {
    private String nombreActividad;
    private int idClases;
    private int duracionClase; 
    private String horarioClase;

    // Constructor
    public Actividad(String nombreActividad, int idClases, int duracionClase, String horarioClase) {
        this.nombreActividad = nombreActividad;
        this.idClases = idClases;
        this.duracionClase = duracionClase;
        this.horarioClase = horarioClase;
    }

    // Getters y Setters
    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getIdClases() {
        return idClases;
    }

    public void setIdClases(int idClases) {
        this.idClases = idClases;
    }

    public int getDuracionClase() {
        return duracionClase;
    }

    public void setDuracionClase(int duracionClase) {
        this.duracionClase = duracionClase;
    }

    public String getHorarioClase() {
        return horarioClase;
    }

    public void setHorarioClase(String horarioClase) {
        this.horarioClase = horarioClase;
    }

    // Método para mostrar la información de la clase
    public void mostrarClase() {
        JOptionPane.showMessageDialog(null,
            "ID: " + idClases +
            "\nNombre: " + nombreActividad +
            "\nDuración: " + duracionClase + " minutos" +
            "\nHorario: " + horarioClase,
            "Información de la Clase",
            JOptionPane.INFORMATION_MESSAGE);
    }
}


