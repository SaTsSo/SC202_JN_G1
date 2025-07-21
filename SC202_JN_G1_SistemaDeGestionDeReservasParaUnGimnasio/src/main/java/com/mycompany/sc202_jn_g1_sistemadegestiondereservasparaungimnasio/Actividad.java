/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author matia
 */
public class Actividad {
    private String nombreActividad;
    private int idClases;
    private int duracionClase; 
    private String horarioClase;

    public Actividad(String nombreActividad, int idClases, int duracionClase, String horarioClase) {
        this.nombreActividad = nombreActividad;
        this.idClases = idClases;
        this.duracionClase = duracionClase;
        this.horarioClase = horarioClase;
    }


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

    public void crearClase(String nombreActividad, int idClases, int duracionClase, String horarioClase) {
        this.nombreActividad = nombreActividad;
        this.idClases = idClases;
        this.duracionClase = duracionClase;
        this.horarioClase = horarioClase;
        System.out.println("Clase creada exitosamente.");
    }

    public void editarClase(String nombreActividad, int duracionClase, String horarioClase) {
        this.nombreActividad = nombreActividad;
        this.duracionClase = duracionClase;
        this.horarioClase = horarioClase;
        System.out.println("Clase editada exitosamente.");
    }

    public void eliminarClase() {
        this.nombreActividad = "";
        this.idClases = 0;
        this.duracionClase = 0;
        this.horarioClase = "";
        System.out.println("Clase eliminada exitosamente.");
    }
}

