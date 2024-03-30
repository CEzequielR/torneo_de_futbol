package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Jugador {
    private Equipo equipoSeleccionado;
    private int puntaje;

    //Constructores
    public Jugador() {
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }
    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Elementos para elegir el equipo
    public void elegirEquipo(List<org.example.clases.Equipo> listaDeEquipos) {
        String listadeEquiposenMensaje = "Equipos: \n";
        //Nos da la lista de equipos disponibles
        for (int i = 0; i < listaDeEquipos.size(); i++) {
            listadeEquiposenMensaje += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, listadeEquiposenMensaje, "Selección de equipo.", JOptionPane.INFORMATION_MESSAGE);
        //Nos pide que ingresemos que equipos queremos elegir
        int indiceEquipos;
        do {
            indiceEquipos = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingresa el número del equipo que quieres seleccionar: ",
                    "Ingrese un valor", JOptionPane.INFORMATION_MESSAGE)) - 1;
        }
        while (indiceEquipos < 0 || indiceEquipos >= 8);
        JOptionPane.showMessageDialog(null, "Seleccionaste a: " + listaDeEquipos.get(indiceEquipos).getNombre());
        this.equipoSeleccionado = listaDeEquipos.get(indiceEquipos);
    }
    //Elemento que permite sumar puntos cada vez que gane el equipo elegido
    public void sumarPuntos() {
        if (equipoSeleccionado.getAutorizacion()) {
            puntaje++;
        }
    }
}
