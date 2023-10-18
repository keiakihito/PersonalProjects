import static org.junit.jupiter.api.Assertions.*;

class ArrayBagTest <T>{
    @org.junit.jupiter.api.Test
    void stubs_Test() {
        ArrayBag<String> strBagDflt = new ArrayBag<>();
        strBagDflt.getCurrentSize();
        strBagDflt.isEmpty();
        strBagDflt.add("1");
        strBagDflt.remove();
        strBagDflt.remove("1");
        strBagDflt.clear();
        strBagDflt.getFrequencyOf("0");
        strBagDflt.contains("1");
        strBagDflt.toArray();
        System.out.println("\n\n~~~~Stub Test passed~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void CTR_Test()
    {
        //String CTR
        ArrayBag<String> strBagDflt = new ArrayBag<>();
        ArrayBag<String> strBagPara = new ArrayBag<>(5);

        System.out.println(strBagDflt.toString());
        System.out.println(strBagPara.toString());


        //Character CTR
        ArrayBag<Character> chaBagDflt = new ArrayBag<>();
        ArrayBag<Character> chaBagPara = new ArrayBag<>(5);

        System.out.println(chaBagDflt.toString());
        System.out.println(chaBagPara.toString());


        //Integer CTR
        ArrayBag<Integer> IntBagDflt = new ArrayBag<>();
        ArrayBag<Integer> IntBagPara = new ArrayBag<>(5);

        System.out.println(IntBagDflt.toString());
        System.out.println(IntBagPara.toString());

        System.out.println("\n\n~~~~CTR_TEST passed~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void getCurrentSize() {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        assertEquals(3, bag1.getCurrentSize());

        while(!bag1.isEmpty()){
            bag1.remove();
        }
        assertEquals(0, bag1.getCurrentSize());

        System.out.println("\n\n~~~getCurrentSize Test  passed~~~~~~\n\n");
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
        assertEquals(true, bag1.isEmpty());

        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        assertEquals(false, bag1.isEmpty());

        System.out.println("\n\n~~~isEmpty Test  passed~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void add()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
        assertEquals(true,        bag1.add("A"));

        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        bag1.add("E");
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag1.isFull());

        System.out.println("\n\n~~~add Test  passed~~~~~~\n\n");


    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        bag1.add("B");
        bag1.add("E");
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag1.isFull());

        for(int i = 0; i < 5; i++){
            System.out.print("Erased item: ");
            System.out.println(bag1.remove());
        }

        assertEquals(true, bag1.isEmpty());
        assertEquals(false, bag1.isFull());

        System.out.print("bag1 is empty");
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


        System.out.println("\n\n~~~add remove  passed~~~~~~\n\n");

    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
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
    void getFrequencyOf()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
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
    void contains()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
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

    @org.junit.jupiter.api.Test
    void toArray()
    {
        ArrayBag<String> bag1 = new ArrayBag<>(5);
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("D");
        bag1.add("E");

        Object [] arrayBagCopy = bag1.toArray();
//        System.out.println(bag1.toArray());
        System.out.print("arrayBagCopy : ");
        System.out.print("{ ");
        for (Object s: arrayBagCopy){
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.print("}");

        System.out.println("\n\n~~~toArray test  passed~~~~~~\n\n");

    }

}