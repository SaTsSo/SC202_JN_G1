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
public class GestionActividad {
    
    Actividad[] actividades = new Actividad[100];
    int contador = 0;
    
    
    //Constructor
    public GestionActividad (){
        actividades[contador++] = new Actividad (contador, "Yoga", 60);
        actividades[contador++] = new Actividad (contador, "Spinning", 120);
        actividades[contador++] = new Actividad (contador, "Zumba", 90);
        actividades[contador++] = new Actividad (contador, "Crossfit", 30);
    }
    
    
    //Metodos
    public void crearActividad (){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la actividad: ");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion de la actividad (minutos): "));
        
        actividades[contador++] = new Actividad (contador, nombre, duracion);
        System.out.println(actividades[contador - 1].mostrarActividad());
    }
    
    
    public void editarActividad (){
        boolean encontrar = false;

        int idEditar = Integer.parseInt(JOptionPane.showInputDialog(listarActividades() + "\nIngrese el id de la actividad que desea editar: "));

        for (int i = 0; i < contador; i++) {
            if (idEditar == actividades[i].getId()) {
                encontrar = true;
                System.out.println("Id encontrado.");
            }
        }

        if (encontrar == true) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la actividad: ");
            int duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion de la actividad (minutos): "));
            
            actividades[idEditar - 1] = new Actividad (idEditar, nombre, duracion);

            JOptionPane.showMessageDialog(null, "Actividad editada correctamente");
            System.out.println(actividades[idEditar - 1].mostrarActividad());
        } else {
            JOptionPane.showMessageDialog(null, "El id ingresado no conincide con alguna de las actividades registradas.");
        }
    }
    
    
    public void eliminarActividad (){

        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(listarActividades() + "\nIngrese el id de la actividad que desea eliminar: "));

        for (int i = 0; i < contador; i++) {

            if (actividades[i].getId() == idEliminar) {

                for (int j = i; j < contador - 1; j++) {
                    actividades[j] = actividades[j + 1];
                }

                actividades[--contador] = null;
                JOptionPane.showMessageDialog(null, "Actividad eliminada correctamente");
            }
        }
    }
    
    
    public String listarActividades (){
        String listaActividades = "Lista de actividades:\nId   -   Nombre   -   Duracion\n\n";
        for (int i = 0; i < contador; i++) {
            listaActividades += actividades[i].getId() + "   -   " + actividades[i].getNombre() + "   -   " + actividades[i].getDuracion() + " min\n";
            System.out.println(actividades[i].mostrarActividad());
        }
        return listaActividades;
    }
}
