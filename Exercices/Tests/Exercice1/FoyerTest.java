package Exercice1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoyerTest {

    @Test
    void isCoupleTrue() {
        Foyer f = new Foyer(true, 50, 0.0);
        assertEquals(true, f.isCouple());
    }

    @Test
    void isCoupleFalse() {
        Foyer f = new Foyer(false, 50, 0.0);
        assertEquals(false, f.isCouple());
    }
    @Test
    void setNbEnfant() {
        Foyer f = new Foyer(false, 0, 0.0);

        try {
            f.setNbEnfant(-20);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
//
//    @Test
//    void getRevenuAnnuel() {
//    }
//
//    @Test
//    void setRevenuAnnuel() {
//    }
}