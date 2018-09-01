/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kmeans_Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ademola Adedoyin
 */
public class Kmeans {
    
    public static void main(String[] args) {
//        The data sets
        String filepath2 = new File ("src\\Datasets\\cw2DataSet1.csv").getAbsolutePath();
        String filepath = new File ("src\\Datasets\\cw2DataSet2.csv").getAbsolutePath();
        String line = null;
        String[] seperator = {};
        int[][] data = new int [2810*2][65];
        int[][] training = new int[2810][65], testing = new int[2810][65];
    //            Reading the datasets and inserting it into a data array
        try {FileReader fileReader = new FileReader(filepath);
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
            Logger.getLogger(Kmeans.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Clustering all the images in the training sets into 10 clusters
        double avg_training[][] = new double [10][training[1].length];
                int count, total, avg = 0, total_count = 0;
                for(int y = 0 ; y<10; y++){
                    count = 0; total = 0; avg = 0; total_count= 0;
                    for(int i = 0; i< training[i].length; i++){
                        count = 0; total = 0; avg = 0; total_count= 0;
                        for(int b = 0; b<training.length; b++){ 
                            total_count++;
                            if((training[b][training[b].length-1]) == y)
                            {
                                count++;
                                total = total + training[b][i];                                
                            }
                            if(b == (training.length-1)){
                                float floated_avg = (float)total/count;
                                avg = total/count;
                                avg_training[y][i] = floated_avg; 
                            }
                        }
                    }
                }
                
                
                int positive=0, negative=0;
//                Running through the test file
                for(int yh=0; yh<testing.length; yh++){
                    Double actual_totaa = 10000.00;
                    int id = 0;
                    for(int wq=0; wq<avg_training.length;wq++){
//                        Running each test image against the clustered average data sets
                    Double tota = checkDistance(testing[yh], avg_training[wq], testing[wq].length-1);
                    if(tota < actual_totaa){
//                        storing the nearest with the id
                        actual_totaa = tota;
                        id = wq;
                        }
                    else{}
                    if(wq == avg_training.length-1){
//                        Checking for accuracy
                    if(testing[yh][testing[yh].length-1] == avg_training[id][training[id].length-1]){
                        System.out.println(Arrays.toString(training[id]));
                        System.out.println("ID is: "+(yh+1)+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+id+" and the number matching is "+ (int) avg_training[id][training[id].length-1] +" and The distance is " + actual_totaa);
                        positive++;
                    }
                        else {
                        System.out.println("\t\t"+Arrays.toString(training[id]));
                        System.out.println("\t\tID is: "+(yh+1)+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+id+" and the number matching is "+avg_training[id][training[id].length-1] +" and The distance is " + actual_totaa);
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
    
   
    public static Double checkDistance(int testing[],double training[], int length)
    {
        Double sum = 0.0;
        for(int w=0;w<length;w++)
        {
        Double dis = (Math.pow((testing[w]-training[w]), 2));
        sum+=dis;
        }
    return Math.sqrt(sum);
    }
    
}
