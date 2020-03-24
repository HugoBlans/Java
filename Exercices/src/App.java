import Exercice1.FicheImpot;
import Exercice1.Foyer;
import Exercice1.TrancheImpot;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Foyer f = new Foyer(true, 1, 35000.0);
        ArrayList<TrancheImpot> map = new ArrayList<TrancheImpot>();
        map.add(new TrancheImpot(0, 10064, 0.0));
        map.add(new TrancheImpot(10064, 25659, 0.11));
        map.add(new TrancheImpot(25659, 73369, 0.30));
        map.add(new TrancheImpot(73369, 157806, 0.41));
        map.add(new TrancheImpot(157806, 0, 0.45));
        FicheImpot fi = new FicheImpot(f, map);
        System.out.println(fi.toString());
    }
}
