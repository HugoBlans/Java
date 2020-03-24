package Flore;

import java.util.Random;

public class Betterave extends Vegetal implements IOgm {
    public Betterave() {
        super();
        this.dessin[3] = 'b';
        this.dessin[4] = 'B';
    }

    @Override
    public Coordonnee seDupliquer(int ligne, int colonne) {
        Coordonnee coord = new Coordonnee();
        Random rn = new Random();
        coord.setCoordX(rn.nextInt(ligne));
        coord.setCoordY(rn.nextInt(colonne));
        return coord;
    }
}
