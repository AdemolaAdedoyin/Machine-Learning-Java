/*
 * Like the name suggest playing ground, where i test code before i copy and paste to the original file
 */
package Nearest_Neighbor_Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Ademola Adedoyin
 */
public class Nearest_Neighbor {
    
    public static void main(String[] args){
        long start = 0;
        String filePath = new File("src/testfiles/test6tsp.txt").getAbsolutePath();
        //creating a hashmap to hold all info on the locations
        HashMap<Integer,List<Integer>> locations = new HashMap<>();
        //creating a hashmap to hold the final locations rearranged to reduce travel
        HashMap<Integer,List<Double>> distance = new HashMap<>();
        String line = null;
        try{
            //reading the file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] seperator = {};
            while((line = bufferedReader.readLine()) != null) {
                 seperator = line.trim().split("\\s+");
                   // creating a temporal list to store the cities and checking it against the locations array so no 2 identical cities will be accepted
                 List<Integer> temporary_cities = new ArrayList<>();
                temporary_cities.add(Integer.parseInt(seperator[1]));
                temporary_cities.add(Integer.parseInt(seperator[2]));
                int cityId = Integer.parseInt(seperator[0]);
                
                if(locations.size() > 0 && !locations.containsValue(temporary_cities))
                {   
                    locations.put(cityId, new ArrayList<>());
                    locations.get(cityId).add(temporary_cities.get(0));
                    locations.get(cityId).add(temporary_cities.get(1));
                }
                else if(locations.isEmpty())
                {
                    locations.put(cityId, new ArrayList<>());
                    locations.get(cityId).add(temporary_cities.get(0));
                    locations.get(cityId).add(temporary_cities.get(1));
                }
            }
            // to start calculating the computative resource time
            start = System.nanoTime();
            //we start the journey at city 1
            int start_location = 1;
            //start location is city 1's x and y axis for return
            int start_location_x = locations.get(1).get(0);
            int start_location_y = locations.get(1).get(1);
            
            //pre set distance from city 1 to city 1 to be 0
            distance.put(start_location, new ArrayList<>());
            distance.get(start_location).add(0.0);
            double endres = 0;
            // infinite loop till all the locations have been calculated
            for(;;)
            {
                //if size remains only 1 then all locations has been mapped except return
                if(locations.size() == 1)
                {
                    double distance_calc = Math.sqrt(Math.pow((locations.get(start_location).get(0) - (start_location_x)), 2) + Math.pow((locations.get(start_location).get(1) - (start_location_y)), 2));
                    distance.put(start_location, new ArrayList<>());
                    distance.get(start_location).add(distance_calc);
                    System.out.println("Shortest distance from city "+start_location+" is city "+1+" with a distance of "+distance_calc);
                    System.out.println("============");
                    //System.out.println(start_location);
                    endres = distance_calc;
                    break;
                }
                //a temp list to hold all the calculated distance from the currenct location
                List<Double> all_dist_temp = new ArrayList<>();
                HashMap<Integer,List<Double>> temp_distance = new HashMap<>();
                //loop through the list of locations mapping nearest neighbour
                for(Map.Entry<Integer,List<Integer>> entry : locations.entrySet())
                {
                    int key = entry.getKey();
                    if(key != start_location)
                    {
                        // Calculate shortest path
                        double deltaXSq = Math.pow((locations.get(start_location).get(0) - locations.get(key).get(0)), 2);
                        double deltaYSq = Math.pow((locations.get(start_location).get(1) - locations.get(key).get(1)), 2);
        		double distance_calc = Math.sqrt(Math.abs(deltaXSq + deltaYSq));
                        all_dist_temp.add(distance_calc);
                        
                        temp_distance.put(key,new ArrayList<>());
                        temp_distance.get(key).add(distance_calc);
                    }
                }
                //sort populated list in desc order
                all_dist_temp.sort(new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        if (((double)o1) < ((double)o2)) {
                            return -1;
                        } else if (((double)o1) > ((double)o2)) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                });
                //get the nearest neighbour to the current location
                for(Map.Entry<Integer,List<Double>> entry : temp_distance.entrySet())
                {
                    if(entry.getValue().get(0).equals(all_dist_temp.get(0)))
                    {
                        System.out.println("Shortest distance from city "+start_location+" is city "+entry.getKey()+" distance is "+entry.getValue().get(0));
                        distance.put(entry.getKey(), new ArrayList<>());
                        distance.get(entry.getKey()).add(entry.getValue().get(0));
                        //remove current location from the list
                        locations.remove(start_location);
                        //set the nearest location as the current city
                        start_location = entry.getKey();
                        
                        
                    }
                }
                System.out.println("==============");
                //break;
            }
            
            //calculate total travel distance
            double total_distance_travelled = 0;
            for(Map.Entry<Integer,List<Double>> entry : distance.entrySet())
            {
                total_distance_travelled += entry.getValue().get(0);
            }
            double total = total_distance_travelled + endres;
            System.out.println("Total Distance Travelled "+ total);
        }
        catch(IOException | NumberFormatException e){
                System.out.println(e.getCause() + "not working");
        }
            long end = System.nanoTime();
            long accurtime = end - start;
            double seconds = (double)accurtime/1000000000;
            System.out.println("Total time taken to run " +seconds + " seconds");
    }
}
