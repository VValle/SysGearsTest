/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author R2-D2
 */
public class Solution_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choise = 0;
        int[] array = null;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println(
                      "-----------------------------------------------------------------------------------"
                    + "\nYou can load an existing file, or generate it."
                    + "\nIf you download the wrong file, you will get the wrong result."
                    + "\n 1.Generate array and save to file"
                    + "\n 2.Load array file"
                    + "\n 3.Search unique element"
                    + "\n 0. EXIT \n"
                    + "-----------------------------------------------------------------------------------"
            );
            choise = scan.nextInt();
            switch(choise){
                case 1: 

                    System.out.println("Intput filename without \".yml\"");
                    
                    String filename = scan.next();  
                    
                    YAMLparser yaml = new YAMLparser(filename);                    
                    System.out.println("Input size array: ");
                    MyArray myArray = new MyArray(scan.nextInt());
                    
                    //write array to YAML file
                    yaml.write(myArray.getArray());
                    array = myArray.getArray();
                    break;
                case 2: 
                    System.out.println("Intput filename without \".yml\"");
                    String filenameRead = scan.next();                    
                    YAMLparser yamlRead = new YAMLparser(filenameRead);
                    //read array from YAML file
                    array =  yamlRead.read();
                    break;
                case 3:
                    //find unique element
                    System.out.println("Your array : " + Arrays.toString(array));                    
                    System.out.println("Unique element is : " + Processor.getUniqueElement(array));
                    

            }
        }while(choise != 0);
    }

}
