/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

/**
 *
 * @author samim
 */
public class Actividad {
    //Atributos
    private int id;
    private String nombre;
    private int duracion;
    
    
    //Constructor
    public Actividad (int id, String nombre, int duracion){
       this.id = id;
       this.nombre = nombre;
       this.duracion = duracion;
    }
    
    
    //Encapsuladores
    public void setId (int id){this.id = id;}
    public int getId (){return id;}
    
    public void setNombre (String nombre){this.nombre = nombre;}
    public String getNombre (){return nombre;}
    
    public void setDuracion (int duracion){this.duracion = duracion;}
    public int getDuracion (){return duracion;}
    
    //Metodos
    public String mostrarActividad (){
        String actividad = "---------------------\nDatos de la actividad\n---------------------\n\n";
        actividad += "Id: " + id + "\n";
        actividad += "Nombre: " + nombre + "\n";
        actividad += "Duracion: " + duracion + " min\n\n";
        
        return actividad;
    }
}
