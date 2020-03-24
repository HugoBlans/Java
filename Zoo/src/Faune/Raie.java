package Faune;

public class Raie extends Poisson {
    private int surface;

    public Raie(String nom, int nbVertebres, int nbNageoires, int surface) {
        super(nom, nbVertebres, nbNageoires);
        this.surface = surface;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai une surface de " + surface + " cm²";
    }
}
