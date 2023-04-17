package org.example;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;

import static org.example.Gender.female;
import static org.example.Gender.male;

public class Main {
    static Random rand = new Random();
     static int[] arr1 = new int[10];

     static AtomicIntegerArray arr2 = new AtomicIntegerArray(10);

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++){
            new Thread((Main::arr1)).start();
            new Thread((Main::arr2)).start();
        }


        //STREAM
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("121", "Danny", "Tel-aviv" , Gender.male, 5));
        customers.add(new Customer("2325", "Ron", "Bney-Brak" , Gender.male, 3));
        customers.add(new Customer("4545", "Daniel", "Ramat-Gan" , Gender.male, 8));
        customers.add(new Customer("5656", "Dvora", "Haifa" , Gender.female, 5));
        customers.add(new Customer("73585", "Rivka", "Yahud" , Gender.female, 10));
        customers.add(new Customer("56", "Smuel", "Kfar-Saba" , Gender.male, 5));
        customers.add(new Customer("52", "Dina", "Tel-aviv" , Gender.female, 15));
        customers.add(new Customer("902", "Chagit", "Petah-Tiqwa" , Gender.female, 4));
        customers.add(new Customer("456", "Shlomit", "Tel-aviv" , Gender.female, 3));
        customers.add(new Customer("831", "Motty", "Tel-aviv" , Gender.male, 7));
        customers.add(new Customer("12", "Yehudit", "Bney-Brak" , Gender.female, 6));
        customers.add(new Customer("85", "Sima", "Ramat-Gan" , Gender.female, 11));

        //a
        System.out.println("the female ===================");
        customers.stream().filter(w -> w.gender == female).forEach(y->System.out.println(y));

        //b
        System.out.println("the male ===================");
        customers.stream().filter(w -> w.gender == male).forEach(y->System.out.println(y));

        //c
        System.out.println("number of male:");
        System.out.println(customers.stream().filter(w -> w.gender == male).count());

        //d
        System.out.println("List of cities:");
        customers.stream().map(w -> w.city).collect(Collectors.toSet()).forEach(y -> System.out.println(y));

        //f
        //Optional<Integer> max_purchases = customers.stream().max(Integer::compare).get();
             //   customers.stream().map(w -> w.number_of_purchases).max((a, b)-> a.compareTo(b));
      //  customers.stream().filter(w -> w.number_of_purchases).forEach(y->System.out.println(y));

        //g
       // System.out.println(customers.stream().map(w -> w.number_of_purchases).min((a, b)-> a.compareTo(b)));







    }

    //synchronize

    public static synchronized void arr1() {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = rand.nextInt(99) + 1;

            }
            else return;
        }
        System.out.println(Arrays.toString(arr1));
    }


    //Atomic

    public static void arr2() {
        for (int i = 0; i < arr2.length(); i++) {
            int k = arr2.get(i);
            if (k == 0) {
                arr2.set(i, rand.nextInt(99) + 1);
            }
            else {
                return;
            };
        }
        System.out.println((arr2.toString()));
    }
}