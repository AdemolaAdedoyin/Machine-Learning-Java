/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetic_Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ademola Adedoyin
 */
public class TSP {
	public static int maxGenerations = 100;
	public static void main(String[] args) {
		
		// Create cities
            List<Integer> fullcities = new ArrayList<Integer>();
            String filePath = new File("src/testfiles/test6tsp.txt").getAbsolutePath();
            try{
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                String sp[] = {};
                while((line = bufferedReader.readLine()) != null){
                sp = line.trim().split("\\s+");
                fullcities.add(Integer.parseInt(sp[1]));
                fullcities.add(Integer.parseInt(sp[2]));
                }
            
            }
            catch(NumberFormatException  | IOException e){
                System.out.println(e.getMessage());
            }
                long start = System.nanoTime();
                int numCities = fullcities.size()/2;
		City cities[] = new City[numCities];
		
                
		// Loop to create random cities
                int b = 0;
		for (int cityIndex = 0; cityIndex < numCities; cityIndex++) {
			// Add city
                        cities[cityIndex] = new City(fullcities.get(b), fullcities.get(b+1));
                        b+=2;
		}
                    
		// Initial GA
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.001, 0.9, 2, 5);

		// Initialize population
		Population population = ga.initPopulation(cities.length);
                System.out.println(population.size());

		// Evaluate population
		ga.evalPopulation(population, cities);

		Route startRoute = new Route(population.getFittest(0), cities);
		System.out.println("Start Distance: " + startRoute.getDistance());

		// Keep track of current generation
		int generation = 1;
		// Start evolution loop
		while (ga.isTerminationConditionMet(generation, maxGenerations) == false) {
			// Print fittest individual from population
			Route route = new Route(population.getFittest(0), cities);
			System.out.println("G"+generation+" Best distance: " + route.getDistance());

			// Apply crossover
			population = ga.crossoverPopulation(population);

			// Apply mutation
			population = ga.mutatePopulation(population);

			// Evaluate population
			ga.evalPopulation(population, cities);

			// Increment the current generation
			generation++;
		}
		long end = System.nanoTime();
                long accurtime = end - start;
                double seconds = (double)accurtime/1000000000;
		System.out.println("Stopped after " + maxGenerations + " generations.");
		Route route = new Route(population.getFittest(0), cities);
		System.out.println("Best distance: " + route.getDistance());
                System.out.println("Total time taken to calculate " +seconds + " seconds");

	}
}

