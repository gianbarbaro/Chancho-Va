package chanchoVa.entidades;

import java.util.ArrayList;

public class Baraja {
    
    private ArrayList<Carta> cartas;

    public Baraja(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Baraja() {
        cartas = new ArrayList();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Cartas: " + cartas;
    }
    
}
