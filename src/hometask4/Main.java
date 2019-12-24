package hometask4;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CountMap<Integer> countMap = new CountMapImpl<>();

        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(10);

        System.out.println(countMap.getCount(5));
        System.out.println(countMap.getCount(6));
        System.out.println(countMap.getCount(10));

        CountMap<Integer> countMap2 = new CountMapImpl<>();

        countMap2.add(10);
        countMap2.add(10);
        countMap2.add(5);
        countMap2.add(6);
        countMap2.add(5);
        countMap2.add(10);

        countMap.addAll(countMap2);
        System.out.println(" ");
        System.out.println(countMap.getCount(5));
        System.out.println(countMap.getCount(6));
        System.out.println(countMap.getCount(10));

        Map<Integer, Integer> map = (Map<Integer, Integer>) countMap.toMap();
        System.out.println(map);
    }
}