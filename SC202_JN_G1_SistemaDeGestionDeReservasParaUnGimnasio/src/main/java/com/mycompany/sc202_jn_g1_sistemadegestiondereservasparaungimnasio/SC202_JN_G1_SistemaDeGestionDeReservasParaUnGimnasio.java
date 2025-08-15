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
    // Arreglo que actúa como "base de datos" en memoria

    public static Usuario [] usuarios = new Usuario [10];

    public static void main(String[] args) {
        
        //Importar clase Horario
        Horario[] horarios = new Horario[10];
        horarios[0] = new Horario ("10/09/2025", "06:00",  "07:00", "Crossfit");
        horarios[1] = new Horario ("10/09/2025", "07:00",  "08:00", "Spinning");
        horarios[2] = new Horario ("10/09/2025", "08:00",  "09:00", "Zumba");
        horarios[3] = new Horario ("10/09/2025", "09:00",  "10:00", "Yoga");
        horarios[4] = new Horario ("10/09/2025", "10:00",  "11:00", "Crossfit");
        horarios[5] = new Horario ("10/09/2025", "11:00",  "12:00", "Yoga");
        horarios[6] = new Horario ("10/09/2025", "12:00",  "13:00", "Zumba");
        horarios[7] = new Horario ("10/09/2025", "13:00",  "14:00", "Spinning");
        
        //Creacion de usuarios Precargados  + espacios vacios para agregar los usuarios nuevos 
        usuarios [0] = new Usuario ("111111111", "Samuel", 83.1, "19999999","samuel@superfit.com", "tsai", 22);
        usuarios [1] = new Usuario ("222222222", "Matias", 74.2, "28888888","matias@superfit.com", "Cabalceta", 18);
        usuarios [2] = new Usuario ("333333333", "Santiago", 65.3, "37777777","santiago@superfit.com", "paniagua", 19);
        usuarios [3] = new Usuario ("444444444", "Jimena", 60.4, "466666666","jimena@superfit.com", "lopez", 20);
        for (int i=4;i<usuarios.length;i++) {
            usuarios[i] = new Usuario("1","vacio",1.1,"1","vacio@prueba.com","vacio",1);
        }
        
        //Importar clase Actividad
        Actividad[] actividades = new Actividad[4];
        actividades[0] = new Actividad ("Yoga", 1, 60, "L - K - S");
        actividades[1] = new Actividad ("Spinning", 2, 120, "M - K");
        actividades[2] = new Actividad ("Zumba", 3, 90, "L - S - D");
        actividades[3] = new Actividad ("Crossfit", 4, 60, "V - S");
        
        //Importar clase Reserva
        Reserva[] reservas = new Reserva[10];
        
        //Inicio de sesion
        ValidarInicioSesion validarInicioSesion = new ValidarInicioSesion(usuarios);
        validarInicioSesion.validarCredenciales();
        boolean salir = false;
        do {
            //Menu principal

            String mensajePrincipal = "";
            mensajePrincipal += "******************************************\n";
            mensajePrincipal += "¡Bienvenido al Gimnasio Super Fit!\n";
            mensajePrincipal += "******************************************\n\n";
            mensajePrincipal += "Por favor ingrese el numero de la accion que desea realizar:\n";
            mensajePrincipal += "1. Gestion de usuarios.\n";
            mensajePrincipal += "2. Clases disponibles.\n";
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
                        mensajeGestionUsuario += "2. Editar usuario.\n";
                        mensajeGestionUsuario += "3. Regresar.";

                        int seleccionGestionUsuario = 0;

                        do {
                            seleccionGestionUsuario = Integer.parseInt(JOptionPane.showInputDialog(mensajeGestionUsuario));

                            switch (seleccionGestionUsuario) {
                                case 1:
                                    //CREAR OBJETO
                                    registrarUI();
                                    break;
                                
                                case 2:
                                    //Formulario editar usuario
                                    editarUI();
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
                        for (int i = 0; i < actividades.length; i++){
                            actividades[i].mostrarClase();
                        }
                        break;

                    case 3:
                        //MOSTRAR LOS HORARIOS
                        Horario.menuHorarios(horarios);
                        break;

                    case 4:
                        //Menu Reserva
                        Reserva.menuReservas(reservas, usuarios, horarios);
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
    // Metodo de registro //
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
    //Metodo para editar el usuario//
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
    //Metodo para loguearse correctamente//
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
  //Metodo vacio // Comprueba si el texto que se escribe es vacio o si preciono cancelar
private static boolean vacio(String s) {
    return s == null || s.length() == 0;
}

// Metodo que convierte texto en numero entero int 
private static int parseInt(String s, int def) {
    try {
        return Integer.parseInt(s);
    } catch (Exception e) {
        return def;
    }
}

    // Metodo que convierto texto a numeros pero decimales para evitar que el codigo se rompa si se agrega un texto enves de numero
private static double parseDouble(String s, double def) {
    try {
        return Double.parseDouble(s);
    } catch (Exception e) {
        return def;
    }
}


}
