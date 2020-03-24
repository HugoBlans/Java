package Exercice2;

public class Distributeur {
    private Double[] pieces;

    public Distributeur() {
        this.pieces = new Double[]{2.0, 1.0, 0.5, 0.2, 0.1};
    }

    public void rendreMonnaie(Double monnaie) {
        System.out.println("Pour " + monnaie + "€ les pièces à rendre sont :");
        for (Double piece:this.pieces
             ) {
            System.out.println(monnaie%piece);
        }
    }
}
