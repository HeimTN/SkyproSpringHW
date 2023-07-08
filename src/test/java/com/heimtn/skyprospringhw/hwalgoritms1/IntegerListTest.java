package com.heimtn.skyprospringhw.hwalgoritms1;

import com.heimtn.skyprospringhw.hwalgoritms1.classes.IntegerListImpl;
import com.heimtn.skyprospringhw.hwalgoritms1.interfaces.IntegerList;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListNotContainsException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListNullArgumentException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListOutOfBountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerListTest {
    IntegerList IntegerList = new IntegerListImpl();

    @Test
    public void add(){
        Assertions.assertEquals(1, IntegerList.size());
        Assertions.assertEquals(10,IntegerList.add(10));
        Assertions.assertEquals(1, IntegerList.size());
        IntegerList.add(22);
        Assertions.assertEquals(2, IntegerList.size());
    }

    @Test
    public void addNegative(){
        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.add(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
    }

    @Test
    public void addToIndex(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertEquals(12, IntegerList.add(2,12));
        Assertions.assertEquals(5,IntegerList.size());
    }

    @Test
    public void addToIndexNegative(){
        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.add(2,null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        IntegerListOutOfBountException thrown1 = Assertions.assertThrows(IntegerListOutOfBountException.class,
                () -> IntegerList.add(10,11));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void set(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertEquals(66, IntegerList.set(2,66));
        Assertions.assertEquals(4,IntegerList.size());
    }

    @Test
    public void setNegative(){
        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.set(2,null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        IntegerListOutOfBountException thrown1 = Assertions.assertThrows(IntegerListOutOfBountException.class,
                () -> IntegerList.set(10,66));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void remove(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Integer temp = 33;
        Assertions.assertEquals(33, IntegerList.remove(temp));
        Assertions.assertEquals(3,IntegerList.size());
    }

    @Test
    public void removeNegative(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.remove(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
    }

    @Test
    public void removeToIndex(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertEquals(55, IntegerList.remove(3));
        Assertions.assertEquals(3,IntegerList.size());
    }

    @Test
    public void removeToIndexNegative(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerListOutOfBountException thrown1 = Assertions.assertThrows(IntegerListOutOfBountException.class,
                () -> IntegerList.remove(10));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void contains(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertTrue(IntegerList.contains(22));
        Assertions.assertFalse(IntegerList.contains(66));
    }

    @Test
    public void containsNegative(){
        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.contains(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
    }

    @Test
    public void indexOf(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(22);

        Assertions.assertEquals(0,IntegerList.indexOf(22));
    }

   // @Test
    public void indexOfNegative(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(22);

        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.indexOf(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
        Integer item = 66;
        IntegerListNotContainsException thrown1 = Assertions.assertThrows(IntegerListNotContainsException.class,
                () -> IntegerList.indexOf(item));
        Assertions.assertEquals("66 not contains", thrown1.getMessage());
    }

    @Test
    public void lastIndexOf(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(22);

        Assertions.assertEquals(3,IntegerList.lastIndexOf(22));
    }

    @Test
    public void lastIndexOfNegative(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(22);

        IntegerListNullArgumentException thrown = Assertions.assertThrows(IntegerListNullArgumentException.class,
                () -> IntegerList.lastIndexOf(null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        IntegerListNotContainsException thrown1 = Assertions.assertThrows(IntegerListNotContainsException.class,
                () -> IntegerList.lastIndexOf(66));
        Assertions.assertEquals("66 not contains", thrown1.getMessage());
    }

    @Test
    public void get(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertEquals(22,IntegerList.get(0));
        Assertions.assertEquals(33,IntegerList.get(1));
        Assertions.assertEquals(11,IntegerList.get(2));
        Assertions.assertEquals(55,IntegerList.get(3));
    }

    @Test
    public void getNegative(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerListOutOfBountException thrown1 = Assertions.assertThrows(IntegerListOutOfBountException.class,
                () -> IntegerList.get(10));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void equalsTrue(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(22);
        otherIntegerList.add(33);
        otherIntegerList.add(11);
        otherIntegerList.add(55);

        Assertions.assertTrue(IntegerList.equals(otherIntegerList));
    }

    @Test
    public void equalsFalseSameCell(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(22);
        otherIntegerList.add(33);
        otherIntegerList.add(11);
        otherIntegerList.add(22);

        Assertions.assertFalse(IntegerList.equals(otherIntegerList));
    }

    @Test
    public void equalsFalseDifferentCellOption1(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(22);
        otherIntegerList.add(33);
        otherIntegerList.add(11);

        Assertions.assertFalse(IntegerList.equals(otherIntegerList));
    }

    @Test
    public void equalsFalseDifferentCellOption2(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        IntegerList otherIntegerList = new IntegerListImpl();
        otherIntegerList.add(22);
        otherIntegerList.add(33);
        otherIntegerList.add(11);
        otherIntegerList.add(55);
        otherIntegerList.add(55);

        Assertions.assertFalse(IntegerList.equals(otherIntegerList));
    }

    @Test
    public void isEmpty(){
        Assertions.assertTrue(IntegerList.isEmpty());

        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertFalse(IntegerList.isEmpty());
    }

    @Test
    public void clear(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Assertions.assertFalse(IntegerList.isEmpty());
        IntegerList.clear();
        Assertions.assertTrue(IntegerList.isEmpty());
    }

    @Test
    public void toArray(){
        IntegerList.add(22);
        IntegerList.add(33);
        IntegerList.add(11);
        IntegerList.add(55);

        Integer[] expected = new Integer[]{22,
                33, 11, 55};

        Assertions.assertEquals(expected[0], IntegerList.toArray()[0]);
        Assertions.assertEquals(expected[1], IntegerList.toArray()[1]);
        Assertions.assertEquals(expected[2], IntegerList.toArray()[2]);
        Assertions.assertEquals(expected[3], IntegerList.toArray()[3]);
    }
}
