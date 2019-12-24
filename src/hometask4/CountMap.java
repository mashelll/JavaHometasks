package hometask4;

import java.util.Map;

public interface CountMap<K> {

    //добавляет элемент в этот контейнер.
    void add(K key);

    //Возвращает количество добавлений данного элемента
    int getCount(K key);

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    int remove(K key);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    void addAll(CountMap<? extends K> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map<? extends K, ? extends Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<? super K, ? super Integer> destination);
}
