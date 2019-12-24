package hometask5;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
