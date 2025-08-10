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
public class GestionReserva {
    
    Reserva[] reservas = new Reserva[100];
    int contador = 0;
    
    
    //Constructor
    public GestionReserva (){
        reservas[contador++] = new Reserva (contador, "Samuel Tsai Solis", "14:00", "Spinning", 120);
    }
    
    
    //Metodos
    public void crearReserva (GestionUsuario gestionUsuario, GestionHorario gestionHorario, GestionActividad gestionActividad){
        
        String nombre = null;
        String horario = null;
        String actividad = null;
        int duracion = 0;
        
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog(gestionUsuario.listarUsuarios() + "\nIngrese el id del usuario para la reserva: "));
        
        for (int i = 0; i < gestionUsuario.contador; i++){
            if (gestionUsuario.usuarios[i].getId() == idUsuario){
                nombre = gestionUsuario.usuarios[i].getNombre();
            }
        }
        if (nombre == null){
            JOptionPane.showMessageDialog(null, "Id del usuario no encontrado.");
        }
        
        
        int idActividad = Integer.parseInt(JOptionPane.showInputDialog(gestionActividad.listarActividades()+ "\nIngrese el id de la actividad ha reservar: "));
        
        for (int i = 0; i < gestionActividad.contador; i++){
            if (gestionActividad.actividades[i].getId() == idActividad){
                actividad = gestionActividad.actividades[i].getNombre();
                duracion = gestionActividad.actividades[i].getDuracion();
            }
        }
        if (actividad == null){
            JOptionPane.showMessageDialog(null, "Id de la actividad no encontrada.");
        }
        
        
        int idHorario = Integer.parseInt(JOptionPane.showInputDialog(gestionHorario.listaHorarios()+ "\nIngrese el id del horario ha reservar: "));
        
        for (int i = 0; i < gestionHorario.contador; i++){
            if (gestionHorario.horarios[i].getId() == idHorario){
                horario = gestionHorario.horarios[i].getHoraInicio();
            }
        }
        if (horario == null){
            JOptionPane.showMessageDialog(null, "Id del horario no encontrado.");
        }
        
        reservas[contador++] = new Reserva(contador, nombre, horario, actividad, duracion);
    }
    
    
    public void eliminarReserva(){
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(listaReservas() + "\nIngrese el id de la reserva que desea eliminar: "));

        for (int i = 0; i < contador; i++) {

            if (reservas[i].getId() == idEliminar) {

                for (int j = i; j < contador - 1; j++) {
                    reservas[j] = reservas[j + 1];
                }

                reservas[--contador] = null;
                JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente");
            }
        }
    }
    
    
    public String listaReservas (){
        String listaReservas = "Lista de reservas:\nId   -   A nombre de   -   Actividad   -   Horario   -   Duracion\n\n";
        for (int i = 0; i < contador; i++) {
            listaReservas += reservas[i].getId() + "   -   " + reservas[i].getNombre() + "   -   " + reservas[i].getActividad()+ "   -   " + reservas[i].getHorario() + "   -   " + reservas[i].getDuracion() + "\n";
            System.out.println(reservas[i].mostrarReserva());
        }
        return listaReservas;
    }
}
