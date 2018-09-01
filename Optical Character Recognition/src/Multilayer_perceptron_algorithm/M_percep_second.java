/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multilayer_perceptron_algorithm;

//import static Multilayer_perceptron_algorithm.perceptron.perceptron1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ademola Adedoyin
 */
public class M_percep_second {
 
    public static void main(String[] args) {
        //        The data sets
        String filepath2 = new File ("src\\Datasets\\cw2DataSet1.csv").getAbsolutePath();
        String filepath = new File ("src\\Datasets\\cw2DataSet2.csv").getAbsolutePath();
        String line = null;
        String[] seperator = {};
        double[][] data = new double [2810*2][65];
        double[][] training = new double[2810][65], testing = new double[2810][65];
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
                            double a = (double)Integer.parseInt(seperator[z])/16;
                            data[i][z] = a;
                            if(z==64){
                            data[i][z] = Integer.parseInt(seperator[z]);
                            }
                        }                    
                    i++;
            }
            while((line = bufferedReader2.readLine()) != null) {
                    seperator = line.trim().split(",");
                        for(int z=0; z<data[i].length;z++)
                        {
                            double a = (double)Integer.parseInt(seperator[z])/16;
                            data[i][z] = a;
                            if(z==64){
                            data[i][z] = Integer.parseInt(seperator[z]);
                            }
                        }                    
                    i++;
            }
            
//             Splitting the data array into 2folds. Testing and training 
  
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
        }
        
        catch (IOException ex) {
            Logger.getLogger(M_perceptron.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        int iterator = 0;
        int maxecho = 40;
        double learningrate = 1.0;
        double new_learningrate = 1.0;
        int label = 0;
        while(iterator<maxecho)
        {
//            Passing the train set to each perceptron through a loop in an interator.
//            
            for(int i=0; i<training.length;i++){
                if((int)training[i][64] == 0) {label = 1;}
                perceptron.perceptron0(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 1) {label = 1;}
                perceptron.perceptron1(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 2) {label = 1;}
                perceptron.perceptron2(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 3) {label = 1;}
                perceptron.perceptron3(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 4) {label = 1;}
                perceptron.perceptron4(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 5) {label = 1;}
                perceptron.perceptron5(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 6) {label = 1;}
                perceptron.perceptron6(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 7) {label = 1;}
                perceptron.perceptron7(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 8) {label = 1;}
                perceptron.perceptron8(training[i], new_learningrate, label, true); 
                label = 0;
                
                if((int)training[i][64] == 9) {label = 1;}
                perceptron.perceptron9(training[i], new_learningrate, label, true); 
                label = 0;
                
            }
            
            
        iterator++;
        new_learningrate = Double.parseDouble(String.format("%2f", new_learningrate - (learningrate/maxecho)));
        }
//        then running each test image against all the trained perceptron
        int positive = 0, negative = 0;
        double actual_total;
        double total;
        int id;
     
        for(int i = 0; i< testing.length; i++){
        id = 0; 
        total = 0.0;
        actual_total = Double.MIN_VALUE;
        
        total = perceptron.perceptron0(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
            
        actual_total = total;
        id = 0;        }
        
        total = perceptron.perceptron1(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 1;        }
        
        total = perceptron.perceptron2(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 2;        }
        
        total = perceptron.perceptron3(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 3;        }
        
        total = perceptron.perceptron4(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 4;        }
        
        total = perceptron.perceptron5(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 5;        }
        
        total = perceptron.perceptron6(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 6;        }
        
        total = perceptron.perceptron7(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 7;        }
        
        total = perceptron.perceptron8(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 8;        }
        
        total = perceptron.perceptron9(testing[i], new_learningrate, label, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 9;        }
        
        if((int)testing[i][testing[i].length-1] == id)
            {
            System.out.println("The number to match is " + (int)testing[i][testing[i].length-1] + " and the number matching is " + id);
            positive++;
            }
        else{
            System.out.println("\t\t\tThe number to match is " + (int)testing[i][testing[i].length-1] + " and the number matching is " + id);
            negative++;
            }
        
        }
        
        System.out.println("Positive: " +positive);
        System.out.println("Negative " + negative);
        System.out.println("Total: " + (positive+negative));
        Double perc = (double) ((positive) * 100 ) / (positive+negative);
        System.out.println("Total percentage: " + perc +"%");
    }   
}
