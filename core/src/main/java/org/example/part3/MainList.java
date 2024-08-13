package org.example.part3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainList {
    // LIST
    // Có thể chứa phần tử trùng lặp
    // Cho phép chừa nhiều null
    public static void main(String[] args) {

        // ARRAYLIST
        // Sủ dụng khi cần truy xuất nhanh, không qua tâm hiệu xuất thêm và xóa
        // Thứ tự theo thứ tự chèn
        // Mảng động, tự động tăng giảm kích thước phần tử
        //
        System.out.println("ARRAY LIST");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);

        // Dùng với iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // Dùng for
        list.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println();

        // LINKED LIST
        // Mảng liên kết, mỗi phần tử là 1 node, mỗi node sẽ liên kết với node trước và sau nó
        // Sử dụng khi cần hiệu xuất thêm, xóa tốt, không quan tâm tới tốc độ truy cập phần tử
        // Không thể truy xuất ngẫu nhiên

        System.out.println("LINKED LIST");
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        list.add(null);
        // Dùng for
        list.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println();
    }
}
