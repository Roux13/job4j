package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("KopitovIvan@mail.com", "Ivan Kopitov");
        map.put("RogovBoris@mail.com", "Boris Rogov");
        map.put("OrlovOleg@mail.com", "Oleg Orlov");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

}
