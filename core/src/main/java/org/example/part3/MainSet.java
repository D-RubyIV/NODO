package org.example.part3;

import java.util.*;

public class MainSet {
    // Set
    // các phần tử đều là duy nhất
    // Cho phép chứa tối đa 1 null

    // Có 3 loại Set
    // HashSet: Lưu trữ phần tử trong bảng bâm, các phần từ duy nhất, ko thứ tự => Truy xuất nhanh, Chèn chậm
    // LinkedHashSet: Lưu trữ phần tử trong bảng băm, các phần tử duy nhất, theo thứ tự chèn => Chèn nhanh, Truy xuất chậm
    // TreeSet: Lưu trữ phần tử dạng tree, các phần tử duy nhất theo thứ tự tăng dần
    public static void main(String[] args) {
        // HashSet
        System.out.println("HASH SET Tự động sắp xếp: Không đảm bảo thứ tự chèn");
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(null);
        hashSet.add(null);
        hashSet.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println("\n");



        // LinkedHashSet
        System.out.println("LINKED HASH SET Tự động sắp theo thứ tự chèn");
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(5);
        linkedHashSet.add(null);
        linkedHashSet.add(null);
        linkedHashSet.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println("\n");

        // TreeSet
        // Không cho chứa null
        System.out.println("TREE SET Tự động sắp xếp theo thứ tự tăng dần");
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(-1);
        try {
            treeSet.add(null);
            treeSet.add(null);
        }
        catch (NullPointerException ex){
            System.out.println("TREE SET không cho chứa null");
        }
        treeSet.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println("\n");

    }
}
