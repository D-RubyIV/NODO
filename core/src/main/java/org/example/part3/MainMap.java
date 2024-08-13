package org.example.part3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainMap {
    // Map
    // Dùng chứa cặp key và value
    // Không cho phép lặp khóa

    // Có 3 loại Map
    // HashMap: Không duy trì thứ tự, key có thể null,
    // LinkedHashMap: Duy trì thứ tự chèn,key có thể null,
    // TreeMap: Sắp thứ tự theo key tăng dần, key không được null
    public static void main(String[] args) {

        // HASH MAP
        System.out.println("HASH MAP - Không thứ tự, có key null");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Orange");
        hashMap.put(null, "WaterMelon");
        for (int i = 0; i < 100000; i++) {
            hashMap.put(i + 20, "WaterMelon" + 1);
        }
//        for (Integer integer : hashMap.keySet()) {
//            System.out.println(integer + " " + hashMap.get(integer));
//        }
        System.out.println(hashMap);
//
//        //LINKED HASH MAP
//        System.out.println("LINKED HASH MAP - Thứ tự chèn, có key null");
//        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put(1, "Apple");
//        linkedHashMap.put(3, "Orange");
//        linkedHashMap.put(2, "Banana");
//        linkedHashMap.put(null, "WaterMelon");
//        linkedHashMap.keySet().forEach(s -> {
//            System.out.println(s + " " + linkedHashMap.get(s));
//        });
//        System.out.println();
//
//        //TREE MAP
//        System.out.println("TREE MAP - Thứ tự tâng dần, không chứa key null");
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Apple");
        treeMap.put(3, "Orange");
        treeMap.put(2, "Banana");


//

    }
}
