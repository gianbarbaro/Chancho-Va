package chanchoVa.entidades;

public class Carta {
    
    private int num;
    private String palo;

    public Carta(int num, String palo) {
        this.num = num;
        this.palo = palo;
    }

    public Carta() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "carta{" + num + " de " + palo + '}';
    }
    
}
