package Faune;

public class Reptile extends Vertebre {
    private int nbEcailles;

    public Reptile(String nom, int nbVertebres, int nbEcailles) {
        super(nom, nbVertebres);
        this.nbEcailles = nbEcailles;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai " + nbEcailles + " écailles";
    }

    @Override
    public String getSon() {
        return null;
    }
}
