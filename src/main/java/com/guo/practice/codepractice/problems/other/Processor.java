package com.guo.practice.codepractice.problems.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Processor {

    public boolean processPurchaseOrders(PurchaseOrder... orders) {
        boolean success = false;

        // process PurchaseOrders here

        return success;
    }

    public static void main(String[] args) {
//        Processor processor = new Processor();
//
//        PurchaseOrder po1 = new PurchaseOrder("Dilbert's Wish List", 42);
//        PurchaseOrder po2 = new PurchaseOrder("Wally's Essentials", 43);
//        PurchaseOrder[] poArray = new PurchaseOrder[]{po1, po2};
//
////        processor.processPurchaseOrders(poArray, po1);
//
//        processor.processPurchaseOrders(poArray);
//
////        processor.processPurchaseOrders(po1, poArray);
//
//        processor.processPurchaseOrders(po1, po2);
//        processor.processPurchaseOrders(po1);

        List names = Arrays.asList("Bob", "Bill", "Ben");
// What goes here?

//        names.sort(a.compareTo(b))
        Collections.sort(names);
//        names.orderBy((a) -> (a.toString()))
//        names.sort((a, b) -> (a.compareTo(b)));

        System.out.println(names);



    }
}
