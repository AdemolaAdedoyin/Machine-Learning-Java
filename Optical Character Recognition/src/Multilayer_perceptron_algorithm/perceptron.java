/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multilayer_perceptron_algorithm;


/**
 *
 * @author Ademola Adedoyin
 */
public class perceptron {
    
//    Each perceptron with a start weight, and receives the training set first, and a label which when true adjust the weights
//    but for the test phase, i send false so it uses the weights it learned while training through out the 
//    testing
    
    static double weights0[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron0(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights0[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights0[i] = weights0[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    
    static double weights1[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron1(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights1[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights1[i] = weights1[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights2[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron2(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights2[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights2[i] = weights2[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights3[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron3(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights3[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights3[i] = weights3[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights4[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron4(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights4[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights4[i] = weights4[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights5[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron5(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights5[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights5[i] = weights5[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights6[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron6(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights6[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights6[i] = weights6[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights7[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron7(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights7[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights7[i] = weights7[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights8[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron8(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights8[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights8[i] = weights8[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
    
    static double weights9[] = {0.0002, 0.0008, 0.0007, 0.00068, 0.00091, 0.00018,0.0093, 0.0054, 0.00099, 0.008, 0.0027, 0.0072, 0.0001, 0.00010, 0.00022, 0.0022, 0.0036, 0.00094, 0.00047, 0.0074, 0.020, 0.051, 0.0095, 0.0016, 0.00091, 0.018, 0.092, 0.0026, 0.0039, 0.0023, 0.012, 0.082, 0.0025, 0.0038, 0.0089, 0.087, 0.0013, 0.0015, 0.0031, 0.00066, 0.0067, 0.001, 0.001, 0.0010, 0.00045, 0.0108, 0.0088, 0.058, 0.0074, 0.0005, 0.0010, 0.097, 0.0072, 0.0045, 0.0047, 0.00044, 0.0077, 0.00092, 0.0018, 0.00091, 0.0096, 0.050, 0.0009, 0.00049};
    
    public static double perceptron9(double[] train, double learning_rate, int label, boolean data_or_train)
    {
        double tota = 0.0;
        
        for(int i =0; i<64; i++){
            tota += train[i]*weights9[i];
        }
        tota = 1/ (1 + Math.exp(-tota));
        
        
        double error = label - tota; 
        
        if(data_or_train == true){ 
           for(int i =0; i<64; i++){
            weights9[i] = weights9[i] + (learning_rate * error) * train[i];
            }   
        }
        return tota;
    }
}
