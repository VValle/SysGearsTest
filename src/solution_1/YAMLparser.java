/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author R2-D2
 */
//class for work with YAML file
public class YAMLparser{
    // use library snakeYAML
    //link: https://code.google.com/p/snakeyaml/
    private Yaml yaml;
    private File file = null;
    private String fileName = "Array";
    
    public YAMLparser(String fileName) {
        this.fileName = fileName;
        this.file = new File(this.fileName + ".yml");
        this.yaml = new Yaml();
    }
    public void write(int[] array){
        
        try (Writer writerYaml = new FileWriter(this.file);) {
            //parse our array in YAML format and write it to file
            String output = yaml.dump(array);
            writerYaml.write(output);
            writerYaml.close();
        } catch (IOException ex) {
            System.out.println("Problem with write to file");
        }
       
        
    }
    public int[] read(){        
        //read data from file oad parse it in array
        StringBuffer sb = new StringBuffer();
        try (FileReader reader = new FileReader(this.file)) {
       
            int c;
            while ((c = reader.read()) != -1) {

               sb.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println("Problem with read from file");
        }

        //parse
        Object obj = yaml.load(sb.toString());
        ArrayList<Integer> a = (ArrayList<Integer>) obj; 
        int[] result = new int[a.size()];        
        for(int i = 0; i < result.length; i++){
            result[i] = a.get(i);
        }        
        return result;
    }
}
