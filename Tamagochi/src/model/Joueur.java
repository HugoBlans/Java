package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Joueur {
    private String name;
    private Map<String,Tamagochi> tamagochiList = new HashMap<>();
    private Map<Integer, TamagUpdater> tamagUpdaters = new HashMap<>();

    public Joueur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Tamagochi> getTamagochiList() {
        return tamagochiList;
    }

    public void setTamagochiList(Map<String, Tamagochi> tamagochiList) {
        this.tamagochiList = tamagochiList;
    }

    public Map<Integer, TamagUpdater> getTamagUpdaters() {
        return tamagUpdaters;
    }

    public void setTamagUpdaters(Map<Integer, TamagUpdater> tamagUpdaters) {
        this.tamagUpdaters = tamagUpdaters;
    }

    public void addTamag(String name) {
        Tamagochi t = new Tamagochi();
        TamagUpdater tu = new TamagUpdater(t);
        tamagochiList.put(name,t);
        tamagUpdaters.put(t.getId(), tu);
    }
}
