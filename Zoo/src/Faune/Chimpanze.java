package Faune;

public class Chimpanze extends Mammifere {
    private int nbBananes;

    public Chimpanze(String nom, int nbVertebres, int nbMamelles, int nbBananes) {
        super(nom, nbVertebres, nbMamelles);
        this.nbBananes = nbBananes;
    }


    @Override
    public String toString() {
        return super.toString() + ", j'ai mangé " + nbBananes + " bananes";
    }

    @Override
    public String getSon() {
        return "Hi-Hi-Hi";
    }
}
