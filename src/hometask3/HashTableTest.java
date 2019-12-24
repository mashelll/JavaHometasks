package hometask3;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HashTableTest {
    HashTable<String, Integer> hashTable = new HashTable<>();;

    @Test
    public void emptySize() {
        Assert.assertEquals(0, hashTable.size());
    }

    @Test
    public void isEmptyTesting() {
        Assert.assertEquals(true, hashTable.isEmpty());
    }

    @Test
    public void keyCollision() {
        hashTable.put("this", 1);
        hashTable.put("coder", 2);
        hashTable.put("this", 4);
        hashTable.put("hi", 5);
        Assert.assertEquals(3, hashTable.size());
    }

    @Test
    public void removeExisting() {
        hashTable.put("this", 1);
        hashTable.put("coder", 2);
        hashTable.put("this", 4);
        hashTable.put("hi", 5);
        hashTable.put("a", 4);
        hashTable.put("c", 4);
        hashTable.put("d", 4);
        hashTable.put("e", 4);
        hashTable.put("f", 4);
        hashTable.put("h", 4);
        hashTable.put("i", 4);
        hashTable.put("j", 4);
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("this", 7);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        hashTable.remove("this");
        Assert.assertEquals(14, hashTable.size());
    }

    @Test
    public void removeNotExisting() {
        hashTable.put("hi", 5);
        hashTable.remove("this");
        Assert.assertEquals(1, hashTable.size());
    }


    @Test
    public void initialArrayOverflow() {
        hashTable.put("this", 4);
        hashTable.put("a", 4);
        hashTable.put("c", 4);
        hashTable.put("d", 4);
        hashTable.put("e", 4);
        hashTable.put("f", 4);
        hashTable.put("h", 4);
        hashTable.put("i", 4);
        hashTable.put("j", 4);
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        Assert.assertEquals(13, hashTable.size());
    }


    @Test
    public void getExistingTest() {
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        Assert.assertEquals((Integer) 4, hashTable.get("m"));
    }

    @Test
    public void getNotExistingTest() {
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        Assert.assertEquals(null, hashTable.get("7"));
    }


    @Test
    public void containsExistingTest() {
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        Assert.assertEquals(true, hashTable.contains("m"));
    }

    @Test
    public void containsNotExistingTest() {
        hashTable.put("k", 4);
        hashTable.put("l", 4);
        hashTable.put("m", 4);
        hashTable.put("n", 4);
        Assert.assertEquals(false, hashTable.contains("7"));

    }
}