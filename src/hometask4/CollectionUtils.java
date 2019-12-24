package hometask4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? super T> source, T element) {
        int index = 0;
        for (Object obj : source) {
            if (obj.equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static <T> List<T> limit(List<T> source, int size) {
        int i = 0;
        List<T> newArray = CollectionUtils.newArrayList();
        for (T element : source) {
            if (i >= size)
                break;
            newArray.add(element);
            i++;
        }
        return newArray;
    }

    public static <T> void add(List<? super T> source, T element) {
        source.add(element);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T element : c2) {
            removeFrom.remove(element);
        }
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        for (T element : c2) {
            if (!c1.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T element : c2) {
            if (c1.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public static <L, T extends Comparable<? super L>> List<L> range(List<L> list, T min, T max) {
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (min.compareTo(element) <= 0 && max.compareTo(element) >= 0) {
                newArray.add(element);
            }
        }
        return newArray;
    }

    public static <L, T extends L> List<L> range(List<L> list, T min, T max, Comparator<? super L> comparator) {
        List<L> newArray = CollectionUtils.newArrayList();
        for (L element : list) {
            if (comparator.compare(min, element) <= 0 && comparator.compare(max, element) >= 0) {
                newArray.add(element);
            }
        }
        return newArray;
    }
}
