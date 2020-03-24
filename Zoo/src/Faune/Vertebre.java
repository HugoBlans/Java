package Faune;

public abstract class Vertebre extends Animal {
    private int nbVertebres;

    public Vertebre(String nom, int nbVertebres) {
        super(nom);
        this.nbVertebres = nbVertebres;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai " + nbVertebres + " vertèbres";
    }
}
