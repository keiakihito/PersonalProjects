import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBagTest {
    @org.junit.jupiter.api.Test
    void stubs_Test() {
        System.out.println("\n\n~~~~~~~ LinkedBag Stub_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> strBagDflt = new LinkedBag<>('A');
        strBagDflt.getCurrentSize();
        strBagDflt.isEmpty();
        strBagDflt.add('A');
        strBagDflt.remove('A');
        strBagDflt.remove();
        strBagDflt.clear();
        strBagDflt.contains('A');
        strBagDflt.toArray();
        strBagDflt.printBag();
        strBagDflt.toString();

        System.out.println("\n\n~~~~~~~  LinkedBag Stub_Test passed~~~~~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void getCurrentSize() {
        System.out.println("\n\n~~~~~~~ LinkedBag getCurrentSize_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        assertEquals(0, charBag.getCurrentSize());

        charBag.add('B');
        charBag.add('C');
        charBag.add('D');
        assertEquals(3, charBag.getCurrentSize());


        System.out.println("\n\n~~~~~~~  LinkedBag getCurrentSIze_Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void getHeadVertex() {
        System.out.println("\n\n~~~~~~~ LinkedBag getHeadVertex_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBagA = new LinkedBag<>('A');
        assertEquals('A', charBagA.getHeadVertex());

        LinkedBag<Character> charBagB = new LinkedBag<>('B');
        assertEquals('B', charBagB.getHeadVertex());

        LinkedBag<Character> charBagC = new LinkedBag<>('C');
        assertEquals('C', charBagC.getHeadVertex());

        LinkedBag<Character> charBagD= new LinkedBag<>('D');
        assertEquals('D', charBagD.getHeadVertex());


        System.out.println("\n\n~~~~~~~  LinkedBag getHeadVertex_Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println("\n\n~~~~~~~ LinkedBag isEmpty _Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        assertEquals(true, charBag.isEmpty());

        charBag.add('B');
        charBag.add('C');
        charBag.add('D');
        assertEquals(false, charBag.isEmpty());

        System.out.println("\n\n~~~~~~~  LinkedBag isEmpty_Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("\n\n~~~~~~~ LinkedBag add_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        assertEquals(true, charBag.isEmpty());

        charBag.add('B');
        charBag.add('C');
        charBag.add('D');
        assertEquals(false, charBag.isEmpty());

        System.out.println(charBag.toString());

        System.out.println("\n\n~~~~~~~  LinkedBag _Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void clear() {
        System.out.println("\n\n~~~~~~~ LinkedBag clear_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        assertEquals(true, charBag.isEmpty());

        charBag.add('B');
        charBag.add('C');
        charBag.add('D');
        assertEquals(false, charBag.isEmpty());

        System.out.println(charBag.toString());

        charBag.clear();
        assertEquals(true, charBag.isEmpty());

        System.out.println("\nAfter clear: ");
        System.out.println(charBag.toString());

        System.out.println("\n\n~~~~~~~  LinkedBag clear_Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void contains() {
        System.out.println("\n\n~~~~~~~ LinkedBag _Test~~~~~~~~~~\n\n");

        LinkedBag<Character> charBag = new LinkedBag<>('A');
        assertEquals(true, charBag.isEmpty());

        charBag.add('B');
        charBag.add('C');
        charBag.add('D');
        assertEquals(false, charBag.isEmpty());

        System.out.println(charBag.toString());

        assertEquals(false, charBag.contains('A'));
        assertEquals(true, charBag.contains('B'));
        assertEquals(true, charBag.contains('C'));
        assertEquals(true, charBag.contains('D'));
        assertEquals(false, charBag.contains('E'));

        charBag.clear();
        assertEquals(true, charBag.isEmpty());

        assertEquals(false, charBag.contains('A'));
        assertEquals(false, charBag.contains('B'));
        assertEquals(false, charBag.contains('C'));
        assertEquals(false, charBag.contains('D'));
        assertEquals(false, charBag.contains('E'));


        System.out.println("\nAfter clear: ");
        System.out.println(charBag.toString());
        System.out.println("\n\n~~~~~~~  LinkedBag _Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void toArray() {
        System.out.println("\n\n~~~~~~~ LinkedBag _Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        charBag.add('B');
        charBag.add('C');
        charBag.add('D');

        ArrayList<Character> charBagArr= charBag.toArray();
        System.out.println(charBagArr.toString());

        System.out.println("\n\n~~~~~~~  LinkedBag _Test passed~~~~~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void printBag() {
        System.out.println("\n\n~~~~~~~ LinkedBag printBag_Test~~~~~~~~~~\n\n");
        LinkedBag<Character> charBag = new LinkedBag<>('A');
        charBag.add('B');
        charBag.add('C');
        charBag.add('D');

        charBag.printBag();
        System.out.println("\n\n~~~~~~~  LinkedBag printBag_Test passed~~~~~~~~~~\n\n");

    }
}