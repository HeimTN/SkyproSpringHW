package com.heimtn.skyprospringhw.hwalgoritms1.classes;

import com.heimtn.skyprospringhw.hwalgoritms1.interfaces.IntegerList;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListNotContainsException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListNullArgumentException;
import com.heimtn.skyprospringhw.hwalgoritms1.throwns.IntegerListOutOfBountException;


public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl(){
        this.integerList = new Integer[1];
        this.size = 0;
    }

    //Сортировка
    private void sort(){
        for (int i = 0; i < integerList.length -1; i++) {
            for (int j = 0; j < integerList.length-1-i; j++) {
                if(integerList[j] > integerList[j+1]){
                    int temp = integerList[j];
                    integerList[j] = integerList[j+1];
                    integerList[j+1] = temp;
                }
            }
        }
    }

    private Integer search(Integer item){
        int min = 0;
        int max = integerList.length - 1;
        sort();
        while (min <= max){
            int mid = (min+max)/2;
            if(item.equals(integerList[mid])){
                return mid;
            }
            if(item < integerList[mid]){
                max = mid - 1;
            } else {
                min = mid - 1;
            }
        }
        return null;
    }

    //Добавление ячейки
    private void addCell(){
        size++;
        Integer[] temp = new Integer[size+1];
        for (int i = 0; i < integerList.length; i++) {
            temp[i] = integerList[i];
        }
        integerList = temp;
    }

    //Добавление ячейки в конкретный индекс
    private void addCell(int cell){
        size++;
        Integer[] temp = new Integer[size+1];
        for (int j = cell; j < integerList.length-1; j++) {
            temp[j+1] = integerList[j];
        }
        integerList = temp;
    }

    private void removeCell(int cell){
        size--;
        Integer[] temp = new Integer[size+1];
        for (int j = cell; j < integerList.length-1; j++) {
            temp[j] = integerList[j+1];
        }
        integerList = temp;
    }

    @Override
    public Integer add(Integer item) {
        if(item != null) {
            if(integerList[size] != null) addCell();
            integerList[size] = item;
            return integerList[size];
        }
        throw new IntegerListNullArgumentException("item == null");
    }

    @Override
    public Integer add(int index, Integer item) {
        if(item != null && index < size+1){
            addCell(index);
            integerList[index] = item;
            return integerList[index];
        }
        if(item == null) {
            throw new IntegerListNullArgumentException("item == null");
        }
        throw new IntegerListOutOfBountException("index > size");
    }

    @Override
    public Integer set(int index, Integer item) {
        if(item != null && index < size+1){
            integerList[index] = item;
            return integerList[index];
        }
        if(item == null) {
            throw new IntegerListNullArgumentException("item == null");
        }
        throw new IntegerListOutOfBountException("index > size");
    }

    @Override
    public Integer remove(Integer item) {
        if(item != null && contains(item)){
            for (int i = 0; i < integerList.length; i++) {
                if(integerList[i].equals(item)){
                    removeCell(i);
                    return item;
                }
            }
        }
        if(item == null) {
            throw new IntegerListNullArgumentException("item == null");
        }
        throw new IntegerListNotContainsException(item + " not contains");
    }

    @Override
    public Integer remove(int index) {
        if(index < integerList.length){
            Integer temp = integerList[index];
            removeCell(index);
            return temp;
        }
        throw new IntegerListOutOfBountException("index > size");
    }

    @Override
    public boolean contains(Integer item) {
        if(item != null) {
            return search(item) != null;
        }
        throw new IntegerListNullArgumentException("item == null");
    }

    @Override
    public int indexOf(Integer item) {
        if(item != null && contains(item)) {
            return search(item);
        }
        if(item == null) {
            throw new IntegerListNullArgumentException("item == null");
        }
        throw new IntegerListNotContainsException(item + " not contains");
    }

    @Override
    public int lastIndexOf(Integer item) {
        if(item != null && contains(item)) {
            for (int i = integerList.length-1; i >= 0; i--) {
                if(integerList[i].equals(item)){
                    return i;
                }
            }
        }
        if(item == null) {
            throw new IntegerListNullArgumentException("item == null");
        }
        throw new IntegerListNotContainsException(item + " not contains");
    }

    @Override
    public Integer get(int index) {
        if(index < size+1){
            return integerList[index];
        }
        throw new IntegerListOutOfBountException("index > size");
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if(integerList.length != otherList.size()) return false;
        for (int i = 0; i < integerList.length; i++) {
            if(!integerList[i].equals(otherList.get(i))){
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
        return integerList[0] == null;
    }

    @Override
    public void clear() {
        integerList = new Integer[1];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return integerList;
    }
}