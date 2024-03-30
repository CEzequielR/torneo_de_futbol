package org.example.clases;
import org.example.enumeradores.Resultado;

public class Equipo {
    //Elementos privados
    private String nombre;
    private boolean autorizacion = true;
    private Resultado resultado;
    private int cantidadGolesEnElTorneo;
    //constructores
    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    public Equipo(String nombre, boolean autorizacion, Resultado resultado, int cantidadGolesEnElTorneo) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultado = resultado;
        this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo;
    }

    //Setters and getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAutorizacion() {
        return autorizacion;
    }
    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultado() {
        return resultado;
    }
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public int getCantidadGolesEnElTorneo() {
        return cantidadGolesEnElTorneo;
    }
    public void setCantidadGolesEnElTorneo(int cantidadGolesEnElTorneo) {
        this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo;
    }
    //Esto nos permite sumar los goles que realiza el equipo en un torneo
    public void sumarGolesNuevos(int nuevosGoles) {
        this.cantidadGolesEnElTorneo += nuevosGoles;
    }
}
