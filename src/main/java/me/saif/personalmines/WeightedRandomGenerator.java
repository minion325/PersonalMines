package me.saif.personalmines;

import java.util.*;

public class WeightedRandomGenerator<T> {

    private final Map<T, Integer> rarityMap = new HashMap<>();
    private final Map<T, Integer> cumulative = new LinkedHashMap<>();
    private int total = 0;
    private final Random random = new Random();

    public void addItem(T t, int rarity) {
            System.out.println(t.toString());
            System.out.println(rarity);
        if (rarity <= 0) return;
        
        int current = 0;
        if (this.rarityMap.containsKey(t))
            current = this.rarityMap.remove(t);
        this.rarityMap.put(t, rarity + current);
        regenCumulativeMap();
    }

    private void regenCumulativeMap() {
        this.total = 0;
        this.cumulative.clear();
        for (T t : rarityMap.keySet()) {
            this.total = this.total + this.rarityMap.get(t);
            this.cumulative.put(t, total);
        }
    }

    public void removeObject(T t) {
        this.rarityMap.remove(t);
    }

    public Set<T> getObjectPool() {
        return rarityMap.keySet();
    }

    public int getRarity(T t) {
        return this.rarityMap.getOrDefault(t, 0);
    }

    public T generateRandom() {
        if (rarityMap.size() == 0)
            return null;
        int rand = this.random.nextInt(this.total) + 1;
        for (T t : this.cumulative.keySet()) {
            if (rand <= this.cumulative.get(t))
                return t;
        }
        //we shouldnt reach here
        return null;
    }

}
