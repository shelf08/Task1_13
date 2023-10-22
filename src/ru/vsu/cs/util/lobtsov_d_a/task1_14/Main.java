package ru.vsu.cs.util.lobtsov_d_a.task1_14;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите список:");
            System.out.println("1 - Двусвязный");
            System.out.println("2 - Циклический");

            int k = scanner.nextInt();
            if(k == 1){
                list = new DoubleLinkedList<>();
                break;
            } else if(k == 2) {
                list = new CycleLinkedList<>();
                break;
            }
        }

        // init
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println();


        // size
        System.out.println("list.size() = " + list.size());
        System.out.println();

        // get
        System.out.println("Элемент по индексу 0 = " +  list.get(0));
        System.out.println();
        System.out.println("Элемент по индексу 5 = " +  list.get(5));
        System.out.println();
        System.out.println("Элемент по индексу 19 = " +  list.get(19));
        System.out.println();
        System.out.println("Элемент по индексу 21 = ");
        try {
            System.out.print(  list.get(21));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("list.get(-5) = ");
        try {
            System.out.print(  list.get(-5));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println();

        // set
        System.out.println("Вставка 111 на место элемента с индексом 0");
        System.out.println("list.set(0, 111) = " +  list.set(0, 111));
        System.out.println("list.get(0) = " +  list.get(0));
        System.out.println();

        System.out.println("Вставка 222 на место элемента с индексом 19");
        System.out.println("list.set(19, 222) = " +  list.set(19, 222));
        System.out.println("list.get(19) = " +  list.get(19));
        System.out.println();

        System.out.println("Вставка 333 на место элемента с индексом 10");
        System.out.println("list.set(10, 333) = " +  list.set(10, 333));
        System.out.println("list.get(10) = " +  list.get(10));
        System.out.println();
        System.out.println();

        // remove
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удаление элемента с индексом = " +  list.remove(19));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удаление элемента с индексом = " +  list.remove(11));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();

        // add i
        System.out.println(Arrays.toString(list.toArray()));
        list.add(0, 52);
        System.out.println("Добавление элемента 52 в начало");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();
        System.out.println();


        // size
        System.out.println("Размер списка");
        System.out.println("list.size() = " + list.size());
        System.out.println();

        // clear
        System.out.println("Отчистили");
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();

        // size
        System.out.println("Размер списка после удаления");
        System.out.println("list.size() = " + list.size());
        System.out.println();
    }

}
