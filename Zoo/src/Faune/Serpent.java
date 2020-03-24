package Faune;

public class Serpent extends Reptile {
    private int nbSourisDevorees;

    public Serpent(String nom, int nbVertebres, int nbEcailles, int nbSourisDevorees) {
        super(nom, nbVertebres, nbEcailles);
        this.nbSourisDevorees = nbSourisDevorees;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai mangé" + nbSourisDevorees + " souris";
    }
}
