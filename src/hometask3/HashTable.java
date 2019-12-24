package hometask3;

import static java.lang.Math.abs;

class HashTable<K, V> {

    private HashSlot<K, V>[] hashSlotArray;
    public int capacity;

    public HashTable() {
        this.capacity = 10;
        this.hashSlotArray = (HashSlot<K, V>[]) new HashSlot[capacity];
    }

    public int size() {
        int counter = 0;
        for (int i = 0; i < hashSlotArray.length; i++) {
            if ((hashSlotArray[i] != null) && (!hashSlotArray[i].isDeleted)) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    //hash function
    private int getSlotIndex(K key) {
        int hashCode = key.hashCode();
        return abs(hashCode % capacity - 1);
    }

    private void resize() {
        int oldCapacity = this.capacity;

        HashSlot<K, V>[] newHashSlotArray = new HashSlot[oldCapacity];

        for (int i = 0; i < newHashSlotArray.length; i++) {
            newHashSlotArray[i] = hashSlotArray[i];
        }
        this.capacity = this.capacity + 10;
        this.hashSlotArray = (HashSlot<K, V>[]) new HashSlot[this.capacity];
        for (int i = 0; i < newHashSlotArray.length; i++) {
            if (newHashSlotArray[i] != null) {
                if (!newHashSlotArray[i].isDeleted) {
                    this.put(newHashSlotArray[i].key, newHashSlotArray[i].value);
                }
            }
        }
    }


    public void put(K key, V value) {

        int slotIndex = getSlotIndex(key);

        if (size() == capacity) {
            resize();
            put(key, value);
        }

        //если ячейка с данным хэшем занята(осуществляем линейную пробацию, чтобы найти свободную ячейку)
        while ((hashSlotArray[slotIndex] != null) && (slotIndex < capacity)) {

            //если она занята, но помечена удаленной
            if (hashSlotArray[slotIndex].isDeleted){
                hashSlotArray[slotIndex].setKey(key);
                hashSlotArray[slotIndex].setValue(value);
                hashSlotArray[slotIndex].isDeleted = false;
                break;
            }

            //если данный ключ уже существует, переписываем его значение
            if (hashSlotArray[slotIndex].getKey() == key) {
                hashSlotArray[slotIndex].setValue(value);
                return;
            }
            slotIndex++;
        }

        if (size() == capacity) {
            resize();
            put(key, value);
        }

        //если ячейка с данным хэшем изначально пустая или нашли пустую ячейку, записываем в нее значение
        if (hashSlotArray[slotIndex] == null) {
            hashSlotArray[slotIndex] = new HashSlot<>(key, value);
            return;
        }
    }

    public V get(K searchedKey) {

        int slotIndex = getSlotIndex(searchedKey);

        //если ячейка с данным хэшем пустая возвращаем нул
        if (hashSlotArray[slotIndex] == null) {
            return null;
        }

        //проверяем теперь оставшийся массив на наличие ячеек с таким кэшем
        for (int i = 0; i < hashSlotArray.length; i++) {

            //если по дороге встретилась пустая ячейка значит больше нет нужных ячеек
            if (hashSlotArray[slotIndex] == null) {
                return null;
            }

            //встретив ячейку с нужным кэшем и ключем - выходим
            if ((hashSlotArray[slotIndex].getKey() == searchedKey) && (!hashSlotArray[slotIndex].isDeleted)) {
                return hashSlotArray[slotIndex].getValue();
            }
        }
        return null;
    }


    public void remove(K searchedKey) {

        //если и так нет,то выходим
        if (!contains(searchedKey)) {
            return;
        }

        int slotIndex = getSlotIndex(searchedKey);

        //ищем ячейку с нужным ключем
        while (hashSlotArray[slotIndex].key != searchedKey) {
            slotIndex++;
        }

        //если нашли ячейку с данным кэшем и ключем зануляем ее поля и ставим флаг делитед
        if (hashSlotArray[slotIndex].key == searchedKey) {
            hashSlotArray[slotIndex].delete();
            return;
        }
    }

    public boolean contains(K searchedKey) {
        return get(searchedKey) != null;
    }
}