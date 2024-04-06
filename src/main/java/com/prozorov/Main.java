package com.prozorov;


public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> alphabet1 = new MyLinkedList<>();
        alphabet1.add(33);
        alphabet1.add(22);
        alphabet1.add(11);
        System.out.println(alphabet1);
        alphabet1.sort();
        System.out.println(alphabet1);

//        MyArrayList<String> myList1 = new MyArrayList<>();
//        myList1.add("Ivan");//0
//        myList1.add("Nikita");//1
//        myList1.add("Ekaterina");//2
//        myList1.add("Ignat");//3
//        myList1.add("Vitaliy");//4
//        myList1.add("Zoya");//5
//        myList1.add("Anton");//6
//        myList1.add("Kirill");//7
//        myList1.add("Olga");//8
//        myList1.add("Anna");//9
//        myList1.add("Nikolay");//10
//        myList1.remove(0);
//
//        MyArrayList<String> myList2 = new MyArrayList<>();
//        myList2.add("Matthew");
//        myList2.add("Sarah");
//        myList2.add("Jake");
//        myList1.addAll(myList2);
//        myList1.sort();
//        System.out.println(myList1);
//        System.out.println(myList1.size());
//
//        MyArrayList<Integer> myList3 = new MyArrayList<>();
//        myList3.add(23);
//        myList3.add(5);
//        myList3.add(1);
//        myList3.add(-8);
//        myList3.add(0);
//        System.out.println(myList3);
//        myList3.sort();
//        System.out.println(myList3);
//        myList3.add(3, 185);
//        System.out.println(myList3);
//        myList3.sort();
//        System.out.println(myList3);
    }
}