import static org.junit.jupiter.api.Assertions.*;

import model.Emotion;
import model.Location;
import model.TamagUpdater;
import model.Tamagochi;
import org.junit.jupiter.api.Test;

class TamagochiTest {

    @Test
    void testSetLocation() {
        Tamagochi tamagochi = new Tamagochi();
        TamagUpdater updater = new TamagUpdater(tamagochi,50,1000,3000,5000);
        updater.start();

        assertEquals(tamagochi.getLocation(), Location.PLAYING_ROOM);
        assertEquals(tamagochi.getEmotion(), Emotion.SAD);
        updater.moveTo(Location.DINING_ROOM);
        assertEquals(tamagochi.getLocation(), Location.DINING_ROOM);
        assertEquals(tamagochi.getEmotion(), Emotion.SAD);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        assertEquals(tamagochi.getLocation(), Location.DINING_ROOM);
        assertEquals(tamagochi.getEmotion(), Emotion.SAD);
    }
}
