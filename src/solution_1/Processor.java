/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_1;

/**
 *
 * @author R2-D2
 */
public class Processor {
    //Method for search unique element in array
    //use xor, example:
    // srart number = 0 => 0000
    // array[1,8,1,3,3] => array[0001,1000,0001,0011,0011]
    //0000^0001 = 0001
    //0001^1000 = 1001
    //1001^0001 = 1000
    //1000^0011 = 1011
    //1011^0011 = 1000 =>8 - unique

    public static int getUniqueElement(int[] array){       
        int unique = 0;
        for (int i = 0; i < array.length; i++) {
            unique ^= array[i];            
        }
        return unique;
    }
}
