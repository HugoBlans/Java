package model;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class Tamagochi implements Serializable {

    private int id;

    private Health health = Health.ALIVE;
    private Emotion emotion = Emotion.HAPPY;
    private Location location = Location.PLAYING_ROOM;
    private Satiety satiety = Satiety.HUNGRY;

    private long lastMeal = -1;
    private long sadSince = -1;

    public Tamagochi() {
        id = new Random().nextInt(10000);
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {

        this.health = health;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {

        this.emotion = emotion;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Satiety getSatiety() {
        return satiety;
    }

    public void setSatiety(Satiety satiety) {
        this.satiety = satiety;
    }

    public long getLastMeal() {
        return lastMeal;
    }

    public long getSadSince() {
        return sadSince;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastMeal(long lastMeal) {
        this.lastMeal = lastMeal;
    }

    public void setSadSince(long sadSince) {
        this.sadSince = sadSince;
    }

    @Override
    public String toString() {
        return "[Tamag " + id + ":" + health + "," + emotion + "," + location + "," + satiety + "," + lastMeal + ","
                + sadSince + "]";
    }

    public String toStringState() {
        return health + "," + emotion + "," + location + "," + satiety;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emotion == null) ? 0 : emotion.hashCode());
        result = prime * result + ((health == null) ? 0 : health.hashCode());
        result = prime * result + id;
        result = prime * result + (int) (lastMeal ^ (lastMeal >>> 32));
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + (int) (sadSince ^ (sadSince >>> 32));
        result = prime * result + ((satiety == null) ? 0 : satiety.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tamagochi other = (Tamagochi) obj;
        if (emotion != other.emotion)
            return false;
        if (health != other.health)
            return false;
        if (id != other.id)
            return false;
        if (lastMeal != other.lastMeal)
            return false;
        if (location != other.location)
            return false;
        if (sadSince != other.sadSince)
            return false;
        if (satiety != other.satiety)
            return false;
        return true;
    }

/*
	public String compareState(Tamagochi previous) {
		String states = "";


		if(previous.getLocation() != getLocation()) {
			states += "in the " + getLocation().toString()+", ";
		}
		if(previous.getHealth() != getHealth()) {
			states += getHealth().toString() + ", ";
		}
		if(previous.getSatiety() != getSatiety()) {
			states += getSatiety().toString() + ", ";
		}
		if(previous.getEmotion() != getEmotion()) {
			states += getEmotion().toString();
		}
		return states;
	}
*/
}
