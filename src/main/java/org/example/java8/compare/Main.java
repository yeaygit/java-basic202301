package org.example.java8.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    List<Integer> nums=List.of(9,4,3,6,5,4,1);
    List<String> strs=List.of("apple","banana","홍길동");
    
    
    public static void main(String[] args) {
        List<Person> pList= new ArrayList<>(List.of(//list.of는 불변리스트
                new Person("김철수",33),
                new Person("홍길동",16),
                new Person("박영희",44),
                new Person("김희수",22)
        ));

        pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();//오름차순
                // return o1.compareTo(o2);
            }
        });

        System.out.println("pList = " + pList);

        /*
        pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
         */
        pList.sort((o1,o2)->o1.getAge()-o2.getAge()); //pList.sort(comparing(Person::getName));
        System.out.println("pList = " + pList);
    }
}
