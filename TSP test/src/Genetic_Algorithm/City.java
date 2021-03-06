/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetic_Algorithm;

/**
 *
 * @author Ademola Adedoyin
 */
public class City {
	private int x;
	private int y;

	/**
	 * Initalize a city
	 * 
	 * @param x
	 *            X position of city
	 * @param y
	 *            Y position of city
	 */
	public City(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculate distance from another city
	 * 
	 * 
	 * @param city
	 *            The city to calculate the distance from
	 * @return distance The distance from the given city
	 */
	public double distanceFrom(City city) {
		// Get difference between X and Y
		double X = Math.pow((city.getX() - this.getX()), 2);
		double Y = Math.pow((city.getY() - this.getY()), 2);

		// Calculate shortest path
		double distance = Math.sqrt(Math.abs(X + Y));
		return distance;
	}

	/**
	 * Get x position of city
	 * 
	 * @return x X position of city
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Get y position of city
	 * 
	 * @return y Y position of city
	 */
	public int getY() {
		return this.y;
	}
}

