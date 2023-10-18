import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizeableArrayBagTest {

    @org.junit.jupiter.api.Test
    void stubs_Test() {
        System.out.println("\n\n~~~~~~~ ResizeableArray Stub_Test~~~~~~~~~~\n\n");
        ResizeableArrayBag<String> strBagDflt = new ResizeableArrayBag<>();
        ResizeableArrayBag<String> strBagDfltCpy = new ResizeableArrayBag<>();
        strBagDflt.getCurrentSize();
        strBagDflt.isEmpty();
        strBagDflt.add("A");
        strBagDflt.getItem(0);
        strBagDflt.remove("A");
        strBagDflt.remove();
        strBagDflt.clear();
        strBagDflt.getFrequencyOf("A");
        strBagDflt.contains("A");
        strBagDflt.doubleCapacity();
        strBagDflt.toArray();
//        strBagDflt.printBag();
        strBagDflt.toString();
//        strBagDflt.copyBag();
        strBagDflt.union(strBagDfltCpy);
        strBagDflt.intersection(strBagDfltCpy);
        strBagDflt.difference(strBagDfltCpy);

//        String[] intArr = {"1","2","3"};
//        ResizeableArrayBag<String> cpyBag = new ResizeableArrayBag<>(intArr);

        ArrayList<String> cpyBag = new ArrayList<>();
        cpyBag.add("A");
        cpyBag.add("B");
        cpyBag.add("C");

        System.out.println(cpyBag.toString());

        ResizeableArrayBag <String> rsbleBag = new ResizeableArrayBag<>(cpyBag);

        System.out.println(rsbleBag.toString());

        System.out.println("\n\n~~~~~~~ ResizeableArray Stub_Test passed~~~~~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void CTR_Test() {
        //String CTR
        ResizeableArrayBag<String> strBagDflt = new ResizeableArrayBag<>();
        ResizeableArrayBag<String> strBagPara = new ResizeableArrayBag<>(5);

        System.out.println(strBagDflt.toString());
        System.out.println(strBagPara.toString());


        //Character CTR
        ResizeableArrayBag<Character> chaBagDflt = new ResizeableArrayBag<>();
        ResizeableArrayBag<Character> chaBagPara = new ResizeableArrayBag<>(5);

        System.out.println(chaBagDflt.toString());
        System.out.println(chaBagPara.toString());


        //Integer CTR
        ResizeableArrayBag<Integer> IntBagDflt = new ResizeableArrayBag<>();
        ResizeableArrayBag<Integer> IntBagPara = new ResizeableArrayBag<>(5);

        System.out.println(IntBagDflt.toString());
        System.out.println(IntBagPara.toString());

        System.out.println("\n\n~~~~CTR_TEST passed~~~~~~\n\n");
    }


    @org.junit.jupiter.api.Test
    void getCurrentSize() {
        System.out.println("\n\n~~~getCurrentSize Test ~~~~~~\n\n");

        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        assertEquals(3, bag1.getCurrentSize());

        while (!bag1.isEmpty()) {
            bag1.remove();
        }
        assertEquals(0, bag1.getCurrentSize());

        System.out.println("\n\n~~~getCurrentSize Test  passed~~~~~~\n\n");
    }


    @org.junit.jupiter.api.Test
    void isEmpty() {
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        assertEquals(true, bag1.isEmpty());

        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        assertEquals(false, bag1.isEmpty());

        System.out.println("\n\n~~~isEmpty Test  passed~~~~~~\n\n");

    }


    @Test
    void isFull() {
        System.out.println("~~~~~~isFull Test~~~~~~\n\n");

        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        assertEquals(false, bag1.isFull());
        System.out.println(bag1.toString());

        bag1.add("A");
        bag1.add("A");
        assertEquals(false, bag1.isFull());
        System.out.println(bag1.toString());

        bag1.add("B");
        bag1.add("D");
        bag1.add("E");
        assertEquals(true, bag1.isFull());
        System.out.println(bag1.toString());

        System.out.println("\n\n~~~isFull Test  passed~~~~~~\n\n");


    }



    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("\n\n~~~addTest  ~~~~~~\n\n");
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        assertEquals(true, bag1.add("A"));

        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        bag1.add("E");
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag1.isFull());
        System.out.println(bag1.toString());


        bag1.add("F");
        assertEquals(false, bag1.isEmpty());
        assertEquals(false, bag1.isFull());

        System.out.println(bag1.toString());

        System.out.println("\n\n~~~add Test  passed~~~~~~\n\n");

    }

    @Test
    void getItem() {
        System.out.println("~~~ getItem Test~~~~~~\n\n");
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        assertEquals("A", bag1.getItem(0));
        assertEquals("A", bag1.getItem(1));
        assertEquals("B", bag1.getItem(2));
        assertEquals("D", bag1.getItem(3));
        assertEquals("E", bag1.getItem(4));

        System.out.println(bag1.toString());
        System.out.println("\n\n~~~getItem Test  passed~~~~~~\n\n");
    }

    @Test
    void doubleCapacity() {
        System.out.println("~~~ doubleCapacity  Test~~~~~~\n\n");
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        System.out.println(bag1.toString());

        bag1.doubleCapacity();
        System.out.println(bag1.toString());
        System.out.println("\n\n~~~doubleCapacity  passed~~~~~~\n\n");

    }


    @org.junit.jupiter.api.Test
    void remove() {
        System.out.println("~~~ remove  Test~~~~~~\n\n");

        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        bag1.add("B");
        bag1.add("E");
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag1.isFull());

        for (int i = 0; i < 5; i++) {
            System.out.print("Erased item: ");
            System.out.println(bag1.remove());
        }

        assertEquals(true, bag1.isEmpty());
        assertEquals(false, bag1.isFull());

        System.out.print("bag1 is empty\n");
        System.out.println(bag1.toString());

        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        bag1.add("B");
        bag1.add("E");
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag1.isFull());

        System.out.print("\nFill up bag1: ");
        System.out.println(bag1.toString());

        assertEquals(true, bag1.remove("A"));
        assertEquals(true, bag1.remove("E"));
        //Check right now
        System.out.print("\nRemove 2 items: ");
        System.out.println(bag1.toString());

        //Cannot move anything
        assertEquals(false, bag1.remove("-1"));
        assertEquals(false, bag1.remove("a"));

        //After operation
        System.out.print("\nAfter operation: ");
        System.out.println(bag1.toString());

        assertEquals(false, bag1.isEmpty());
        assertEquals(false, bag1.isFull());

        assertEquals(true, bag1.remove("B"));
        assertEquals(true, bag1.remove("B"));
        assertEquals(true, bag1.remove("A"));
        System.out.println(bag1.toString());


        System.out.println("\n\n~~~remove Test passed~~~~~~\n\n");


    }


    @org.junit.jupiter.api.Test
    void clear() {
        System.out.println("~~~clear Test~~~~~~\n\n");

        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        bag1.add("B");
        bag1.add("E");

        System.out.print("Fill up bag1: ");
        System.out.println(bag1.toString());

        bag1.clear();
        assertEquals(true, bag1.isEmpty());
        assertEquals(false, bag1.isFull());

        System.out.print("Clear bag1: ");
        System.out.println(bag1.toString());


        System.out.println("\n\n~~~clear test  passed~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void getFrequencyOf() {
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        assertEquals(2, bag1.getFrequencyOf("A"));
        assertEquals(1, bag1.getFrequencyOf("B"));
        assertEquals(0, bag1.getFrequencyOf("C"));
        assertEquals(1, bag1.getFrequencyOf("D"));
        assertEquals(1, bag1.getFrequencyOf("E"));
        assertEquals(0, bag1.getFrequencyOf("-1"));


        System.out.println("\n\n~~~getFrequencyOf test  passed~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void contains() {
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
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

//    @org.junit.jupiter.api.Test
//    void toArray() {
//        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
//        bag1.add("A");
//        bag1.add("A");
//        bag1.add("B");
//        bag1.add("D");
//        bag1.add("E");
//
//        Object[] arrayBagCopy = bag1.toArray();
////        System.out.println(bag1.toArray());
//        System.out.print("arrayBagCopy : ");
//        System.out.print("{ ");
//        for (Object s : arrayBagCopy) {
//            System.out.print(s);
//            System.out.print(" ");
//        }
//        System.out.print("}");
//
//        System.out.println("\n\n~~~toArray test  passed~~~~~~\n\n");
//
//    }

    @org.junit.jupiter.api.Test
    void printBag() {
        ResizeableArrayBag<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        bag1.printBag();
        System.out.println(bag1.toString());
    }


//    @org.junit.jupiter.api.Test
//    void copyBag() {
//        System.out.println("~~~copyBag Test~~~~~~\n\n");
//
//        BagInterface<String> bag1 = new ResizeableArrayBag<>(5);
//        bag1.add("A");
//        bag1.add("A");
//        bag1.add("B");
//        bag1.add("D");
//        bag1.add("E");
//
////        ResizeableArrayBag<String> cpyBag1 = (ResizeableArrayBag<String>) bag1.copyBag(bag1);
//        BagInterface<String> cpyBag1 =  bag1.copyBag();
////        cpyBag1.copyBag(bag1);
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
//        System.out.println(bag1.toString());
//        System.out.println(cpyBag1.toString());
//
//        System.out.println("\n\n~~~copyBag  passed~~~~~~\n\n");
//
//    }

    @org.junit.jupiter.api.Test
    void union() {
        System.out.println("~~~union Test~~~~~~\n\n");

        BagInterface<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new ResizeableArrayBag<>(5);
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
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

    @org.junit.jupiter.api.Test
    void intersection()
    {
        System.out.println("~~~intersection Test~~~~~~\n\n");

        BagInterface<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new ResizeableArrayBag<>(5);
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        System.out.println(bag2.toString());

        System.out.print("\n Call intersection method to marge bag 1 and bag 2");
        System.out.println("\n After intersection union method  bag 1 and bag 2 are still same");

        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> commonItems2 = bag2.intersection(bag1);

        System.out.print("\n bag 1 : ");
        System.out.print(bag1.toString());
        System.out.print("\n bag 2 : ");
        System.out.print(bag2.toString());
        System.out.print("\n commonItems : ");
        System.out.print(commonItems.toString());
        System.out.print("\n commonItems2 : ");
        System.out.print(commonItems2.toString());

        System.out.print("\n \n\n~~Dupicate ones ~~\n\n");


        BagInterface<String> bag3 = new ResizeableArrayBag<>(5);
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");
        System.out.println(bag3.toString());

        BagInterface<String> bag4 = new ResizeableArrayBag<>(5);
        bag4.add("b");
        bag4.add("b");
        bag4.add("d");
        bag4.add("e");
        System.out.println(bag4.toString());

        System.out.print("\n Call intersection method to marge bag 3 and bag 4");
        System.out.println("\n After intersection union method  bag 3 and bag 4 are still same");

        BagInterface<String> commonItems3 = bag3.intersection(bag4);
        BagInterface<String> commonItems4 = bag4.intersection(bag3);

        System.out.print("\n bag 3 : ");
        System.out.print(bag3.toString());
        System.out.print("\n bag 4 : ");
        System.out.print(bag4.toString());
        System.out.print("\n commonItems3 : ");
        System.out.print(commonItems3.toString());
        System.out.print("\n commonItems4 : ");
        System.out.print(commonItems4.toString());



        System.out.print("\n\n~~~intersection Test  passed~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void difference()
    {
        System.out.println("~~~difference Test~~~~~~\n\n");

        BagInterface<String> bag1 = new ResizeableArrayBag<>(5);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        System.out.println(bag1.toString());

        BagInterface<String> bag2 = new ResizeableArrayBag<>(5);
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

}
