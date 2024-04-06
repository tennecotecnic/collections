package com.prozorov;

import java.util.Arrays;

public class MyArrayList<T extends Object & Comparable<T>> {
    private T [] baseArray;
    private Integer size = 0;
    private boolean isArrayListSorted = false;


    public MyArrayList () {
        baseArray = (T[]) new Object [10];
    }

    public void add (T elementForAdd) {
        if (size < baseArray.length) {
            baseArray [size] = elementForAdd;
            size++;
        } else {
            T [] reSizedArray = (T[]) new Object[(int)(size*1.5 + 1)];
            for (int i = 0; i < baseArray.length; i++) {
                reSizedArray[i] = baseArray[i];
            }
            baseArray = reSizedArray;
            baseArray [size] = elementForAdd;
            size++;
        }
        if (isArrayListSorted) {
            isArrayListSorted = false;
        }
    }


    public void addAll (MyArrayList<T> arrayForAdd) {
        for (int i = 0; i < arrayForAdd.size(); i++) {
            this.add(arrayForAdd.get(i));
        }
        if (isArrayListSorted) {
            isArrayListSorted = false;
        }
    }


    public void add (Integer index, T elementForAdd) {
        if (size == baseArray.length) {
            T [] temporaryArray = (T[]) new Object[(int)(size*1.5 + 1)];
            for(int i = 0; i < index; i++) {
                temporaryArray[i] = baseArray[i];
            }
            temporaryArray[index] = elementForAdd;
            for(int i = index+1; i <= size+1; i++) {
                temporaryArray[i] = baseArray[i-1];
            }
            baseArray = temporaryArray;
            size++;
        } else {
            T [] arrayForAddingWithIndex = (T[]) new Object[baseArray.length];
            for(int i = 0; i < index; i++) {
                arrayForAddingWithIndex[i] = baseArray[i];
            }
            arrayForAddingWithIndex[index] = elementForAdd;
            for(int i = index+1; i <= size+1; i++) {
                arrayForAddingWithIndex[i] = baseArray[i-1];
            }
            baseArray = arrayForAddingWithIndex;
            size++;
        }
        if (isArrayListSorted) {
            isArrayListSorted = false;
        }
    }


    public T get (Integer index) {
        return baseArray[index];
    }


    public void remove (Integer index){
        if (index < size) {
            for (int i = index; i < (size -1); i++) {
                baseArray[i] = baseArray[i + 1];
                baseArray[i + 1] = null;
            }
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public void sort () {
        if (!isArrayListSorted) {
            for(int i = 0; i < size; i++) {
                for (int j = i; j < size; j++) {
                    if ((baseArray[i]).compareTo(baseArray[j])>0) {
                        T tempBuffer = baseArray[i];
                        baseArray[i] = baseArray[j];
                        baseArray[j] = tempBuffer;
                    }
                }
            }
            isArrayListSorted = true;
        }
    }


    public Integer size () {
        return size;
    }


    @Override
    public String toString () {
        T [] arrayForPrintln = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arrayForPrintln[i] = baseArray[i];
        }
        return "MyArrayList " + Arrays.toString(arrayForPrintln);
    }
}