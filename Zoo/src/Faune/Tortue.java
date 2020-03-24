package Faune;

public class Tortue extends Reptile {
    private int vitesse;

    public Tortue(String nom, int nbVertebres, int nbEcailles, int vitesse) {
        super(nom, nbVertebres, nbEcailles);
        this.vitesse = vitesse;
    }

    @Override
    public String toString() {
        return super.toString() + ", je vais à " + vitesse + "km/h";
    }
}
