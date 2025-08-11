package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;
import javax.swing.JOptionPane;

public class Horario {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String actividad;

    public Horario(String dia, String horaInicio, String horaFin, String actividad) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.actividad = actividad;
    }
    
    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }

    public String mostrarHorario() {
        return dia + " de " + horaInicio + " a " + horaFin + " - Actividad: " + actividad;
    }

    public static void menuHorarios(Horario[] horarios) {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "Menú Horarios\n" +
                "1. Crear horario\n" +
                "2. Listar horarios\n" +
                "3. Salir\n" +
                "Elige opción:"
            );
            if (opcion == null) break;
            switch (opcion) {
                case "1": {
                    String dia = JOptionPane.showInputDialog("Ingrese día:");
                    if (dia == null || dia.trim().isEmpty()) break;
                    String horaInicio = JOptionPane.showInputDialog("Ingrese hora de inicio (ej: 08:00):");
                    if (horaInicio == null || horaInicio.trim().isEmpty()) break;
                    String horaFin = JOptionPane.showInputDialog("Ingrese hora de fin (ej: 09:00):");
                    if (horaFin == null || horaFin.trim().isEmpty()) break;
                    String actividad = JOptionPane.showInputDialog("Ingrese actividad:");
                    if (actividad == null || actividad.trim().isEmpty()) break;

                    boolean guardado = false;
                    for (int i = 0; i < horarios.length; i++) {
                        if (horarios[i] == null) {
                            horarios[i] = new Horario(dia, horaInicio, horaFin, actividad);
                            JOptionPane.showMessageDialog(null, "Horario creado correctamente.");
                            guardado = true;
                            break;
                        }
                    }
                    if (!guardado) {
                        JOptionPane.showMessageDialog(null, "No hay espacio para más horarios.");
                    }
                    break;
                }
                case "2": {
                    String lista = "";
                    for (int i = 0; i < horarios.length; i++) {
                        if (horarios[i] != null) {
                            lista += (i + 1) + ". " + horarios[i].mostrarHorario() + "\n";
                        }
                    }
                    if (lista.isEmpty()) {
                        lista = "No hay horarios disponibles.";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                }
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}

