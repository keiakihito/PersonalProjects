import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBagTest {
    @org.junit.jupiter.api.Test
    void stubs_Test() {
        System.out.println("\n\n~~~~~~~ LinkedBag Stub_Test~~~~~~~~~~\n\n");
        LinkedBag<String> strBagDflt = new LinkedBag<>();
        LinkedBag<String> strBagDfltCpy = new LinkedBag<>();
        strBagDflt.getCurrentSize();
        strBagDflt.isEmpty();
        strBagDflt.add("A");
        strBagDflt.remove("A");
        strBagDflt.remove();
        strBagDflt.clear();
        strBagDflt.getFrequencyOf("A");
        strBagDflt.contains("A");
        strBagDflt.toArray();
        strBagDflt.printBag();
        strBagDflt.toString();
//        strBagDflt.copyBag();
        strBagDflt.addLast("A");
        strBagDflt.getLast();
        strBagDflt.union(strBagDfltCpy);
        strBagDflt.intersection(strBagDfltCpy);
        strBagDflt.difference(strBagDfltCpy);
        System.out.println("\n\n~~~~~~~  LinkedBag Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void getCurrentSize() {
        LinkedBag<String> lnkdBag = new LinkedBag<>();
        assertEquals(0, lnkdBag.getCurrentSize());

        lnkdBag.add("A");
        assertEquals(1, lnkdBag.getCurrentSize());//

        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");
        assertEquals(6, lnkdBag.getCurrentSize());//
//
        lnkdBag.printBag();
        System.out.println(lnkdBag.toString());

        System.out.println(" \n\n- - - - - - - getCurrentSize_test passed - - - - - - - - - \n\n");

    }


    @Test
    void add() {
        LinkedBag<String> lnkdBag = new LinkedBag<>();
        System.out.println(lnkdBag.toString());

        lnkdBag.add("A");
        System.out.println(lnkdBag.toString());

        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");
        System.out.println(lnkdBag.toString());

        lnkdBag.printBag();

        System.out.println(" \n\n- - - - - - - add_test passed - - - - - - - - - \n\n");

    }

    @Test
    void remove() {
        System.out.println(" \n\n- - - - - - - remove_test - - - - - - - - - ");
        LinkedBag<String> lnkdBag = new LinkedBag<>();

        lnkdBag.add("A");
        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");

        System.out.println("\n\n - - - - - - - Fill up list - - - - - - - - - ");
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("F", lnkdBag.remove());
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("E", lnkdBag.remove());
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("D", lnkdBag.remove());
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("C", lnkdBag.remove());
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("B", lnkdBag.remove());
        System.out.println(lnkdBag.toString());

        System.out.print("\nRemove the first element");
        assertEquals("A", lnkdBag.remove());
        System.out.println(lnkdBag.toString());
        System.out.println(" \n\n- - - - - - - remove_test passed - - - - - - - - - \n\n");


        //remove(T target) test
        System.out.println(" \n\n- - - - - - - remove(T target)_test- - - - - - - - - ");

        LinkedBag<String> lnkdBag2 = new LinkedBag<>();

        lnkdBag2.add("G");
        lnkdBag2.add("H");
        lnkdBag2.add("I");
        lnkdBag2.add("J");

        System.out.println("\n\n - - - - - - - Fill up list - - - - - - - - - ");
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"G\"");
        assertEquals(true, lnkdBag2.remove("G"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"J\"");
        assertEquals(true, lnkdBag2.remove("J"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"K\"");
        assertEquals(false, lnkdBag2.remove("K"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"M\"");
        assertEquals(false, lnkdBag2.remove("M"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"H\"");
        assertEquals(true, lnkdBag2.remove("H"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"I\"");
        assertEquals(true, lnkdBag2.remove("I"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"A\"");
        assertEquals(false, lnkdBag2.remove("A"));
        System.out.println(lnkdBag2.toString());


        System.out.println(" \n\n- - - - - - - remove_test passed - - - - - - - - - \n\n");

    }

    @Test
    void search() {
        LinkedBag<String> lnkdBag = new LinkedBag<>();
        lnkdBag.add("A");
        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");
        System.out.println(lnkdBag.search("A"));
        System.out.println(lnkdBag.search("B"));
        System.out.println(lnkdBag.search("C"));
        System.out.println(lnkdBag.search("D"));
        System.out.println(lnkdBag.search("E"));
        System.out.println(lnkdBag.search("F"));
        System.out.println(lnkdBag.search("G"));

        System.out.println(" \n\n- - - - - - - search_test passed - - - - - - - - - \n\n");

    }


    @Test
    void clear() {
        LinkedBag<String> lnkdBag = new LinkedBag<>();

        lnkdBag.add("A");
        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");

        System.out.print("Fill up linked list");
        System.out.println(lnkdBag.toString());


        System.out.print("\nClear the linked list");
        lnkdBag.clear();
        System.out.println(lnkdBag.toString());

        System.out.println(" \n\n- - - - - - - clear_test passed - - - - - - - - - \n\n");

    }

    @Test
    void getFrequencyOf()
    {

    }

    @Test
    void contains()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        assertEquals(true, bag1.contains("A"));
        assertEquals(true, bag1.contains("B"));
        assertEquals(false, bag1.contains("C"));
        assertEquals(true, bag1.contains("D"));
        assertEquals(true, bag1.contains("E"));
        assertEquals(false, bag1.contains("-1"));

        System.out.println("\n\n~~~contains test  passed~~~~~~\n\n");


    }

    @Test
    void toArray()
    {
        System.out.println("~~~toArray test~~~~~~\n\n");

        BagInterface<String> bag1 = new LinkedBag<>();
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        ArrayList<String> cpyBag = bag1.toArray();
        System.out.println(bag1.toString());
        System.out.println(cpyBag.toString());

        System.out.println("\n\n~~~toArray test  passed~~~~~~\n\n");

        System.out.println("\n\n~~~copy Constructor with Array test ~~~~~\n\n");

        BagInterface<String> lnkdBag = new LinkedBag<>(cpyBag);
        System.out.println(lnkdBag.toString());
        System.out.println("\n\n~~~copy Constructor with Array test passed~~~~~\n\n");


    }

    @Test
    void addLast()
    {
        System.out.println(" - - - - - - - addLast_test  - - - - - - - - - \n\n");

        LinkedBag<String> lnkdBagAcend = new LinkedBag<>();

        lnkdBagAcend.add("A");
        lnkdBagAcend.add("B");
        lnkdBagAcend.add("C");
        lnkdBagAcend.add("D");
        lnkdBagAcend.add("E");
        lnkdBagAcend.add("F");

        LinkedBag<String> lnkdBagDec = new LinkedBag<>();

        lnkdBagDec.addLast("A");
        lnkdBagDec.addLast("B");
        lnkdBagDec.addLast("C");
        lnkdBagDec.addLast("D");
        lnkdBagDec.addLast("E");
        lnkdBagDec.addLast("F");

        System.out.print("With add method linked bag: ");
        System.out.println(lnkdBagAcend.toString());
        System.out.print("\nWith addLast method linked bag: ");
        System.out.println(lnkdBagDec.toString());

        System.out.println(" \n\n- - - - - - - addLast_test  pass- - - - - - - - - \n\n");

    }

    @Test
    void getLast()
    {
        System.out.println(" - - - - - - - getLast_test  - - - - - - - - - \n\n");

        LinkedBag<String> lnkdBag = new LinkedBag<>();

        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());


        lnkdBag.add("A");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());


        lnkdBag.add("B");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());

        lnkdBag.add("C");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());

        lnkdBag.add("D");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());

        lnkdBag.add("E");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());

        lnkdBag.add("F");
        System.out.println(lnkdBag.toString());
        System.out.println(lnkdBag.getLast());

        System.out.println(" \n\n- - - - - - - getLast_test passed - - - - - - - - - \n\n");

    }


//    @Test
//    void copyBag()
//    {
//        BagInterface<String> bag1 = new LinkedBag<>();
//        bag1.add("A");
//        bag1.add("A");
//        bag1.add("B");
//        bag1.add("D");
//        bag1.add("E");
//
//        BagInterface<String> cpyBag1 =  bag1.copyBag();
//
//        System.out.println(bag1.toString());
//        System.out.println(cpyBag1.toString());
//
//        System.out.println("\nCheck deep copy or not, add more elemtns cpyBag");
//
//        cpyBag1.add("G");
//        cpyBag1.add("H");
//        cpyBag1.add("I");
//        cpyBag1.add("J");
//        cpyBag1.add("K");
//        cpyBag1.add("K");
//
//        System.out.print("\n\nOriginal linked bag: ");
//        System.out.println(bag1.toString());
//        System.out.print("\nCopy linked bag: ");
//        System.out.println(cpyBag1.toString());
//
//        System.out.println("\n\n~~~copyBag  passed~~~~~~\n\n");
//
//
//    }



    @Test
    void union()
    {
        System.out.println("~~~union Test~~~~~~\n\n");

        BagInterface<String> bag1 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.print("\n bag 1: ");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new LinkedBag<>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        System.out.print("\n bag 2: ");
        System.out.println(bag2.toString());

        System.out.print("\n Call union method to marge bag 1 and bag 2");
        System.out.println("\n After calling union method  bag 1 and bag 2 are still same");

        BagInterface<String> everything = bag1.union(bag2);

        System.out.print("\n bag 1 : ");
        System.out.println(bag1.toString());
        System.out.print("\n bag 2 : ");
        System.out.println(bag2.toString());
        System.out.print("\n everything : ");
        System.out.println(everything.toString());

        System.out.println("\n\n~~~union Test  passed~~~~~~\n\n");
    }

    @Test
    void intersection()
    {
        System.out.println("~~~intersection Test~~~~~~\n\n");

        BagInterface<String> bag1 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.print("\n bag 1: ");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new LinkedBag<>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        System.out.print("\n bag 2: ");
        System.out.println(bag2.toString());

        System.out.print("\n Call intersection method to marge bag 1 and bag 2");
        System.out.println("\n After intersection union method  bag 1 and bag 2 are still same");

        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> commonItems2 = bag2.intersection(bag1);

        System.out.print("\n bag 1 : ");
        System.out.println(bag1.toString());

        System.out.print("\n bag 2 : ");
        System.out.println(bag2.toString());

        System.out.print("\n commonItems : ");
        System.out.println(commonItems.toString());

        System.out.print("\n commonItems2 : ");
        System.out.println(commonItems2.toString());

        System.out.print("\n\n ~~ duplicate intersection ~~");
        BagInterface<String> bag3 = new LinkedBag<>();
        bag3.add("a");
        bag3.add("b");
        bag3.add("b");
        bag3.add("c");
        System.out.print("\n bag 3: ");
        System.out.println(bag3.toString());

        BagInterface<String> bag4 = new LinkedBag<>();
        bag4.add("b");
        bag4.add("b");
        bag4.add("d");
        bag4.add("e");
        System.out.print("\n bag 4: ");
        System.out.println(bag4.toString());

        System.out.print("\n Call intersection method to marge bag 3 and bag 4");
        System.out.println("\n After intersection union method  bag 3 and bag 4 are still same");


        commonItems = bag3.intersection(bag4);
        commonItems2 = bag4.intersection(bag3);


        System.out.print("\n bag 3 : ");
        System.out.println(bag3.toString());

        System.out.print("\n bag 4 : ");
        System.out.println(bag4.toString());

        System.out.print("\n commonItems : ");
        System.out.println(commonItems.toString());

        System.out.print("\n commonItems2 : ");
        System.out.println(commonItems2.toString());


        System.out.print("\n\n~~~intersection Test  passed~~~~~~\n\n");
    }

    @Test
    void difference()
    {
        System.out.println("~~~difference Test~~~~~~\n\n");

        BagInterface<String> bag1 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new LinkedBag<>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        System.out.println(bag2.toString());

        System.out.print("\n Call difference method to marge bag 1 and bag 2");
        System.out.println("\n After calling difference method  bag 1 and bag 2 are still same");

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        System.out.print("\n bag 1 : ");
        System.out.print(bag1.toString());
        System.out.print("\n bag 2 : ");
        System.out.print(bag2.toString());
        System.out.print("\n leftOver1 : ");
        System.out.print(leftOver1.toString());
        System.out.print("\n leftOver2 : ");
        System.out.print(leftOver2.toString());

        System.out.print("\n\n~~~difference Test  passed~~~~~~\n\n");

    }



} // End of test


