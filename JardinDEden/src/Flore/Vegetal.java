package Flore;


public abstract class Vegetal {
    private Etat etat;
    protected char[] dessin;

    public Vegetal() {
        this.etat = Etat.GRAINE;
        dessin = new char[]{'_', '.', 'i', ' ', ' ', '#'};
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        char dessEtat = 'o';
        switch (this.etat) {
            case GRAINE:
                dessEtat = dessin[0];
                break;
            case GERME:
                dessEtat = dessin[1];
                break;
            case TIGE:
                dessEtat = dessin[2];
                break;
            case FEUILLE:
                dessEtat = dessin[3];
                break;
            case FLEUR:
                dessEtat = dessin[4];
                break;
            case MORT:
                dessEtat = dessin[5];
                break;
        }
        return "" + dessEtat;
    }

    public void grandir() {
        if (this.etat != Etat.MORT) this.etat = Etat.values()[this.etat.ordinal() + 1];
    }
}
