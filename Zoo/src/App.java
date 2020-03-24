import Faune.Chimpanze;
import Faune.Requin;

public class App {
    public static void main(String[] args) {
        Requin jaws, ham;
        Chimpanze cheeta = new Chimpanze("Cheeta", 12, 2, 3);
        jaws = new Requin("Jaws", 18,4,3);
        ham = new Requin("Ham", 15,5,0);

        System.out.println(jaws.toString());
        System.out.println(ham.toString());
        System.out.println(cheeta.toString());

        Zoo zoo = new Zoo("Asson");
        zoo.ajouterAnimal(jaws);
        zoo.ajouterAnimal(ham);
        zoo.ajouterAnimal(cheeta);

        System.out.println(zoo.toString());
    }
}
