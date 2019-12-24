package hometask3;

class HashSlot<K, V> {
    K key;
    V value;
    boolean isDeleted;

    // Constructor
    public HashSlot(K key, V value) {
        this.isDeleted = false;
        this.key = key;
        this.value = value;
    }

    public void delete() {
        this.key = null;
        this.value = null;
        this.isDeleted = true;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
