package hometask5;

import java.util.Map;

public class Person {
    private final String name;
    private final String lastName;
    private final Map<String, String> addresses;
    private final String[] phoneNumbers;

    public Person(String name, String lastName, Map<String, String> addresses, String[] phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }
}
