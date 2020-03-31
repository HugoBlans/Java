package model;

import java.util.Objects;

public class TamagUpdater extends Thread {

    private final int monitorInterval;
    private final int mealDuration;
    private final int digestionDuration;
    private final int sadnessDuration;

    private Tamagochi tamagochi;

    public TamagUpdater(Tamagochi tamagochi) {
        this(tamagochi, 30, 10000, 30000, 60000);
    }

    public TamagUpdater(Tamagochi tamagochi, int monitorInterval, int mealDuration, int digestionDuration, int sadnessDuration) {
        this.monitorInterval = monitorInterval;
        this.mealDuration = mealDuration;
        this.digestionDuration = digestionDuration;
        this.sadnessDuration = sadnessDuration;
        this.tamagochi = tamagochi;
    }

    public void moveTo(Location location) {
        //TODO :)
        tamagochi.setLocation(location);
        update();

    }


    public void update() {

//TODO :)
        if (tamagochi.getLocation() == Location.DINING_ROOM && System.currentTimeMillis() > tamagochi.getLastMeal() + digestionDuration) {
            if (tamagochi.getSatiety() != Satiety.FED) {
                tamagochi.setSatiety(Satiety.FED);
            }

        } else if (Objects.isNull(tamagochi.getLastMeal()) || tamagochi.getLastMeal() + 20000 > System.currentTimeMillis() ) {
            if (tamagochi.getSatiety() != Satiety.HUNGRY) {
                tamagochi.setSatiety(Satiety.HUNGRY);
            }
        }
        if ((tamagochi.getSatiety() == Satiety.FED && tamagochi.getLocation() == Location.DINING_ROOM) || (tamagochi.getSatiety() == Satiety.HUNGRY && tamagochi.getLocation() == Location.PLAYING_ROOM)) {
            if (tamagochi.getEmotion() != Emotion.SAD) {
                tamagochi.setEmotion(Emotion.SAD);
                tamagochi.setSadSince(System.currentTimeMillis());
            }
        } else {
            if (tamagochi.getEmotion() != Emotion.HAPPY) {
                tamagochi.setEmotion(Emotion.HAPPY);
            }
        }
        if (tamagochi.getSadSince() + sadnessDuration > System.currentTimeMillis()) {
            tamagochi.setHealth(Health.DEAD);
        }
    }

    @Override
    public void run() {

        while (tamagochi.getHealth() == Health.ALIVE) {
            try {
                update();
                Thread.sleep(monitorInterval);
            } catch (InterruptedException e) {
            }
        }
    }

}

