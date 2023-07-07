package com.heimtn.skyprospringhw.hwalgoritms1;

import com.heimtn.skyprospringhw.hwalgoritms1.classes.StringListImpl;
import com.heimtn.skyprospringhw.hwalgoritms1.interfaces.StringList;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListNotContainsException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListNullArgumentException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListOutOfBountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringListTest {
    StringList stringList = new StringListImpl();

    @Test
    public void add(){
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals("строка",stringList.add("строка"));
        Assertions.assertEquals(1, stringList.size());
        stringList.add("строка");
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void addNegative(){
        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.add(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
    }

    @Test
    public void addToIndex(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertEquals("тест", stringList.add(2,"тест"));
        Assertions.assertEquals(5,stringList.size());
    }

    @Test
    public void addToIndexNegative(){
        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.add(2,null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        StringListOutOfBountException thrown1 = Assertions.assertThrows(StringListOutOfBountException.class,
                () -> stringList.add(10,"строка1"));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void set(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertEquals("тест", stringList.set(2,"тест"));
        Assertions.assertEquals(4,stringList.size());
    }

    @Test
    public void setNegative(){
        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.set(2,null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        StringListOutOfBountException thrown1 = Assertions.assertThrows(StringListOutOfBountException.class,
                () -> stringList.set(10,"строка1"));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void remove(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertEquals("строка2", stringList.remove("строка2"));
        Assertions.assertEquals(3,stringList.size());
    }

    @Test
    public void removeNegative(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.remove(null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        StringListNotContainsException thrown1 = Assertions.assertThrows(StringListNotContainsException.class,
                () -> stringList.remove("стр"));
        Assertions.assertEquals("стр not contains", thrown1.getMessage());
    }

    @Test
    public void removeToIndex(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertEquals("строка3", stringList.remove(3));
        Assertions.assertEquals(3,stringList.size());
    }

    @Test
    public void removeToIndexNegative(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringListOutOfBountException thrown1 = Assertions.assertThrows(StringListOutOfBountException.class,
                () -> stringList.remove(10));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void contains(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertTrue(stringList.contains("строка1"));
        Assertions.assertFalse(stringList.contains("тест"));
    }

    @Test
    public void containsNegative(){
        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.contains(null));
        Assertions.assertEquals("item == null", thrown.getMessage());
    }

    @Test
    public void indexOf(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка");

        Assertions.assertEquals(0,stringList.indexOf("строка"));
    }

    @Test
    public void indexOfNegative(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка");

        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.indexOf(null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        StringListNotContainsException thrown1 = Assertions.assertThrows(StringListNotContainsException.class,
                () -> stringList.indexOf("стр"));
        Assertions.assertEquals("стр not contains", thrown1.getMessage());
    }

    @Test
    public void lastIndexOf(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка");

        Assertions.assertEquals(3,stringList.lastIndexOf("строка"));
    }

    @Test
    public void lastIndexOfNegative(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка");

        StringListNullArgumentException thrown = Assertions.assertThrows(StringListNullArgumentException.class,
                () -> stringList.lastIndexOf(null));
        Assertions.assertEquals("item == null", thrown.getMessage());

        StringListNotContainsException thrown1 = Assertions.assertThrows(StringListNotContainsException.class,
                () -> stringList.lastIndexOf("стр"));
        Assertions.assertEquals("стр not contains", thrown1.getMessage());
    }

    @Test
    public void get(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertEquals("строка",stringList.get(0));
        Assertions.assertEquals("строка1",stringList.get(1));
        Assertions.assertEquals("строка2",stringList.get(2));
        Assertions.assertEquals("строка3",stringList.get(3));
    }

    @Test
    public void getNegative(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringListOutOfBountException thrown1 = Assertions.assertThrows(StringListOutOfBountException.class,
                () -> stringList.get(10));
        Assertions.assertEquals("index > size", thrown1.getMessage());
    }

    @Test
    public void equalsTrue(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringList otherStringList = new StringListImpl();
        otherStringList.add("строка");
        otherStringList.add("строка1");
        otherStringList.add("строка2");
        otherStringList.add("строка3");

        Assertions.assertTrue(stringList.equals(otherStringList));
    }

    @Test
    public void equalsFalseSameCell(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringList otherStringList = new StringListImpl();
        otherStringList.add("строка");
        otherStringList.add("строка1");
        otherStringList.add("строка2");
        otherStringList.add("строка");

        Assertions.assertFalse(stringList.equals(otherStringList));
    }

    @Test
    public void equalsFalseDifferentCellOption1(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringList otherStringList = new StringListImpl();
        otherStringList.add("строка");
        otherStringList.add("строка1");
        otherStringList.add("строка2");

        Assertions.assertFalse(stringList.equals(otherStringList));
    }

    @Test
    public void equalsFalseDifferentCellOption2(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        StringList otherStringList = new StringListImpl();
        otherStringList.add("строка");
        otherStringList.add("строка1");
        otherStringList.add("строка2");
        otherStringList.add("строка3");
        otherStringList.add("строка3");

        Assertions.assertFalse(stringList.equals(otherStringList));
    }

    @Test
    public void isEmpty(){
        Assertions.assertTrue(stringList.isEmpty());

        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertFalse(stringList.isEmpty());
    }

    @Test
    public void clear(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        Assertions.assertFalse(stringList.isEmpty());
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    public void toArray(){
        stringList.add("строка");
        stringList.add("строка1");
        stringList.add("строка2");
        stringList.add("строка3");

        String[] expected = new String[]{"строка",
        "строка1", "строка2", "строка3"};

        Assertions.assertEquals(expected[0], stringList.toArray()[0]);
        Assertions.assertEquals(expected[1], stringList.toArray()[1]);
        Assertions.assertEquals(expected[2], stringList.toArray()[2]);
        Assertions.assertEquals(expected[3], stringList.toArray()[3]);
    }

}
