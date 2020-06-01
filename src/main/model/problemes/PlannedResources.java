package main.model.problemes;

import java.util.List;

public class PlannedResources implements Comparable<PlannedResources> {
	
	public double dLiberationDate;
	protected List<Resource> resourcesList;
	
	public PlannedResources(List <Resource> resourcesList, double dLiberationDate ) {
		this.dLiberationDate = dLiberationDate;
		this.resourcesList = resourcesList;
	}
		
	/**
	 * compare les deux ressources planifiees en fonction de leur date de liberation
	 */
	@Override
	public int compareTo(PlannedResources plannedResourcesToCompare) {
		if(this.dLiberationDate < plannedResourcesToCompare.dLiberationDate) return -1;
		else if(this.dLiberationDate == plannedResourcesToCompare.dLiberationDate) return 0;
		else return 1;
	}

	/**
	 * @return la date de liberation
	 */
	protected double getDateLiberation() {
		return this.dLiberationDate;
	}

	/**
	 * @return la liste de resources 
	 */
	public List<Resource> getResourcesList() {
		return this.resourcesList;
	}	
}
