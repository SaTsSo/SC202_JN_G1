package com.mycompany.proyectoo;
public class horario {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String actividad;

    public horario(String dia, String horaInicio, String horaFin, String actividad) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.actividad = actividad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String mostrarHorario() {
        return dia + " de " + horaInicio + " a " + horaFin + " - Actividad: " + actividad;
    }
}
