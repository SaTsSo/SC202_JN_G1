/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

/**
 *
 * @author samim
 */
public class Horario {
    //Atributos
    private int id;
    private String horaInicio;
    private int duracion;
    
    
    //Constructor
    public Horario (int id, String horaInicio){
        this.id = id;
        this.horaInicio = horaInicio;
    }
    
    
    //Encapsuladores
    public void setId (int id){this.id = id;}
    public int getId (){return id;}
    
    public void setHoraInicio (String horaInicio){this.horaInicio = horaInicio;}
    public String getHoraInicio (){return horaInicio;}
    
    
    //Metodos
    public String mostrarHorario (){
        String horario = "----------------\nDatos de horario\n----------------\n\n";
        horario += "Id: " + id + "\n";
        horario += "Hora de Inicio: " + horaInicio + "\n\n";
        
        return horario;
    }
}
