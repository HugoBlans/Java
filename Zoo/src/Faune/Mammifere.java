package Faune;

public class Mammifere extends Vertebre {
    private int nbMamelles;

    public Mammifere(String nom, int nbVertebres, int nbMamelles) {
        super(nom, nbVertebres);
        this.nbMamelles = nbMamelles;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai " + nbMamelles + " mamelles";
    }

    @Override
    public String getSon() {
        return null;
    }
}
