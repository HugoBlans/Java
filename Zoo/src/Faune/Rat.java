package Faune;

public class Rat extends Mammifere {
    private int nbPoubellesVisitées;

    public Rat(String nom, int nbVertebres, int nbMamelles, int nbPoubellesVisitées) {
        super(nom, nbVertebres, nbMamelles);
        this.nbPoubellesVisitées = nbPoubellesVisitées;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai visité " + nbPoubellesVisitées + " poubelless";
    }
}
