package main.model.problemes;

import java.util.List;
import java.util.Scanner;

public class Alternative{
	
	protected String sName;
	protected List<Double> listValueOfObjectif;
	protected List<Resource> listResources;
	
	public Alternative(Scanner sc, GraphProject graph) {
		
	}
	
	public String toString() {
		return "";
	}
	
	public String getName() {
		return "";
	}
	
	public List<Resource> getListResources() {
		return listResources;
	}
	
	public void addResources (Resource resource) {
		
	}
	
	public double getCost() {
		return 0.0;
	}
	
	public double getDuration() {
		return 0.0;
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources) {
		return false;
	}
}