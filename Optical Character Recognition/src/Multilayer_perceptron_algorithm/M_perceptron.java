/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multilayer_perceptron_algorithm;

//import static Multilayer_perceptron_algorithm.perceptron.perceptron1;
import Multilayer_perceptron_algorithm.perceptron;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ademola Adedoyin
 */
public class M_perceptron {
 
    public static void main(String[] args) {
        // TODO code application logic here
        String filepath2 = new File ("src\\Datasets\\cw2DataSet1.csv").getAbsolutePath();
        String filepath = new File ("src\\Datasets\\cw2DataSet2.csv").getAbsolutePath();
        String line = null;
//        List
        String[] seperator = {};
        int[][] data = new int [2810*2][65];
        DecimalFormat df = new DecimalFormat("#.###");
//        int[][] training = {}, testing = {};
        double[][] training = new double[2810][65], testing = new double[2810][65];
        try {
            FileReader fileReader = new FileReader(filepath2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileReader fileReader2 = new FileReader(filepath);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                    seperator = line.trim().split(",");
//                        for(int z=0; z<data[i].length;z++)
//                        {
//                            data[i][z] = Integer.parseInt(seperator[z]);
//                            
//                        }   
                        for(int z = 0; z<training[i].length; z++){
                            double a = (double)Integer.parseInt(seperator[z])/16;
                            training[i][z] = a;
                            if(z==64){
                            training[i][z] = Integer.parseInt(seperator[z]);
                            }
                        }
                    i++;
            }
            i = 0;
            while((line = bufferedReader2.readLine()) != null) {
                    seperator = line.trim().split(",");
//                        for(int z=0; z<data[i].length;z++)
//                        {
//                            data[i][z] = Integer.parseInt(seperator[z]);
//                        } 
                        
                        for(int z = 0; z<training[i].length; z++){
                            double a = (double)Integer.parseInt(seperator[z])/16;
                            testing[i][z] = a;
                            if(z==64){
                            testing[i][z] = Integer.parseInt(seperator[z]);
                            }
                        }
                    i++;
            }
}
        catch (IOException ex) {
            Logger.getLogger(M_perceptron.class.getName()).log(Level.SEVERE, null, ex);
        }
        double a = 1.2345;
        double d = Double.parseDouble(df.format(a));
//        System.out.println(d);
        int iterator = 0;
        int maxecho = 49;
        double learningrate = 1.0;
        double new_learningrate = 1.0;
        int error_rate = 0;
        while(iterator<maxecho)
        {
            for(int i=0; i<training.length;i++){
//                System.out.println((int)training[i][64]);
                if((int)training[i][64] == 0) {error_rate = 1;}
                perceptron.perceptron0(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 1) {error_rate = 1;}
                perceptron.perceptron1(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 2) {error_rate = 1;}
                perceptron.perceptron2(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 3) {error_rate = 1;}
                perceptron.perceptron3(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 4) {error_rate = 1;}
                perceptron.perceptron4(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 5) {error_rate = 1;}
                perceptron.perceptron5(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 6) {error_rate = 1;}
                perceptron.perceptron6(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 7) {error_rate = 1;}
                perceptron.perceptron7(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 8) {error_rate = 1;}
                perceptron.perceptron8(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
                if((int)training[i][64] == 9) {error_rate = 1;}
                perceptron.perceptron9(training[i], new_learningrate, error_rate, true); 
                error_rate = 0;
                
            }
            
            
        iterator++;
        new_learningrate = Double.parseDouble(String.format("%2f", new_learningrate - (learningrate/maxecho)));
//        new_learningrate = new_learningrate - (learningrate/maxecho);
//        System.out.println(new_learningrate);
        }
        int positive = 0, negative = 0;
        double actual_total;
        double total;
        int id;
     
        for(int i = 0; i< testing.length; i++){
        id = 0; 
        total = 0.0;
        actual_total = Double.MIN_VALUE;
        
        total = perceptron.perceptron0(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
            
        actual_total = total;
        id = 0;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron1(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 1;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron2(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 2;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron3(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 3;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron4(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 4;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron5(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 5;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron6(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 6;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron7(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 7;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron8(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 8;
//        System.out.println(total + " and id is " + id);
        }
        
        total = perceptron.perceptron9(testing[i], new_learningrate, error_rate, false);
        if( (total > actual_total) && !(total > 1)){
        actual_total = total;
        id = 9;
//        System.out.println(total + " and id is " + id);
        }
        
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
