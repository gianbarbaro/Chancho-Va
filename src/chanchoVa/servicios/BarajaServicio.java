package chanchoVa.servicios;

import chanchoVa.entidades.Baraja;
import chanchoVa.entidades.Carta;
import chanchoVa.entidades.Jugador;
import java.util.ArrayList;
import java.util.Collections;

public class BarajaServicio {

    public Baraja crearBaraja() {

        Baraja baraja = new Baraja();

        int cont = 0;
        String palo;

        for (int i = 0; i < 4; i++) {
            cont++;

            switch (cont) {
                case 1:
                    palo = "espada";
                    break;
                case 2:
                    palo = "basto";
                    break;
                case 3:
                    palo = "oro";
                    break;
                case 4:
                    palo = "copa";
                    break;
                default:
                    palo = null;
            }

            for (int j = 0; j < 12; j++) {

                if (j == 7 || j == 8) {
                } else {
                    Carta carta = new Carta(j + 1, palo);
                    baraja.getCartas().add(carta);
                }
            }
        }

        return baraja;
    }

    public void barajar(Baraja baraja) {
        Collections.shuffle(baraja.getCartas());
    }

    public int cartasDisponibles(Baraja baraja) {
        return baraja.getCartas().size();
    }

    public void mostrarMano(Jugador jugador) {
        System.out.println(jugador);
    }

    public boolean darCartas(Baraja baraja, Jugador jugadores, int n) {

        if (cartasDisponibles(baraja) < n) {
            return false;
        } else {
            for (int i = 0; i < n; i++) {
                jugadores.getMano().getCartas().add(siguienteCarta(baraja));
                baraja.getCartas().remove(0);
            }
            return true;
        }

    }

    public void retirarDelMonton(ArrayList<Carta> monton, Jugador jugador) {
        jugador.getMano().getCartas().add(monton.get(monton.size() - 1));
        monton.remove(monton.size() - 1);
    }

    public void cartasMonton(ArrayList<Carta> monton) {

        if (monton.isEmpty()) {
            System.out.println("*Todavía no se ha jugado ninguna carta*");
        } else {
            System.out.println("Monton: " + monton.get(monton.size() - 1));
        }
    }

    public Carta siguienteCarta(Baraja baraja) {

        if (cartasDisponibles(baraja) < 1) {
            System.out.println("No hay más cartas disponibles");
            return null;
        } else if (cartasDisponibles(baraja) == 1) {
            System.out.println("Esta es la útlima carta de la baraja");
            return baraja.getCartas().get(0);
        } else {
            return baraja.getCartas().get(0);
        }
    }

    public boolean chancho(Baraja jugador) {
        
        int cont = 0;
        int numero = jugador.getCartas().get(jugador.getCartas().size() - 1).getNum();

        for (Carta carta : jugador.getCartas()) {
            if (carta.getNum() == numero) {
                cont++;
            }
        }
        return cont == 4;
        
//        HashMap<Integer, Integer> values = new HashMap();
//        for (Carta carta : jugador.getCartas()) {
//            if (values.containsKey(carta.getNum())) {
//                int val = values.get(carta.getNum());
//                values.put(carta.getNum(), val + 1);
//            } else {
//                values.put(carta.getNum(), 0);
//            }
//        }
//        int mayor = 0;
//        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
//            Integer value = entry.getValue();
//            if (value > mayor) {
//                mayor = value;
//            }
//        }

    }

}
