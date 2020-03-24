package Exercice1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FicheImpotTest {

    @Test
    void getParts() throws Exception {
        Foyer f = new Foyer(false, 0, 0.0);
        ArrayList<TrancheImpot> map = new ArrayList<TrancheImpot>();
        map.add(new TrancheImpot(0, 10064, 0.0));
        map.add(new TrancheImpot(10064, 25659, 0.11));
        map.add(new TrancheImpot(25659, 73369, 0.30));
        map.add(new TrancheImpot(73369, 157806, 0.41));
        map.add(new TrancheImpot(157806, 0, 0.45));
        FicheImpot fi = new FicheImpot(f, map);

        assertEquals(1, fi.getParts());
        f.setNbEnfant(1);
        assertEquals(1.5, fi.getParts());
        f.setNbEnfant(2);
        assertEquals(2, fi.getParts());
        f.setNbEnfant(3);
        assertEquals(3, fi.getParts());

        f.setCouple(true);
        f.setNbEnfant(0);
        assertEquals(2, fi.getParts());
        f.setNbEnfant(1);
        assertEquals(2.5, fi.getParts());
        f.setNbEnfant(2);
        assertEquals(3, fi.getParts());
        f.setNbEnfant(3);
        assertEquals(4, fi.getParts());
    }

    @Test
    void getRevenuParPart() {
        Foyer f = new Foyer(true, 1, 35000.0);
        ArrayList<TrancheImpot> map = new ArrayList<TrancheImpot>();
        map.add(new TrancheImpot(0, 10064, 0.0));
        map.add(new TrancheImpot(10064, 25659, 0.11));
        map.add(new TrancheImpot(25659, 73369, 0.30));
        map.add(new TrancheImpot(73369, 157806, 0.41));
        map.add(new TrancheImpot(157806, 0, 0.45));
        FicheImpot fi = new FicheImpot(f, map);

        assertEquals(35000.0/2.5, fi.getRevenuParPart());
    }

    @Test
    void getImpotRevenu() {
        Foyer f = new Foyer(true, 1, 35000.0);
        ArrayList<TrancheImpot> map = new ArrayList<TrancheImpot>();
        map.add(new TrancheImpot(0, 10064, 0.0));
        map.add(new TrancheImpot(10064, 25659, 0.11));
        map.add(new TrancheImpot(25659, 73369, 0.30));
        map.add(new TrancheImpot(73369, 157806, 0.41));
        map.add(new TrancheImpot(157806, 0, 0.45));
        FicheImpot fi = new FicheImpot(f, map);

        assertEquals(1082.4, fi.getImpotRevenu());
    }
}