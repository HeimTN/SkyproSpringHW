package com.heimtn.skyprospringhw.hwalgoritms1.classes;

import com.heimtn.skyprospringhw.hwalgoritms1.interfaces.StringList;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListNotContainsException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListNullArgumentException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.StringListOutOfBountException;


public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl(){
        this.stringList = new String[1];
        this.size = 0;
    }

    //Добавление ячейки
    private void addCell(){
        size++;
        String[] temp = new String[size+1];
        for (int i = 0; i < stringList.length; i++) {
            temp[i] = stringList[i];
        }
        stringList = temp;
    }

    //Добавление ячейки в конкретный индекс
    private void addCell(int cell){
        size++;
        String[] temp = new String[size+1];
        for (int j = cell; j < stringList.length-1; j++) {
            temp[j+1] = stringList[j];
        }
        stringList = temp;
    }

    private void removeCell(int cell){
        size--;
        String[] temp = new String[size+1];
        for (int j = cell; j < stringList.length-1; j++) {
            temp[j] = stringList[j+1];
        }
        stringList = temp;
    }

    @Override
    public String add(String item) {
        if(item != null) {
            if(stringList[size] != null) addCell();
            stringList[size] = item;
            return stringList[size];
        }
        throw new StringListNullArgumentException("item == null");
    }

    @Override
    public String add(int index, String item) {
        if(item != null && index < size+1){
            addCell(index);
            stringList[index] = item;
            return stringList[index];
        }
        if(item == null) {
            throw new StringListNullArgumentException("item == null");
        }
            throw new StringListOutOfBountException("index > size");
    }

    @Override
    public String set(int index, String item) {
        if(item != null && index < size+1){
            stringList[index] = item;
            return stringList[index];
        }
        if(item == null) {
            throw new StringListNullArgumentException("item == null");
        }
        throw new StringListOutOfBountException("index > size");
    }

    @Override
    public String remove(String item) {
        if(item != null && contains(item)){
            for (int i = 0; i < stringList.length; i++) {
                if(stringList[i].equals(item)){
                    removeCell(i);
                    return item;
                }
            }
        }
        if(item == null) {
            throw new StringListNullArgumentException("item == null");
        }
        throw new StringListNotContainsException(item + " not contains");
    }

    @Override
    public String remove(int index) {
        if(index < size+1){
            String temp = stringList[index];
            removeCell(index);
            return temp;
        }
        throw new StringListOutOfBountException("index > size");
    }

    @Override
    public boolean contains(String item) {
        if(item != null) {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    return true;
                }
            }
            return false;
        }
        throw new StringListNullArgumentException("item == null");
    }

    @Override
    public int indexOf(String item) {
        if(item != null && contains(item)) {
            for (int i = 0; i < stringList.length; i++) {
                if(stringList[i].equals(item)){
                    return i;
                }
            }
        }
        if(item == null) {
            throw new StringListNullArgumentException("item == null");
        }
        throw new StringListNotContainsException(item + " not contains");
    }

    @Override
    public int lastIndexOf(String item) {
        if(item != null && contains(item)) {
            for (int i = stringList.length-1; i >= 0; i--) {
                if(stringList[i].equals(item)){
                    return i;
                }
            }
        }
        if(item == null) {
            throw new StringListNullArgumentException("item == null");
        }
        throw new StringListNotContainsException(item + " not contains");
    }

    @Override
    public String get(int index) {
        if(index < size+1){
            return stringList[index];
        }
        throw new StringListOutOfBountException("index > size");
    }

    @Override
    public boolean equals(StringList otherList) {
        if(stringList.length != otherList.size()) return false;
        for (int i = 0; i < stringList.length; i++) {
            if(!stringList[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size+1;
    }

    @Override
    public boolean isEmpty() {
        return stringList[0] == null;
    }

    @Override
    public void clear() {
        stringList = new String[1];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return stringList;
    }
}
