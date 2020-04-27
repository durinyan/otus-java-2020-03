package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Generics {
    public static void main(String... args) {
        List<String> stringList = new ArrayList<>();

        for (int i = 30; i > 0; i--) {
            stringList.add(String.format("Position %s", i));
        }

        MyArrayList<String> myArray = new MyArrayList<>(stringList.size());
        Collections.copy(myArray, stringList);

        Collections.addAll(myArray, "addAll1", "addAll2", "addAll3");

        Collections.sort(myArray, Comparator.naturalOrder());

        for (int i = 0; i < myArray.size(); i++){
            System.out.println(myArray.get(i));
        }
    }

}
