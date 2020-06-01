package main.model.problemes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alternative{
	
	protected String sName;
	protected List<Double> listValueOfObjectif;
	protected List<Resource> listResources;
	protected int iNbRessources;
	
	public Alternative(Scanner sc, GraphProject graph) {
		sName = sc.next();
		listValueOfObjectif = new ArrayList<Double>();
		listResources = new ArrayList<Resource>();
		for(int i = 0; i<graph.getNbObjectives(); i++) {
			listValueOfObjectif.add(sc.nextDouble());
		}
		this.iNbRessources = sc.nextInt();
		for(int i = 0; i<iNbRessources; i++) {
			addResources(new Resource(sc));
		}
	}
	
	public String toString() {
		String msg = "Name: " + sName + "; ";
		for(int i=0; i<listValueOfObjectif.size(); i++) {
			msg += "Objective " + (i+1) + ": " + listValueOfObjectif.get(i) +"; ";
		}
		for(int i=0; i<iNbRessources; i++) {
			msg += "Resource " + listResources.get(i).getiIdResource() + ": " + listResources.get(i).getdQuantity() +"; ";
		}
		return msg;
	}
	
	public String getName() {
		return sName;
	}
	
	public List<Resource> getListResources() {
		return listResources;
	}
	
	public void addResources (Resource resource) {
		listResources.add(resource);
	}
	
	public double getCost() {
		return listValueOfObjectif.get(0);
	}
	
	public double getDuration() {
		return listValueOfObjectif.get(1);
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources) {
		return false;
	}
}