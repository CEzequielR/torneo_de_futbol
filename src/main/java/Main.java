
import org.example.clases.*;
import javax.swing.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenidos al torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
       //Lista de equipos disponibles y participantes
        ArrayList<Equipo> listaDeEquipos = new ArrayList<>();
        listaDeEquipos.add(new Equipo("Ecuador"));
        listaDeEquipos.add(new Equipo("Francia"));
        listaDeEquipos.add(new Equipo("España"));
        listaDeEquipos.add(new Equipo("Brasil"));
        listaDeEquipos.add(new Equipo("Italia"));
        listaDeEquipos.add(new Equipo("Alemania"));
        listaDeEquipos.add(new Equipo("Perú"));
        listaDeEquipos.add(new Equipo("Argentina"));
        //Inicializamos el juego eligiendo un equipo para sumar puntaje
        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);
        //Creamos las dos llaves que contienen los equipos
        Llave llaveDerecha = new Llave();
        Llave llaveIzquierda = new Llave();
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        llaveIzquierda.armarLlave(listaDeEquipos, 4);

        Ronda ronda = new Ronda();
        //Cuartos de final
        ronda.cuartosDeFinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        //Semifinal
        ronda.semifinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        //Final
        ronda.finalDelTorneo(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        //Mensaje para saber cuantos puntos recolecto el jugador.
        JOptionPane.showMessageDialog(null,
                "Has conseguido "+jugador.getPuntaje()+ " por elegir al equipo "+jugador.getEquipoSeleccionado().getNombre(),
                "Nombre",
                JOptionPane.INFORMATION_MESSAGE);
    }
}