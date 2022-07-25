package chanchoVa.entidades;

public class Jugador {
    
    private String nom;
    private Baraja mano;

    public Jugador(String nom) {
        this.nom = nom;
        mano = new Baraja();
    }

    public Jugador() {
        mano = new Baraja();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Baraja getMano() {
        return mano;
    }

    public void setMano(Baraja mano) {
        this.mano = mano;
    }

    public Jugador crearJugador(int i) {
        return new Jugador("Jugador " + (i+1));
    }
    
    @Override
    public String toString() {
        return nom + "\n" + mano;
    }
    
}
