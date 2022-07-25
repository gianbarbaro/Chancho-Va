package chanchoVa;

import chanchoVa.entidades.Baraja;
import chanchoVa.entidades.Carta;
import chanchoVa.entidades.Jugador;
import chanchoVa.servicios.BarajaServicio;
import java.util.ArrayList;
import java.util.Scanner;

public class ChanchoVa {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        Jugador player = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList();

        ArrayList<Carta> monton = new ArrayList();

        BarajaServicio servicio = new BarajaServicio();

        System.out.println("Ingrese la cantidad de jugadores (2 o más)");
        int n = leer.nextInt();

        for (int i = 0; i < n; i++) {
            jugadores.add(player.crearJugador(i));
        }

        Baraja baraja = servicio.crearBaraja();
        servicio.barajar(baraja);

        System.out.println("STARTING GAME...");
        System.out.println("*repartiendo cartas*");

        for (int i = 0; i < jugadores.size(); i++) {

            if (!servicio.darCartas(baraja, jugadores.get(i), 4)) {
//                servicio.mostrarMano(jugadores.get(i));
                System.out.println("No hay suficientes cartas disponibles");
            }
        }
        monton.add(servicio.siguienteCarta(baraja));
        baraja.getCartas().remove(0);

        int cont = 0;
        String resp;
        do {
            System.out.println(" ");
            servicio.cartasMonton(monton);
            System.out.println(" ");

            servicio.mostrarMano(jugadores.get(cont));

            System.out.println("Retirar una carta");
            System.out.println("1.Baraja o 2.Monton");
            resp = leer.next();
            switch (resp) {
                case "2":
                    servicio.retirarDelMonton(monton, jugadores.get(cont));
                    servicio.mostrarMano(jugadores.get(cont));
                    break;
                default:
                    servicio.darCartas(baraja, jugadores.get(cont), 1);
                    servicio.mostrarMano(jugadores.get(cont));
            }

//            System.out.println("¿Chancho? (s/n)");
//            resp = leer.next();
            if (servicio.chancho(jugadores.get(cont).getMano())) {
                System.out.println("¡CHANCHO! " + jugadores.get(cont).getNom() + " gana");
                break;
            } else {
                System.out.println("Ingrese la posición de la carta a descartar");
                int pos = leer.nextInt();
                monton.add(jugadores.get(cont).getMano().getCartas().get(pos - 1));
                jugadores.get(cont).getMano().getCartas().remove(pos - 1);
            }

            if (cont == jugadores.size() - 1) {
                cont = 0;
            } else {
                cont++;
            }
        } while (!servicio.chancho(jugadores.get(cont).getMano()));
    }

}
