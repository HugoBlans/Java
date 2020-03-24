package Faune;

public class Poisson extends Vertebre {
    private int nbNageoires;

    public Poisson(String nom, int nbVertebres, int nbNageoires) {
        super(nom, nbVertebres);
        this.nbNageoires = nbNageoires;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai " + nbNageoires + " nageoires";
    }

    @Override
    public String getSon() {
        return null;
    }
}
