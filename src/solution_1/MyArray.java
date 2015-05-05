/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author R2-D2
 */
//class for create special array
public class MyArray {

    private int size = 0;
    private int[] array;
    
    public MyArray(int size) {
        this.size = checkSize(size);
        this.array = createArray(size);
    }
    //size array should be not a multiple of 2. Check it.
    private int checkSize(int size) {
        if (size % 2 == 0) {
            size += 1;
            System.out.println("Size must be not a multiple of 2. Size = " + size + ".");
        } else {
            System.out.println("Size checked");
        }
        return size;
    }
    //create spesial array
    private int[] createArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();        
        for (int i = 0; i < size - 1; i = i + 2) {
            int number = checkElements(rand.nextInt(),array);            
            array[i] = number;
            array[i + 1] = number;
        }        
        array[array.length - 1] = checkElements(rand.nextInt(), array);
        array = shakeArray(array);
        return array;
    }
    //array should only have 2 identical element. Check it.
    private int checkElements(int number, int[] array){
        Random rand = new Random();
        while (true) {
            String s = Arrays.toString(array);
            //If we already have two such elements => change.
            if (s.contains(", " + number)) {
                number = rand.nextInt();
            } else {
                break;
            }
        }
        return number;
    }
   
    //for more random shake array, swap 2 random elements
    private int[] shakeArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int firstIndex = rand.nextInt(array.length);
            int secondIndex = rand.nextInt(array.length);
            //swap element
            int tmp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = tmp;
        }

        return array;
    }
    //get array
    public int[] getArray() {
        return array;
    }
}
