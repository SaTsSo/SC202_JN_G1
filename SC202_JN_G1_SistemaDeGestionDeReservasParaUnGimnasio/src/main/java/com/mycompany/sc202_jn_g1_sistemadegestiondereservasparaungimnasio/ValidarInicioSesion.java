/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author samim
 */
public class ValidarInicioSesion {
    
    private Usuario[] usuariosRegistrados;
    
    public ValidarInicioSesion (Usuario[] usuariosRegistrados){
        this.usuariosRegistrados = usuariosRegistrados;
    }
    
    public boolean validarCredenciales (){
        boolean correcto = false;
        int intento = 0;
        
        do{
            String correo = JOptionPane.showInputDialog("Ingrese su correo de usuario: ");
            String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña: ");
            intento += 1;
            
            for (int i = 0; i < usuariosRegistrados.length; i++) {
                if (usuariosRegistrados[i].getCorreo().equals(correo) && usuariosRegistrados[i].getContrasena().equals(contrasena)) {
                    correcto = true;
                    JOptionPane.showMessageDialog(null, "Inicio de sesion correcto!\nVienvenido " + usuariosRegistrados[i].getNombre());
                }
            }
            
            if (correcto == false){
                if (intento < 3){
                    JOptionPane.showMessageDialog(null, "Las credenciales ingresado son invalidas, intentelo de nuevo");
                }else if (intento == 3){
                    JOptionPane.showMessageDialog(null, "Ha ingresado 3 veces credenciales incorrectas\nSaliendo...");
                    System.exit(0);
                }
            }
            
            
            return correcto;
        } while (intento == 3);
    }
    
}
