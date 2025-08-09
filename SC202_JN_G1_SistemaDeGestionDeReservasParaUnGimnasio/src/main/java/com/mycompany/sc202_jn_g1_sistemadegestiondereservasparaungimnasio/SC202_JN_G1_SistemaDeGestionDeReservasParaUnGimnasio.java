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
        
        while (true) {
            String op = JOptionPane.showInputDialog(
                "=== GIMNASIO Super Fit===\n" +
                "1) Registrar usuario\n" +
                "2) Editar usuario (por cédula)\n" +
                "3) Login (cédula o correo)\n" +
                "4) Listar usuarios\n" +
                "0) Salir\n" +
                "Elige opción:"
            );
            if (op == null) break;
            int opcion = toInt(op, -1);
            if (opcion == 0) break;

            switch (opcion) {
                case 1: registrarUI();  break;
                case 2: editarUI();     break;
                case 3: loginUI();      break;
                case 4: listarUI();     break;
                default: JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
    
    private static void registrarUI() {
        String ced = in("Cédula:");
        if (isBlank(ced)) return;
        String nom = in("Nombre:");
        if (isBlank(nom)) return;
        String tel = in("Teléfono:");
        if (isBlank(tel)) return;
        String email = in("Correo:");
        if (isBlank(email)) return;
        String pass = in("Contraseña:");
        if (isBlank(pass)) return;
       

        Usuario nuevo = new Usuario(ced, nom, 0.0, tel, email, pass, 0); 
        boolean ok = Usuario.registrar(usuarios, nuevo);
        JOptionPane.showMessageDialog(null, ok ? "Registrado." : "No se pudo registrar (duplicado o sin espacio).");
    }
        private static void editarUI() {
        String ced = in("Cédula del usuario a editar:");
        if (isBlank(ced)) return;

        int idx = Usuario.buscarPorCedula(usuarios, ced);
        if (idx == -1) { JOptionPane.showMessageDialog(null, "No existe esa cédula."); return; }

        Usuario u = usuarios[idx];
        JOptionPane.showMessageDialog(null, "Actual:\n" + u.resumen());

        String nuevoNombre = vacioANull(in("Nuevo nombre (vacío = no cambiar):"));
        String nuevoTelefono = vacioANull(in("Nuevo teléfono (vacío = no cambiar):"));
        String nuevoCorreo = vacioANull(in("Nuevo correo (vacío = no cambiar):"));
        String nuevaPass = vacioANull(in("Nueva contraseña (vacío = no cambiar):"));
        String nuevoPesoS = vacioANull(in("Nuevo peso (número, vacío = no cambiar):"));
        String activoS = vacioANull(in("Activo? (S/N, vacío = no cambiar):"));

        Double nuevoPeso = (nuevoPesoS == null) ? null : toDouble(nuevoPesoS, u.getPeso());
        Boolean nuevoActivo = null;
        if (activoS != null) {
            char c = Character.toLowerCase(activoS.charAt(0));
            nuevoActivo = (c == 's');
        }

        boolean ok = Usuario.editarPorCedula(usuarios, ced, nuevoNombre, nuevoPeso, nuevoTelefono,
                                             nuevoCorreo, nuevaPass, nuevoActivo);
        JOptionPane.showMessageDialog(null, ok ? "Editado." : "No se pudo editar (correo duplicado u otro problema).");
    }
        
        private static void loginUI() {
        String user = in("Usuario (cédula o correo):");
        if (isBlank(user)) return;
        String pass = in("Contraseña:");
        if (isBlank(pass)) return;

        Usuario ok = Usuario.login(usuarios, user, pass);
        JOptionPane.showMessageDialog(null, (ok != null) ? "Login OK. Bienvenido/a " + ok.getNombre()
                                                         : "Login fallido.");
    }
        
        private static void listarUI() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<usuarios.length;i++) {
            Usuario u = usuarios[i];
            if (u != null && !(u.getCedula().equals("1") && u.getNombre().equalsIgnoreCase("vacio"))) {
                sb.append(i).append(": ").append(u.resumen()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.length()>0 ? sb.toString() : "No hay usuarios (solo vacíos).");
    }
        private static String in(String msg) { return JOptionPane.showInputDialog(msg); }
    private static boolean isBlank(String s) {
        if (s == null) return true;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c!=' ' && c!='\t' && c!='\n' && c!='\r') return false;
        }
        return true;
    } 
    private static String vacioANull(String s) { return isBlank(s) ? null : s; }

    private static int toInt(String s, int def) {
        if (s == null || s.length()==0) return def;
        int sign = 1, i = 0, n = s.length(), val = 0;
        if (s.charAt(0)=='-'){ sign=-1; i=1; }
        for (; i<n; i++) {
            char c = s.charAt(i);
            if (c<'0' || c>'9') return def;
            val = val*10 + (c-'0');
        }
        return sign*val;
    } 
    
    private static double toDouble(String s, double def) {
        if (s == null || s.length()==0) return def;
        boolean dot = false; int sign=1, i=0; double val=0, div=1;
        if (s.charAt(0)=='-'){ sign=-1; i=1; }
        for (; i<s.length(); i++) {
            char c=s.charAt(i);
            if (c=='.') { if (dot) return def; dot=true; continue; }
            if (c<'0'||c>'9') return def;
            if (!dot) val = val*10 + (c-'0');
            else { div *= 10; val += (c-'0')/div; }
        }
        return sign*val;
    }    //Agregado por Jimena - para la clase usuario

        
        boolean salir = false;
        
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
