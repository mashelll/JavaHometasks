package hometask3;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HashMapTest {
    HashMap<String, Integer> hashMap = new HashMap<>();;

    @Test
    public void emptySize() {
        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void isEmptyTesting() {
        Assert.assertEquals(true, hashMap.isEmpty());
    }

    @Test
    public void keyCollision() {
        hashMap.put("this", 1);
        hashMap.put("coder", 2);
        hashMap.put("this", 4);
        hashMap.put("hi", 5);
        Assert.assertEquals(3, hashMap.size());
    }

    @Test
    public void removeExisting() {
        hashMap.put("this", 1);
        hashMap.put("coder", 2);
        hashMap.put("this", 4);
        hashMap.put("hi", 5);
        hashMap.put("a", 4);
        hashMap.put("c", 4);
        hashMap.put("d", 4);
        hashMap.put("e", 4);
        hashMap.put("f", 4);
        hashMap.put("h", 4);
        hashMap.put("i", 4);
        hashMap.put("j", 4);
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("this", 7);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        hashMap.remove("this");
        Assert.assertEquals(14, hashMap.size());
    }

    @Test
    public void removeNotExisting() {
        hashMap.put("hi", 5);
        hashMap.remove("this");
        Assert.assertEquals(1, hashMap.size());
    }


    @Test
    public void initialArrayOverflow() {
        hashMap.put("this", 4);
        hashMap.put("a", 4);
        hashMap.put("c", 4);
        hashMap.put("d", 4);
        hashMap.put("e", 4);
        hashMap.put("f", 4);
        hashMap.put("h", 4);
        hashMap.put("i", 4);
        hashMap.put("j", 4);
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        Assert.assertEquals(13, hashMap.size());
    }


    @Test
    public void getExistingTest() {
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        Assert.assertEquals((Integer) 4, hashMap.get("m"));
    }

    @Test
    public void getNotExistingTest() {
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        Assert.assertEquals(null, hashMap.get("7"));
    }


    @Test
    public void containsExistingTest() {
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        Assert.assertEquals(true, hashMap.contains("m"));
    }

    @Test
    public void containsNotExistingTest() {
        hashMap.put("k", 4);
        hashMap.put("l", 4);
        hashMap.put("m", 4);
        hashMap.put("n", 4);
        Assert.assertEquals(false, hashMap.contains("7"));

    }
}