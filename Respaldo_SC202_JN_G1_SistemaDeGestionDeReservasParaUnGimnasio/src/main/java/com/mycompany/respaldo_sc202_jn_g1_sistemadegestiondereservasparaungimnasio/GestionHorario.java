/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author samim
 */
public class GestionHorario {
    
    Horario[] horarios = new Horario [100];
    int contador = 0;
    
    public GestionHorario (){
        horarios[contador++] = new Horario (contador, "6:00");
        horarios[contador++] = new Horario (contador, "8:30");
        horarios[contador++] = new Horario (contador, "10:00");
        horarios[contador++] = new Horario (contador, "12:00");
        horarios[contador++] = new Horario (contador, "14:00");
        horarios[contador++] = new Horario (contador, "16:00");
    }
    
    
    //Metodos
    public void crearHorario (){
        String horaInicio = JOptionPane.showInputDialog("Ingrese la hora de inicio (hh:mm): ");
        
        horarios[contador++] = new Horario (contador, horaInicio);
        System.out.println(horarios[contador - 1].mostrarHorario());
    }
    
    
    public void editarHorario (){
        boolean encontrar = false;

        int idEditar = Integer.parseInt(JOptionPane.showInputDialog(listaHorarios() + "\nIngrese el id del horario que desea editar: "));

        for (int i = 0; i < contador; i++) {
            if (idEditar == horarios[i].getId()) {
                encontrar = true;
                System.out.println("Id encontrado.");
            }
        }

        if (encontrar == true) {
            String horaInicio = JOptionPane.showInputDialog("Ingrese la hora de inicio (hh:mm): ");
            
            horarios[idEditar - 1] = new Horario (idEditar, horaInicio);

            JOptionPane.showMessageDialog(null, "Horario editado correctamente");
            System.out.println(horarios[idEditar - 1].mostrarHorario());
        } else {
            JOptionPane.showMessageDialog(null, "El id ingresado no conincide con alguno de los horarios registrados.");
        }
    }
    
    
    public void eliminarHorario (){
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(listaHorarios()+ "\nIngrese el id del horario que desea eliminar: "));

        for (int i = 0; i < contador; i++) {

            if (horarios[i].getId() == idEliminar) {

                for (int j = i; j < contador - 1; j++) {
                    horarios[j] = horarios[j + 1];
                }

                horarios[--contador] = null;
                JOptionPane.showMessageDialog(null, "Horario eliminado correctamente");
            }
        }
    }
    
    
    public String listaHorarios (){
        String listaHorarios = "Lista de horarios:\nId   -   Hora de Inicio\n\n";
        for (int i = 0; i < contador; i++) {
            listaHorarios += horarios[i].getId() + "   -   " + horarios[i].getHoraInicio()+ "\n";
            System.out.println(horarios[i].mostrarHorario());
        }
        return listaHorarios;
    }
}
