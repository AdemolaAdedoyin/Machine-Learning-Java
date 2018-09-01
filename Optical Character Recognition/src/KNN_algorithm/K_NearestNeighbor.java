/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KNN_algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ademola Adedoyin
 */
public class K_NearestNeighbor {
    
    static Double KNNtotal, actual_KNN = 0.00;
    static int mode_key = 0;
static double actual_total = Double.MAX_VALUE;
static int positive=0, negative=0;
static int[][] training = {}, testing = {};
static int yh, wq,  KNN_id = 0, KNN_value=0;
    
    public static void main(String[] args) {
//        The data sets
        String filepath = new File ("src\\Datasets\\cw2DataSet2.csv").getAbsolutePath();
        String filepath2 = new File ("src\\Datasets\\cw2DataSet1.csv").getAbsolutePath();
        String line = null;
        String[] seperator = {};
        int[][] data = new int [2810*2][65];
        try {
            //            Reading the datasets and inserting it into a data array
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileReader fileReader2 = new FileReader(filepath2);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                    seperator = line.trim().split(",");
                        for(int z=0; z<data[i].length;z++)
                        {
                            data[i][z] = Integer.parseInt(seperator[z]);
                        }                    
                    i++;
            }
            while((line = bufferedReader2.readLine()) != null) {
                    seperator = line.trim().split(",");
                        for(int z=0; z<data[i].length;z++)
                        {
                            data[i][z] = Integer.parseInt(seperator[z]);
                        }                    
                    i++;
            }
             //             Splitting the data array into 2folds. Testing and training 
            training = new int[data.length/2][data[1].length];
            testing = new int[data.length/2][data[1].length];
                
            int x = 0;
            for(int y=0 ; y<data.length; y+=2){
                    for(int z=0; z<data[y].length;z++)
                    {training[x][z] = data[y][z];}
                    x++;
            }
                x = 0;
            for(int y=1 ; y<data.length; y+=2){
                    for(int z=0; z<data[y].length;z++)
                    {testing[x][z] = data[y][z];}
                x++;
            }  
        } catch (IOException ex) {
            Logger.getLogger(K_NearestNeighbor.class.getName()).log(Level.SEVERE, null, ex);
        }
                //                Testing for the each test image
                for(yh=0; yh<testing.length; yh++){
                    Double actual_totaa = 10000.00;
                    int id = 0;
                    HashMap<Integer, Integer> remaining = new HashMap<>();
                    HashMap<Integer, Integer> remaining_2nd = new HashMap<>();
                    int count;
                    remaining.clear();
                    actual_KNN = 0.00;
                    for(wq=0; wq<testing.length;wq++){
                        //                    Running a single test image against all the training images
                    Double tota = checkDistance(testing[yh], training[wq], testing[wq].length-1);
//                    Storing all the nearest neighbors in an hashmap
                    if(tota < actual_totaa){
                        actual_totaa = tota;
                        id = wq;  
                        remaining.put(id, training[id][training[id].length-1]);
                        }
                    else{   }
                        
                    if(wq == testing.length-1){
                        
                        System.out.println("-------------------------------------\n----------------------------------");
//                        Limiting the K nearest to just 5, it can be less but once its more it removes the rest
                        for(int gh =0; gh<3000; gh++){
                            if(remaining.size()>3){
//                                2, 3 and 4 nearest gives the best accuracy
                                remaining.remove(gh);
                            }
                        }
                        for(Map.Entry<Integer,Integer> entry : remaining.entrySet())
                {
//                    Getting the mode and storing it with the nearest
                    int key = entry.getValue();
                    if(remaining_2nd.containsKey(key))
                    {
                        count = remaining_2nd.get(key);
                        remaining_2nd.remove(key);
                        remaining_2nd.put(key, count+1);
                        count = 0;
                    }
                    else
                    {
                        remaining_2nd.put(key, 1);  
                    }
                }

                        Integer[] ab = new Integer[remaining_2nd.size()];
                        Arrays.copyOf(remaining_2nd.values().toArray(ab), remaining_2nd.size());

                        Arrays.sort(ab);
                        remaining_2nd.entrySet().forEach((entry) -> {
                            if(entry.getValue().equals(ab[ab.length-1] ))
                            {
                                mode_key = entry.getKey();
                            }
                        });
                        
                        ArrayList<Integer> do_Exist = new ArrayList<>();
        
                        remaining.entrySet().forEach((entry) -> {  
                            if(entry.getValue().equals(mode_key)){
                                    do_Exist.add(entry.getKey());
                                }

                        });
//                        Running through the remaining list , but only checking the euclidean distance for the picture 
//                        that appears the most
                        remaining.entrySet().forEach((i) -> {
                            if (do_Exist.contains(i.getKey())) {
                                KNNtotal = checkDistance(testing[yh], training[i.getKey()], testing[i.getKey()].length-1);
                                
                                if(actual_KNN< KNNtotal){
                                actual_KNN = KNNtotal;
                                KNN_id = i.getKey();
                                KNN_value = i.getValue();
                                }
                                else {  }
                            }

                        } );
//                        Getting the accuracy
                        if(testing[yh][testing[yh].length-1] == training[KNN_id][training[KNN_id].length-1]){
                        System.out.println("The location and the number to match " + remaining);
                        System.out.println(Arrays.toString(training[id]));
                        System.out.println("ID is: "+yh+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+KNN_id+" and the number matching is "+KNN_value +" and The distance is " + actual_KNN);
                        positive++;
                        }
                        else{
                        System.out.println("\t\tThe location and the number to match " + remaining);
                        System.out.println("\t\t"+Arrays.toString(training[id]));
                        System.out.println("\t\tID is: "+yh+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+KNN_id+" and the number matching is "+KNN_value +" and The distance is " + actual_KNN);
                        negative++;
                        }
                        
                    }
                    
                }

                }
                
            System.out.println("postive: "+positive);
            System.out.println("\t\tnegative: -"+negative);
            System.out.println("Total: " + (positive+negative));
            Double perc = (double) ((positive) * 100 ) / (positive+negative);
            System.out.println("Total percentage: " + perc +"%");
                   
            }
    
//   checking the Distance with euclidean distance
    public static Double checkDistance(int x[],int y[], int length)
    {
        Double sum = 0.0;
        for(int w=0;w<length;w++)
        {
        Double dis = (Math.pow((x[w]-y[w]), 2));
        sum+=dis;
        }
    return Math.sqrt(sum);
    }
    
    
}
