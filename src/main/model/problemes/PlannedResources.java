package main.model.problemes;

import java.util.List;

public class PlannedResources implements Comparable<PlannedResources> {
	
	protected double dLiberationDate;
	protected List<Resource> resourcesList;
	
	public PlannedResources(List <Resource> resourcesList, double dLiberationDate ) {
		this.dLiberationDate = dLiberationDate;
		this.resourcesList = resourcesList;
	}
	
	@Override
	public int compareTo(PlannedResources plannedResourcesToCompare) {
		if(this.dLiberationDate < plannedResourcesToCompare.dLiberationDate) return -1;
		else if(this.dLiberationDate == plannedResourcesToCompare.dLiberationDate) return 0;
		else return 1;
	}

	protected double getDateLiberation() {
		return this.dLiberationDate;
	}

	public List<Resource> getResourcesList() {
		return this.resourcesList;
	}	
}
