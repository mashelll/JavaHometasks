package hometask5;

public class Main {
    public static void main(String[] args) {
        Person personTimer = TimeProxy.timer(new Person("Alex"));
        personTimer.sleep();
    }
}
