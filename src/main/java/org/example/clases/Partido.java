package org.example.clases;
import javax.swing.*;
import java.util.Random;

import static org.example.enumeradores.Resultado.*;

public class Partido {
    //Inicializamos los elementos de esta forma para conseguir que los goles sean aleatorios.
    private int golesLocal= new Random().nextInt(0,1);
    private int golesVisitante = new Random().nextInt(0,1);

    //Constructores
    public Partido() {
    }

    public Partido(int goleslocal, int golesVisitante) {
        this.golesLocal = goleslocal;
        this.golesVisitante = golesVisitante;
    }
    //Setters and getters

    public int getGoleslocal() {
        return golesLocal;
    }
    public void setGoleslocal(int goleslocal) {
        this.golesLocal = goleslocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    //Nos permite simular los partidos del torneo

    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {
        JOptionPane.showMessageDialog(null,
                equipoLocal.getNombre() + " " + this.getGoleslocal() + " - " + this.getGolesVisitante() + " " + equipoVisitante.getNombre(),
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

        equipoLocal.sumarGolesNuevos(this.getGoleslocal());
        equipoVisitante.sumarGolesNuevos(this.getGolesVisitante());

        //Aquí tendremos las 3 opciones que puede tener nuestro torneo:
        // gana equipo local, empate o gana visitante.

        if (this.golesLocal > this.golesVisitante) {
            equipoVisitante.setAutorizacion((false));
            equipoLocal.setResultado(ganador);
            equipoVisitante.setResultado(perdedor);
            JOptionPane.showMessageDialog(null,
                    "Ganó " + equipoLocal.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoLocal;
        }
        else if (this.golesLocal == this.golesVisitante) {
            JOptionPane.showMessageDialog(null,
                    "Se jugaran penales entre " + equipoLocal.getNombre() + " - " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Los penales finalizaron de la siguiente forma: "
                    + equipoLocal.getNombre() + " "+ new Random().nextInt(4, 5)+ " - "
                    + new Random().nextInt(0, 3)+" "+  equipoVisitante.getNombre());
            equipoLocal.setResultado(ganador);
            equipoVisitante.setResultado(perdedor);
        }
        else {
            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultado(perdedor);
            equipoVisitante.setResultado(ganador);
            JOptionPane.showMessageDialog(null,
                    "Ganó " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoVisitante;
        }
        return null;
    }
}
