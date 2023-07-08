package com.heimtn.skyprospringhw.hwalgoritms1.testsuite;

public class TestSuite {
    public static void main(String[] args){
        Integer[] testArr = new Integer[100000];
        for(int i = 0; i < testArr.length; i++){
            testArr[i] = (int)(Math.random()*255);
        }
        Integer[] testArr1 = testArr.clone();
        Integer[] testArr2 = testArr.clone();

        long start = System.currentTimeMillis();
        sortOne(testArr);
        System.out.println(System.currentTimeMillis() - start);

        long start1 = System.currentTimeMillis();
        sortTwo(testArr1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortTwo(testArr2);
        System.out.println(System.currentTimeMillis() - start2);
    }

    private static void sortOne(Integer[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void sortTwo(Integer[] arr){
        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private static void sortTree(Integer[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] >= temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }
}
