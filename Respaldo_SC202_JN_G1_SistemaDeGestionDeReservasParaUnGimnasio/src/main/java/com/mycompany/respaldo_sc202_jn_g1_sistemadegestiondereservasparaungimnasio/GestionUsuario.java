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
public class GestionUsuario {
    
    Usuario[] usuarios = new Usuario [100];
    int contador = 0;
    
    //Constructor
    public GestionUsuario (){
        usuarios [contador++] = new Usuario (contador, "Samuel Tsai Solis", 118630160, "stsai", "1234", "stsai@prueba.com", 11223344, 22, 83.0, 1.78);
        usuarios [contador++] = new Usuario (contador, "Prueba1 Prueba", 111111111, "prueba1", "1111", "pprueba@prueba.com", 11111111, 11, 11.11, 1.11);
        usuarios [contador++] = new Usuario (contador, "Prueba2 Prueba", 222222222, "prueba2", "2222", "pprueba@prueba.com", 22222222, 22, 22.22, 1.22);
        usuarios [contador++] = new Usuario (contador, "Prueba3 Prueba", 333333333, "prueba3", "3333", "pprueba@prueba.com", 33333333, 11, 11.11, 1.33);
        usuarios [contador++] = new Usuario (contador, "Prueba4 Prueba", 444444444, "prueba4", "4444", "pprueba@prueba.com", 44444444, 4, 4.44, 1.44);
    }
    
    
    //Metodos
    public void registrarUsuario (){
        
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        long cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero de cedula: "));
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
        String contrasena = JOptionPane.showInputDialog("Ingrese la contrasena: ");
        String correo = JOptionPane.showInputDialog("Ingrese el correo: ");
        long telefono = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero de telefono: "));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso: "));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura (metros.sentimetros): "));
        
        usuarios[contador++] = new Usuario (contador, nombre, cedula, nombreUsuario, contrasena, correo, telefono, edad, peso, altura);
        System.out.println(usuarios[contador - 1].mostrarUsuario());
    }
    
    
    public void editarUsuario () {
        boolean encontrar = false;
        
        int idEditar = Integer.parseInt(JOptionPane.showInputDialog(listarUsuarios() + "\nIngrese el id del usuario que desea editar: "));
        
        for (int i = 0; i < contador; i++){
            if (idEditar == usuarios[i].getId()){
                encontrar = true;
                System.out.println("Id encontrado.");
            }
        }
        
        if (encontrar == true){
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
            long cedula = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero de cedula: "));
            String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            String contrasena = JOptionPane.showInputDialog("Ingrese la contrasena: ");
            String correo = JOptionPane.showInputDialog("Ingrese el correo: ");
            long telefono = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero de telefono: "));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso: "));
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura (metros.sentimetros): "));

            usuarios[idEditar - 1] = new Usuario(idEditar, nombre, cedula, nombreUsuario, contrasena, correo, telefono, edad, peso, altura);
            
            JOptionPane.showMessageDialog(null, "Usuario editado correctamente");
            System.out.println(usuarios[idEditar - 1].mostrarUsuario());
            
        }else{
            JOptionPane.showMessageDialog(null, "El id ingresado no conincide con alguno de los usuarios registrados.");
        }
    }
    
    
    public void eliminarUsuario () {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(listarUsuarios() + "\nIngrese el id del usuario que desea eliminar: "));
        
        for(int i = 0; i < contador; i++){
            
            if(usuarios[i].getId() == idEliminar) {
                
                for(int j = i; j < contador - 1; j++){
                    usuarios[j] = usuarios[j+1];
                }
                
                usuarios[--contador] = null;
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            }   
        }
    }
    
    
    public String listarUsuarios () {
        String listaUsuarios = "Lista de usuarios:\nId   -   Nombre\n\n";
        for (int i = 0; i < contador; i++){
            listaUsuarios += usuarios[i].getId() + "   -   " + usuarios[i].getNombre() + "\n";
            System.out.println(usuarios[i].mostrarUsuario());
        }
        return listaUsuarios;
    }
    
    public void validarInicioSesion (){
        boolean correcto = false;
        int intento = 0;
        
        do{
            String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
            String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña: ");
            intento += 1;
            
            for (int i = 0; i < contador; i++) {
                System.out.println("---");
                System.out.println(usuarios[i].getNombreUsuario());
                System.out.println(nombreUsuario);
                System.out.println(usuarios[i].getContrasena());
                System.out.println(contrasena);
                System.out.println("---");       
                
                
                if (usuarios[i].getNombreUsuario().equals(nombreUsuario) && usuarios[i].getContrasena().equals(contrasena)) {
                    correcto = true;
                    JOptionPane.showMessageDialog(null, "Inicio de sesion correcto!\nVienvenido " + usuarios[i].getNombre());
                }
            }
            
            if (correcto == false){
                if (intento < 3){
                    JOptionPane.showMessageDialog(null, "Las credenciales ingresadas son invalidas, intentelo de nuevo!");
                }else if (intento == 3){
                    JOptionPane.showMessageDialog(null, "Ha ingresado 3 veces credenciales invalidas\nSaliendo...");
                    System.exit(0);
                }
            }
        } while (intento == 3 || correcto == false);
    }
}
