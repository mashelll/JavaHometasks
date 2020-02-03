package hometask5;

import hometask5.format.Format;
import hometask5.format.JSONFormat;
import hometask5.format.XMLFormat;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<String, String> addresses = new HashMap<>();
        addresses.put("city", "Moscow");
        addresses.put("postalCode", "12345");

        String[] phoneNumbers = new String[2];
        phoneNumbers[0] = "123-566-789";
        phoneNumbers[1] = "678-344-234";

        String[] phoneNumbers2 = new String[1];
        phoneNumbers2[0] = "123-566-789";

        Person person = new Person("Иван", "Иванов", addresses, phoneNumbers);
        Format format1 = new JSONFormat();
        SerializerImpl serializer1 = new SerializerImpl(format1);
        System.out.println(serializer1.serialize(person));

        Format format2 = new XMLFormat();
        SerializerImpl serializer2 = new SerializerImpl(format2);
        System.out.println(serializer2.serialize(person));
    }


}
