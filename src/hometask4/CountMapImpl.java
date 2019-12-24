package hometask4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountMapImpl<K> implements CountMap<K> {

    private HashMap<K, Integer> hashMap;

    CountMapImpl() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public void add(K key) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, 1);
        } else {
            hashMap.put(key, hashMap.get(key) + 1);
        }
    }

    @Override
    public int getCount(K key) {
        return hashMap.containsKey(key) ? (hashMap.get(key)) : 0;
    }

    @Override
    public int remove(K key) {
        int count = getCount(key);
        hashMap.remove(key);
        return count;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public void addAll(CountMap<? extends K> source) {
        Map<? extends K, ? extends Integer> sourceMap = source.toMap();
        for (Map.Entry<? extends K, ? extends Integer> entry : sourceMap.entrySet()) {
            Integer sourceCount = (entry.getValue());
            if (this.hashMap.containsKey(entry.getKey())) {
                this.hashMap.put(entry.getKey(), sourceCount + getCount(entry.getKey()));
            } else {
                this.hashMap.put(entry.getKey(), sourceCount);
            }
        }
    }

    @Override
    public  Map<K, Integer>  toMap() {
        HashMap<K, Integer> countMap = new HashMap<>();
        toMap(countMap);
        return countMap;
    }

    @Override
    public void toMap(Map<? super K, ? super Integer> destination) {
        for (K key : hashMap.keySet()) {
            destination.put(key, hashMap.get(key));
        }
    }

}
