/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NN_algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ademola Adedoyin
 */
public class Nearest_neighbor {
    
    public static void main(String[] args) {
//        The data sets
        String filepath = new File ("src\\Datasets\\cw2DataSet1.csv").getAbsolutePath();
        String filepath2 = new File ("src\\Datasets\\cw2DataSet2.csv").getAbsolutePath();
        String line = null;
        String[] seperator = {};
        int[][] data = new int [2810*2][65];
        int[][] training = {}, testing = {};
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
            Logger.getLogger(Nearest_neighbor.class.getName()).log(Level.SEVERE, null, ex);
        }
                int positive=0, negative=0;
                System.out.println("training " +training[0].length);
                System.out.println("testing "+testing[0].length);
//                Testing for the each test image
                for(int yh=0; yh<testing.length; yh++){
                    Double actual_totaa = 10000.00;
                    int id = 0;
//                    Running a single test image against all the training images
                    for(int wq=0; wq<testing.length;wq++){
                    Double tota = checkDistance(testing[yh], training[wq], testing[wq].length-1);
                    
                    if(tota < actual_totaa){
                        actual_totaa = tota;
                        id = wq;
                        }
                    else{}
                        
                    if(wq == testing.length-1){
//                        Getting if its correct or not , to get an accuracy
                    if(testing[yh][testing[yh].length-1] == training[id][training[id].length-1]){
                        System.out.println(Arrays.toString(training[id]));
                        System.out.println("ID is: "+(yh+1)+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+id+" and the number matching is "+training[id][training[id].length-1] +" and The distance is " + actual_totaa);
                        positive++;
                    }
                        else {
                        System.out.println(Arrays.toString(training[id]));
                        System.out.println("\t\t\tID is: "+(yh+1)+" The number to match is " + testing[yh][testing[yh].length-1] + " ID is: "+id+" and the number matching is "+training[id][training[id].length-1] +" and The distance is " + actual_totaa);
                        negative++;
                    }
                    }
                    
                }
                }
            System.out.println("postive: "+positive);
            System.out.println("\t\t\tnegative: -"+negative);
            System.out.println("Total: " + (positive+negative));
            Double perc = (double) ((positive) * 100 ) / (positive+negative);
            System.out.println("Total percentage: " + perc +"%");
                   
            }
    
//   a function for calculating the distance between each image using the euclidean distance formular
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
