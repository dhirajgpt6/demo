package com.example.demo.other;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//Usecase: Creating an Immutable Map in Java
 
public class ImmutableMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println("Unmodifiable Map: " + unmodifiableMap);
        // Attempting to modify the map will throw UnsupportedOperationException
//         unmodifiableMap.put(5, "Five"); // Uncommenting this line will cause an exception

//        From java 9 onwards, you can use Map.of() to create an immutable map directly
        Map<Integer, String> immutableMap = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");
        System.out.println("Immutable Map: " + immutableMap);
//        immutableMap.put(5, "Five"); // This will throw UnsupportedOperationException
    }
}
