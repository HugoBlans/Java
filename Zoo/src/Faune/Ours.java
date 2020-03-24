package Faune;

public class Ours extends Mammifere {
    private int litresMiel;

    public Ours(String nom, int nbVertebres, int nbMamelles, int litresMiel) {
        super(nom, nbVertebres, nbMamelles);
        this.litresMiel = litresMiel;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai bu " + litresMiel + " litres de miel";
    }
}
