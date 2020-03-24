import Flore.Vegetal;

public class Emplacement {
    private Vegetal vegetal;

    public Vegetal getVegetal() {
        if (vegetal != null) {
            return vegetal;
        }
        return null;
    }

    public void setVegetal(Vegetal vegetal) {
        this.vegetal = vegetal;
    }

    @Override
    public String toString() {
        if (this.vegetal != null) {
            return this.vegetal.toString() + " ";
        } else {
            return "o ";
        }
    }
}
