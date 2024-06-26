package org.example.clases;
import javax.swing.*;
import java.util.List;

public class Ronda {
    //Elementos privados
    private int numeroDeRonda;
    private int cantidadDeEquiposenRonda;
    private int cantidadDeEquiposEnLlave;
    //Constructores
    public Ronda() {
    }

    public Ronda(int numeroDeRonda, int cantidadDeEquiposenRonda, int cantidadDeEquiposEnLlave) {
        this.numeroDeRonda = numeroDeRonda;
        this.cantidadDeEquiposenRonda = cantidadDeEquiposenRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }
    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public int getCantidadDeEquiposenRonda() {
        return cantidadDeEquiposenRonda;
    }

    public void setCantidadDeEquiposenRonda(int cantidadDeEquiposenRonda) {
        this.cantidadDeEquiposenRonda = cantidadDeEquiposenRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    //Remover equipos
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;

        for(int i=0; i<contadorEquiposPorLlave; i++){
            Equipo auxiliar=equipos.get(i);
            if(!auxiliar.getAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }
    //Rondas
    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha) {
        this.numeroDeRonda = 1;
        this.cantidadDeEquiposEnLlave =4;
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null,
                "Se jugarán los cuartos de finales",
                "Cuartos", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i< cantidadDeEquiposEnLlave; i+=2){
            partido.simularPartido(llaveIzquierda.getEquiposDeLlave().get(i),
                    llaveIzquierda.getEquiposDeLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposDeLlave().get(i),
                    llaveDerecha.getEquiposDeLlave().get(i+1));
        }
        removerEquipos(llaveIzquierda.getEquiposDeLlave());
        removerEquipos(llaveDerecha.getEquiposDeLlave());
        this.cantidadDeEquiposEnLlave =2;
    }

    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha){
        this.numeroDeRonda =2;
        JOptionPane.showMessageDialog(null, "Se jugará la semifinal.",
                "Semifinal", JOptionPane.INFORMATION_MESSAGE);
        Partido partido=new Partido();
        for (int i = 0; i< cantidadDeEquiposEnLlave; i+=2) {
            partido.simularPartido(llaveIzquierda.getEquiposDeLlave().get(i),
                    llaveIzquierda.getEquiposDeLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposDeLlave().get(i),
                    llaveDerecha.getEquiposDeLlave().get(i+1));
        }
        removerEquipos(llaveDerecha.getEquiposDeLlave());
        removerEquipos(llaveIzquierda.getEquiposDeLlave());
    }
    public void finalDelTorneo(Llave llaveIzquierda, Llave llaveDerecha) {
        this.numeroDeRonda = 3;
        JOptionPane.showMessageDialog(null,
                "Se jugará la final.",
                "Final",
                JOptionPane.INFORMATION_MESSAGE);
        Partido partido = new Partido();

        Equipo equipo = partido.simularPartido(llaveDerecha.getEquiposDeLlave().get(0), llaveIzquierda.getEquiposDeLlave().get(0));

        JOptionPane.showMessageDialog(null, "El ganador del torneo es: "+equipo.getNombre(),
                "Ganador del torneo", JOptionPane.INFORMATION_MESSAGE);
    }
}
