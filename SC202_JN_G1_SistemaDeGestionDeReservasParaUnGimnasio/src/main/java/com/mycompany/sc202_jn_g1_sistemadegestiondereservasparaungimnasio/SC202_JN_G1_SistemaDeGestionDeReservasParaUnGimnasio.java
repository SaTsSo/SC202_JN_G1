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
    //Agregado por Jimena - para la clase usuario
    public static Usuario [] usuarios = new Usuario [10];

    public static void main(String[] args) {
        
        
        usuarios [0] = new Usuario ("111111111", "samuel", 83.1, "19999999","samuel@prueba.com", "tsai", 22);
        usuarios [1] = new Usuario ("222222222", "matias", 74.2, "28888888","matias@prueba.com", "Cabalceta", 18);
        usuarios [2] = new Usuario ("333333333", "santiago", 65.3, "37777777","santiago@prueba.com", "paniagua", 19);
        usuarios [3] = new Usuario ("444444444", "jimena", 60.4, "466666666","jimena@prueba.com", "lopez", 20);
        for (int i=4;i<usuarios.length;i++) {
            usuarios[i] = new Usuario("1","vacio",1.1,"1","vacio@prueba.com","vacio",1);
        }
        
            menuPrincipal();
    }
        
        private static void menuPrincipal() {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "=== GIMNASIO: USUARIOS ===\n" +
                "1) Registrar usuario\n" +
                "2) Editar usuario (por cédula)\n" +
                "3) Login (cédula o correo)\n" +
                "0) Salir\n" +
                "Opción:"
            );
            if (opcion == null) break;

            if (opcion.equals("1")) {
                registrarUI();
            } else if (opcion.equals("2")) {
                editarUI();
            } else if (opcion.equals("3")) {
                loginUI();
            } else if (opcion.equals("0")) {
                salir = true;
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
        
        private static void registrarUI() {
        String ced = JOptionPane.showInputDialog("Cédula:");
        if (vacio(ced)) return;
        if (Usuario.existeCedula(usuarios, ced)) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa cédula.");
            return;
        }
        
        String nom = JOptionPane.showInputDialog("Nombre:");
        if (vacio(nom)) return;

        String tel = JOptionPane.showInputDialog("Teléfono:");
        if (vacio(tel)) return;

        String cor = JOptionPane.showInputDialog("Correo:");
        if (vacio(cor)) return;
        if (Usuario.existeCorreo(usuarios, cor)) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese correo.");
            return;
        }
        
        String pesoTxt = JOptionPane.showInputDialog("Peso (ej. 70.5):");
        if (vacio(pesoTxt)) return;
        double peso = parseDouble(pesoTxt, -1);
        if (peso <= 0) {
            JOptionPane.showMessageDialog(null, "Peso inválido.");
            return;
        }
        
        String edadTxt = JOptionPane.showInputDialog("Edad (entero):");
        if (vacio(edadTxt)) return;
        int edad = parseInt(edadTxt, -1);
        if (edad < 0) {
            JOptionPane.showMessageDialog(null, "Edad inválida.");
            return;
        }
        String pass = JOptionPane.showInputDialog("Contraseña:");
        if (vacio(pass)) return;

        Usuario nuevo = new Usuario(ced, nom, peso, tel, cor, pass, edad);
        boolean ok = Usuario.registrar(usuarios, nuevo);

        if (ok) {
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar (duplicado o sin espacio).");
        }
    }

        private static void editarUI() {
        String ced = JOptionPane.showInputDialog("Cédula del usuario a editar:");
        if (vacio(ced)) return;

        Usuario actual = null;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null
                    && !usuarios[i].getCedula().equals("1")
                    && usuarios[i].getCedula().equals(ced)) {
                actual = usuarios[i];
                break;
            }
        }
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No existe esa cédula.");
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Actual:\n" + actual.resumen());

        String nuevoNombre   = JOptionPane.showInputDialog("Nuevo nombre (vacío = no cambiar):");
        String nuevoPesoTxt  = JOptionPane.showInputDialog("Nuevo peso (vacío = no cambiar):");
        String nuevoTelefono = JOptionPane.showInputDialog("Nuevo teléfono (vacío = no cambiar):");
        String nuevoCorreo   = JOptionPane.showInputDialog("Nuevo correo (vacío = no cambiar):");
        String nuevaPass     = JOptionPane.showInputDialog("Nueva contraseña (vacío = no cambiar):");
        String nuevaEdadTxt  = JOptionPane.showInputDialog("Nueva edad (vacío = no cambiar):");
        String activoTxt     = JOptionPane.showInputDialog("Activo? (S/N, vacío = no cambiar):");

        Double  nuevoPeso = null;
        if (!vacio(nuevoPesoTxt)) nuevoPeso = Double.valueOf(parseDouble(nuevoPesoTxt, -1));

        Integer nuevaEdad = null;
        if (!vacio(nuevaEdadTxt)) nuevaEdad = Integer.valueOf(parseInt(nuevaEdadTxt, -1));

        Boolean nuevoActivo = null;
        if (!vacio(activoTxt)) {
            if (activoTxt.equalsIgnoreCase("S")) {
                nuevoActivo = true;
            } else if (activoTxt.equalsIgnoreCase("N")) {
                nuevoActivo = false;
        }
    }
        
        if (vacio(nuevoNombre))   nuevoNombre = null;
        if (vacio(nuevoTelefono)) nuevoTelefono = null;
        if (vacio(nuevoCorreo))   nuevoCorreo = null;
        if (vacio(nuevaPass))     nuevaPass = null;

        boolean ok = Usuario.editar(usuarios, ced, nuevoNombre, nuevoPeso,
                                    nuevoTelefono, nuevoCorreo, nuevaPass,
                                    nuevaEdad, nuevoActivo);

        if (ok) {
            JOptionPane.showMessageDialog(null, "Editado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo editar (correo duplicado u otro problema).");
        }
    }

        private static void loginUI() {
        String user = JOptionPane.showInputDialog("Usuario (cédula o correo):");
        if (vacio(user)) return;

        String pass = JOptionPane.showInputDialog("Contraseña:");
        if (vacio(pass)) return;

        boolean ok = Usuario.login(usuarios, user, pass);

        if (ok) {
            JOptionPane.showMessageDialog(null, "Login OK. Bienvenido/a.");
        } else {
            JOptionPane.showMessageDialog(null, "Login fallido.");
        }
    }
        private static boolean vacio(String s) {
            return s == null || s.length() == 0;
    }
        private static int parseInt(String s, int def) {
            try { return Integer.parseInt(s); } catch (Exception e) { return def; }
    }
        private static double parseDouble(String s, double def) {
            try { return Double.parseDouble(s); } catch (Exception e) { return def; }
    }
}
    }
    
        
        //Inicio de sesion
        ValidarInicioSesion validarInicioSesion = new ValidarInicioSesion(usuarios);
        validarInicioSesion.validarCredenciales();

        do {
            //Menu principal

            String mensajePrincipal = "";
            mensajePrincipal += "******************************************\n";
            mensajePrincipal += "¡Bienvenido al Gimnasio Super Fit!\n";
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
