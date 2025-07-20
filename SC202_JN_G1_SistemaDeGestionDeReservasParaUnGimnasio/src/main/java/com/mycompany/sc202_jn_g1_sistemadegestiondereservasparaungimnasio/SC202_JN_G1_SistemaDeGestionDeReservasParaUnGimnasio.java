/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author samim
 */
public class SC202_JN_G1_SistemaDeGestionDeReservasParaUnGimnasio {

    public static void main(String[] args) {
        
        boolean salir = false;

        //Inicio de sesion
        String verificarUsuario = JOptionPane.showInputDialog("Ingrese su correo de usuario: ");
        String verificarContraseña = JOptionPane.showInputDialog("Ingrese su contraseña: ");
        //VALIDAR LAS CREDENCIALES

        do {
            //Menu principal

            String mensajePrincipal = "";
            mensajePrincipal += "******************************************\n";
            mensajePrincipal += "¡Vienvenido al Gymnacio Super Fit!\n";
            mensajePrincipal += "******************************************\n\n";
            mensajePrincipal += "Por favor ingrese el numero de la accion que desea realizar:\n";
            mensajePrincipal += "1. Gestion de usuarios.\n";
            mensajePrincipal += "2. Seleccion de actividades.\n";
            mensajePrincipal += "3. Horarios disponibles.\n";
            mensajePrincipal += "4. Gestion de reservas.\n";
            mensajePrincipal += "5. Salir.";

            int seleccionMenuPrincipal = 0;

            do {
                seleccionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(mensajePrincipal));

                switch (seleccionMenuPrincipal) {
                    case 1:
                        //Menu opcion #1
                        String mensajeGestionUsuario = "";
                        mensajeGestionUsuario += "*************************\n";
                        mensajeGestionUsuario += "Gestion de Usuarios\n";
                        mensajeGestionUsuario += "*************************\n\n";
                        mensajeGestionUsuario += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeGestionUsuario += "1. Registrar usuario.\n";
                        mensajeGestionUsuario += "2. Eliminar usuario.\n";
                        mensajeGestionUsuario += "3. Regresar.";

                        int seleccionGestionUsuario = 0;

                        do {
                            seleccionGestionUsuario = Integer.parseInt(JOptionPane.showInputDialog(mensajeGestionUsuario));

                            switch (seleccionGestionUsuario) {
                                case 1:
                                    //Formulario para registrar usuarios
                                    JOptionPane.showMessageDialog(null, "************************\nRegistro de Usuarios\n************************\n");
                                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario a registar: ");
                                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingresela cedula del usuario a registar: "));
                                    String edad = JOptionPane.showInputDialog("Ingrese la edad del usuario a registar: ");
                                    int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telefono del usuario a registar: "));
                                    String correo = JOptionPane.showInputDialog("Ingrese el correo del usuario a registar: ");
                                    String contraseña = JOptionPane.showInputDialog("Cree una contraseña para el usuario a registar: ");
                                    
                                    //CREAR OBJETO
                                    JOptionPane.showMessageDialog(null, "¡Usuario creado con exito!");
                                    break;
                                
                                case 2:
                                    //Formulario eliminar usuario
                                    JOptionPane.showMessageDialog(null, "************************\nEliminacion de Usuarios\n************************");
                                    correo = JOptionPane.showInputDialog("Ingrese el correo del usuario que desea eliminar: ");
                                    contraseña = JOptionPane.showInputDialog("Ingrese la contraseña del usuario que desea eliminar: ");
                                    //VALIDAR CREDENCIALES
                                    JOptionPane.showMessageDialog(null, "¡Usuario eliminado con exito!");
                                    break;

                                case 3:
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        }while (seleccionGestionUsuario <= 0 || seleccionGestionUsuario >= 4);
                        
                        break;

                    case 2:
                        String mensajeActividades = "";
                        mensajeActividades += "****************************\n";
                        mensajeActividades += "Seleccion de Actividades";
                        mensajeActividades += "****************************\n\n";
                        mensajeActividades += "Por favor ingrese el numero de la actividad que desea seleccionar:\n";
                        mensajeActividades += "1. Yoga.\n";
                        mensajeActividades += "2. Spinning.\n";
                        mensajeActividades += "3. Zumba.\n";
                        mensajeActividades += "4. Crossfit.\n";
                        mensajeActividades += "5. Regresar.";

                        int seleccionActividades = 0;
                        String actividad = "";
                        do {
                            seleccionActividades = Integer.parseInt(JOptionPane.showInputDialog(mensajeActividades));

                            switch (seleccionActividades) {
                                case 1:
                                    actividad = "Yoga";
                                    JOptionPane.showMessageDialog(null, "La actividad '" + actividad + "' se ha guardado correctamente\nRegresando...");
                                    break;

                                case 2:
                                    actividad = "Spinning";
                                    JOptionPane.showMessageDialog(null, "La actividad '" + actividad + "' se ha guardado correctamente\nRegresando...");
                                    break;

                                case 3:
                                    actividad = "Zumba";
                                    JOptionPane.showMessageDialog(null, "La actividad '" + actividad + "' se ha guardado correctamente\nRegresando...");
                                    break;

                                case 4:
                                    actividad = "Crossfit";
                                    JOptionPane.showMessageDialog(null, "La actividad '" + actividad + "' se ha guardado correctamente\nRegresando...");
                                    break;
                                
                                case 5:
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;    
                                
                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }

                        } while (seleccionActividades <= 0 || seleccionActividades >= 6);
                        
                        break;

                    case 3:
                        String mensajeHorario = "";
                        mensajeHorario += "****************************\n";
                        mensajeHorario += "Horarios disponibles\n";
                        mensajeHorario += "****************************\n\n";
                        mensajeHorario += "\n";

                        JOptionPane.showMessageDialog(null, mensajeHorario);
                        
                        //MOSTRAR LOS HORARIOS

                        break;

                    case 4:
                        String mensajeReserva = "";
                        mensajeReserva += "****************************\n";
                        mensajeReserva += "Gestion de reservas\n";
                        mensajeReserva += "****************************\n\n";
                        mensajeReserva += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeReserva += "1. Confirmar reserva.\n";
                        mensajeReserva += "2. Cacelar seleccion\n";
                        mensajeReserva += "3. Consultar historial\n";
                        mensajeReserva += "4. Regresar.";
                        
                        int seleccionReserva = 0;
                        int confirmacion = 0;
                        int idReservacion = 0;
                        
                        do {
                            seleccionReserva = Integer.parseInt(JOptionPane.showInputDialog(mensajeReserva));
                            
                            switch (seleccionReserva) {
                                case 1:
                                    do{
                                        confirmacion = Integer.parseInt(JOptionPane.showInputDialog("A continuacion digite el numero:\n1 para confirmar la reservacion.\n2 para regresar."));

                                        switch (confirmacion) {
                                            case 1:
                                                //REALIZAR CONFIRMACION
                                                JOptionPane.showMessageDialog(null, "Reservacion confirmada");//MOSTRAR ID DE RESERVACION
                                                break;
                                            
                                            case 2:
                                                JOptionPane.showMessageDialog(null, "Regresando...");
                                                break;
                                            
                                            default:
                                                JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                                break;
                                        }   
                                    }while (seleccionReserva <= 0 || seleccionReserva >= 5);
                                    
                                    break;
                                    
                                case 2:
                                    idReservacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ID de la reservacion que desea cancelar: "));
                                    
                                    //BUSCAR ID
                                    //ELIMINAR RESERVA
                                    
                                    JOptionPane.showMessageDialog(null, "Cancelacion realizada con exito.");
                                    
                                    break;
                                    
                                case 3:
                                    JOptionPane.showMessageDialog(null, "*********************\nReservas realizadas\n*********************\n\n");
                                    break;
                                
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;
                                
                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        
                        } while (seleccionReserva <= 0 || seleccionReserva >= 5);
                        
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "¡Muchas gracias, vuelva pronto!\nSaliendo...");
                        salir = true;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                        break;
                }
            } while (seleccionMenuPrincipal <= 0 || seleccionMenuPrincipal >= 6);

        } while (!salir);
    }
}
