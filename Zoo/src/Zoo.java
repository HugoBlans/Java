import Faune.Animal;

import java.util.ArrayList;

public class Zoo {
    private String nom;
    private ArrayList<Animal> Animaux;

    public Zoo(String nom) {
        this.nom = nom;
        this.Animaux = new ArrayList<Animal>();
    }

    public void ajouterAnimal(Animal animal) {
        Animaux.add(animal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Le Zoo " + this.nom + " contient :\n");
        for (Animal a : Animaux
        ) {
            sb.append(a.getNom() + "\n");
        }
        return sb.toString();
    }
}
