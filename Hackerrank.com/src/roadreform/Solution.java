package roadreform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		try{
			final BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			
			
			String[] firstLine = br.readLine().split(" ");
			
			final int numOfCities = Integer.parseInt(firstLine[0]);
			final int numOfRoads = Integer.parseInt(firstLine[1]);
			
			List<City> cities = new ArrayList<City>();
			
			for (int i = 1; i <= numOfCities; i++) {
				cities.add(new City(i, numOfCities));
			}
			
			List<Road> roads = new ArrayList<Road>();
			
			for (int i = 0; i < numOfRoads; i++) {
				
				String [] line = br.readLine().split(" ");
				
				City from = new City(Integer.parseInt(line[0]), numOfCities);
				City to = new City(Integer.parseInt(line[1]), numOfCities);
				int cost = Integer.parseInt(line[2]);
				
				roads.add(new Road(cost, from, to));
				
			}
			
			String result = run(cities, roads);
			
			System.out.println(result);
			
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	private static String run(List<City> cities, List<Road> roads) {
		
		mapRoads(cities, roads);
		
		return null;
	}

	private static void mapRoads(List<City> cities, List<Road> roads) {
		
		for (City city : cities) {
			
			for (Road road : roads) {
				
				if(road.isLinked(city)){
					city.getRoads().add(road);
				}
			}
		}
	}
	
}
class City{
	
	private int n;
	private boolean start;
	private boolean end;
	private int totalCities;
	private List<Road> roads;
	
	public City(int n, int totalCities) {
		this.n = n;
		this.totalCities=totalCities;
		start = n==1 ? true:false;
		end = n==totalCities ? true:false;
	}

	public int getN() {
		return n;
	}

	public boolean isStart() {
		return start;
	}

	public boolean isEnd() {
		return end;
	}

	public int getTotalCities() {
		return totalCities;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n;
		result = prime * result + totalCities;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (n != other.n)
			return false;
		return true;
	}
	
	
}
class Road {
	
	private int cost;
	private List<City> cities;
	
	public Road(int cost, City from, City to) {
		this.cost = cost;
		cities = new ArrayList<City>();
		cities.add(to);
		cities.add(from);
	}
	public int getCost() {
		return cost;
	}
	public List<City> getCities() {
		return cities;
	}
	
	public boolean isLinked(City city){
		return cities.contains(city);
	}
	
}


