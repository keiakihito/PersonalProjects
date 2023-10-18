import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LlinkedBagTest {

    @Test
    void getCurrentSize()
    {
        LinkedBag <String>lnkdBag = new LinkedBag<>();
        assertEquals(0,  lnkdBag.getCurrentSize());

        lnkdBag.add("A");
        assertEquals(1,  lnkdBag.getCurrentSize());//

        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");
        assertEquals(6,  lnkdBag.getCurrentSize());//
//
        lnkdBag.printList();
        System.out.println(lnkdBag.toString());

        System.out.println(" \n\n- - - - - - - getCurrentSize_test passed - - - - - - - - - \n\n");
    }

    @Test
    void isEmpty() {
    }

    @Test
    void add()
    {
        LinkedBag <String>lnkdBag = new LinkedBag<>();
        System.out.println(lnkdBag.toString());

        lnkdBag.add("A");
        System.out.println(lnkdBag.toString());

        lnkdBag.add("B");
        lnkdBag.add("C");
        lnkdBag.add("D");
        lnkdBag.add("E");
        lnkdBag.add("F");
        System.out.println(lnkdBag.toString());

        lnkdBag.printList();

        System.out.println(" \n\n- - - - - - - add_test passed - - - - - - - - - \n\n");

    }

    @Test
    void remove()
    {
        System.out.println(" \n\n- - - - - - - remove_test - - - - - - - - - ");
        LinkedBag <String>lnkdBag = new LinkedBag<>();

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

        LinkedBag <String>lnkdBag2 = new LinkedBag<>();

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
        System.out.p
    rintln(lnkdBag2.toString());


        System.out.print("\nRemove \"I\"");
        assertEquals(true, lnkdBag2.remove("I"));
        System.out.println(lnkdBag2.toString());


        System.out.print("\nRemove \"A\"");
        assertEquals(false, lnkdBag2.remove("A"));
        System.out.println(lnkdBag2.toString());





        System.out.println(" \n\n- - - - - - - remove_test passed - - - - - - - - - \n\n");

    }

    @Test
    void search()
    {
        LinkedBag <String>lnkdBag = new LinkedBag<>();
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
    void clear()
    {
        LinkedBag <String>lnkdBag = new LinkedBag<>();

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
    void getFrequencyOf() {
    }

    @Test
    void contains() {
    }

    @Test
    void toArray() {
    }
}