/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author samim
 */
public class Respaldo_SC202_JN_G1_SistemaDeGestionDeReservasParaUnGimnasio {

    public static void main(String[] args) {
        GestionUsuario gestionUsuario = new GestionUsuario();
        GestionActividad gestionActividad = new GestionActividad();
        GestionHorario gestionHorario = new GestionHorario();
        GestionReserva gestionReserva = new GestionReserva();
        
        boolean salir = false;
        boolean regresar = false;
        //Inicio de sesion
        gestionUsuario.validarInicioSesion();

        do {
            //Menu principal

            String mensajePrincipal = "";
            mensajePrincipal += "**************************************\n";
            mensajePrincipal += "¡Vienvenido al Gimnasio Super Fit!\n";
            mensajePrincipal += "**************************************\n\n";
            mensajePrincipal += "Por favor ingrese el numero de la gestion que desea realizar:\n";
            mensajePrincipal += "1. Usuarios.\n";
            mensajePrincipal += "2. Actividades.\n";
            mensajePrincipal += "3. Horarios.\n";
            mensajePrincipal += "4. Reservas.\n";
            mensajePrincipal += "5. Salir.";

            int seleccionMenuPrincipal = 0;

            do {
                seleccionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(mensajePrincipal));

                switch (seleccionMenuPrincipal) {
                    case 1:
                        //Gestion de usuarios
                        String mensajeGestionUsuario = "";
                        mensajeGestionUsuario += "*************************\n";
                        mensajeGestionUsuario += "Gestion de Usuarios\n";
                        mensajeGestionUsuario += "*************************\n\n";
                        mensajeGestionUsuario += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeGestionUsuario += "1. Listar Usuarios.\n";
                        mensajeGestionUsuario += "2. Registrar usuario.\n";
                        mensajeGestionUsuario += "3. Editar usuario.\n";
                        mensajeGestionUsuario += "4. Eliminar usuario.\n";
                        mensajeGestionUsuario += "5. Regresar.";

                        int seleccionGestionUsuario = 0;

                        do {
                            regresar = false;
                            seleccionGestionUsuario = Integer.parseInt(JOptionPane.showInputDialog(mensajeGestionUsuario));
                            
                            switch (seleccionGestionUsuario) {
                                case 1: //Listar Usuarios
                                    JOptionPane.showMessageDialog(null, gestionUsuario.listarUsuarios());
                                    break;
                                
                                case 2: //Registrar Usuarios
                                    gestionUsuario.registrarUsuario();
                                    break;
                                    
                                case 3: //Editar Usuarios
                                    gestionUsuario.editarUsuario();
                                    break;
                                
                                case 4: //Eliminar Usuario
                                    gestionUsuario.eliminarUsuario();
                                    break;

                                case 5: //Regresar
                                    regresar = true;
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        }while (regresar == false);
                        
                        break;

                    case 2:
                        //Gestion de actividades
                        String mensajeActividades = "";
                        mensajeActividades += "**************************\n";
                        mensajeActividades += "Gestion de Actividades\n";
                        mensajeActividades += "**************************\n\n";
                        mensajeActividades += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeActividades += "1. Listar actividades.\n";
                        mensajeActividades += "2. Crear actividad.\n";
                        mensajeActividades += "3. Editar actividad.\n";
                        mensajeActividades += "4. Eliminar actividad.\n";
                        mensajeActividades += "5. Regresar.";

                        int seleccionActividades = 0;
                        
                        do {
                            regresar = false;
                            seleccionActividades = Integer.parseInt(JOptionPane.showInputDialog(mensajeActividades));
                            
                            switch (seleccionActividades) {
                                case 1: //Listar Actividades
                                    JOptionPane.showMessageDialog(null, gestionActividad.listarActividades());
                                    break;
                                
                                case 2: //Crear Actividad
                                    gestionActividad.crearActividad();
                                    break;
                                    
                                case 3: //Editar Actividad
                                    gestionActividad.editarActividad();
                                    break;
                                
                                case 4: //Eliminar Actividad
                                    gestionActividad.eliminarActividad();
                                    break;

                                case 5: //Regresar
                                    regresar = true;
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        }while (regresar == false);
                        
                        break;

                    case 3:
                        //Gestion de horarios
                        String mensajeHorario = "";
                        mensajeHorario += "****************************\n";
                        mensajeHorario += "Gestion de Horarios\n";
                        mensajeHorario += "****************************\n\n";
                        mensajeHorario += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeHorario += "1. Listar horarios.\n";
                        mensajeHorario += "2. Crear horario.\n";
                        mensajeHorario += "3. Editar horario.\n";
                        mensajeHorario += "4. Eliminar horario.\n";
                        mensajeHorario += "5. Regresar.";
                        
                        int seleccionHorario = 0;
                        
                        do {
                            regresar = false;
                            seleccionHorario = Integer.parseInt(JOptionPane.showInputDialog(mensajeHorario));
                            
                            switch (seleccionHorario) {
                                case 1: //Listar Horarios
                                    JOptionPane.showMessageDialog(null, gestionHorario.listaHorarios());
                                    break;
                                
                                case 2: //Crear Horario
                                    gestionHorario.crearHorario();
                                    break;
                                    
                                case 3: //Editar Horario
                                    gestionHorario.editarHorario();
                                    break;
                                
                                case 4: //Eliminar Horario
                                    gestionHorario.eliminarHorario();
                                    break;

                                case 5: //Regresar
                                    regresar = true;
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        }while (regresar == false);

                        break;

                    case 4:
                        //Realizar reservas
                        String mensajeReserva = "";
                        mensajeReserva += "****************************\n";
                        mensajeReserva += "Gestion de reservas\n";
                        mensajeReserva += "****************************\n\n";
                        mensajeReserva += "Por favor ingrese el numero de la accion que desea realizar:\n";
                        mensajeReserva += "1. Listar reserva.\n";
                        mensajeReserva += "2. Crear Reserva\n";
                        mensajeReserva += "3. Eliminar Reserva\n";
                        mensajeReserva += "4. Regresar.";
                        
                        int seleccionReserva = 0;
                        
                        do {
                            seleccionReserva = Integer.parseInt(JOptionPane.showInputDialog(mensajeReserva));
                            
                            switch (seleccionReserva) {
                                case 1:
                                    JOptionPane.showMessageDialog(null, gestionReserva.listaReservas());
                                    break;
                                    
                                case 2:
                                    gestionReserva.crearReserva(gestionUsuario, gestionHorario, gestionActividad);
                                    break;
                                    
                                case 3:
                                    gestionReserva.eliminarReserva();
                                    break;
                                
                                case 4:
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    regresar = true;
                                    break;
                                
                                default:
                                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta, por favor intente de nuevo.");
                                    break;
                            }
                        
                        } while (regresar == false);
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
