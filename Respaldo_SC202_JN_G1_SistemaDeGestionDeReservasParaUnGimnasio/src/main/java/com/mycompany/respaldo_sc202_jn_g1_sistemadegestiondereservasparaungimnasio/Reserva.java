/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

/**
 *
 * @author samim
 */
public class Reserva {
    //Atributos
    private int id;
    private String nombre;
    private String horario;
    private String actividad;
    private int duracion;
    
    
    //Constructor
    public Reserva (int id, String nombre, String horario, String actividad, int duracion){
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.actividad = actividad;
        this.duracion = duracion;
    }
    
    
    //Encapsuladores
    public void setId (int id) {this.id = id;}
    public int getId (){return id;}
    
    public void setNombre (String nombre) {this.nombre = nombre;}
    public String getNombre () {return nombre;}
    
    public void setHorario (String horario) {this.horario = horario;}
    public String getHorario () {return horario;}
    
    public void setActividad (String actividad) {this.actividad = actividad;}
    public String getActividad () {return actividad;}
    
    public void setDuracion (int duracion) {this.duracion = duracion;}
    public int getDuracion (){return duracion;}
    
    //Metodos
    public String mostrarReserva (){
        
        String reserva = "---------------------\nDatos de la reserva\n---------------------\n\n";
        reserva += "Id: " + id + "\n";
        reserva += "A nombre de: " + nombre + "\n";
        reserva += "Hora de inicio: " + horario + "\n";
        reserva += "Actividad: " + actividad + "\n";
        reserva += "Duracion de la actividad: " + duracion + "min\n\n";
        
        return reserva;
    }
}
