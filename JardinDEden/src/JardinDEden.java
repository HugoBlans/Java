import java.util.InputMismatchException;
import java.util.Scanner;

public class JardinDEden {
    private static String menu = "[1] Semer une graine.\n" +
            "[2] Récolter les plantes matures.\n" +
            "[3] Passer à la prochaine saison.\n" +
            "[4] Afficher le jardin.\n" +
            "[5] Brûler le jardin.\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        System.out.println("Hello");
        Jardin jardin = new Jardin(3, 5);
        jardin.ajouterPanier("Tomate", 4);
        jardin.ajouterPanier("Ail", 3);
        jardin.ajouterPanier("Betterave", 7);
        jardin.ajouterPanier("Carotte", 1);


        // Boucle menu-commandes utilisateur
        do {
            // affichage menu
            System.out.println(menu);

            // traitement saisie utilisateur
            try {
                res = scanner.nextInt();
                switch (res) {
                    case 1:
                        jardin.semer();
                        break;
                    case 2:
                        jardin.recolter();
                        break;
                    case 3:
                        jardin.saisonSuivante();
                        break;
                    case 4:
                        System.out.println(jardin.toString());
                        break;
                    case 5:
                        System.out.println("On crame tout !");
                        break;
                    default:
                        System.out.println("Commande inconnue");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur de saisie");
                scanner.nextLine();
            }
        } while (res != 5);
    }
}
