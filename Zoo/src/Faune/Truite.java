package Faune;

public class Truite extends Poisson {
    private int nbHameconsEvites;

    public Truite(String nom, int nbVertebres, int nbNageoires, int nbHameconsEvites) {
        super(nom, nbVertebres, nbNageoires);
        this.nbHameconsEvites = nbHameconsEvites;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai évité " + nbHameconsEvites + " hameçons";
    }
}
