package main.model.problemes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskNode extends Node {
	
	protected List<Alternative> listAlternatives;
	protected int iIdTask;
	protected String sName;
	protected int iNbAlternatives;
	
	public TaskNode(Scanner sc, GraphProject graph) {
		super();
		// Chargement du nom de la tache
		this.sName = sc.next();
		this.setiIdNode(sc.nextInt());
		this.iNbAlternatives = sc.nextInt();
		this.listAlternatives = new ArrayList<Alternative>();
		// Chargement des alternatives
		for(int i=0; i<iNbAlternatives; i++) {
			listAlternatives.add(new Alternative(sc, graph));
		}
	}
	
	protected int getiIdTask() {
		return iIdTask;
	}
	
	protected void setiIdTask(int iIdTask) {
		this.iIdTask = iIdTask;
	}
	
	public String toString() {
		String msg = "Name: " + sName + "; IdTask: " + iIdTask + "; ";
		for(int i=0; i<listAlternatives.size(); i++) {
			msg += "Alternative " + (i+1) + ": "+listAlternatives.get(i) + "; ";
		}
		return msg;
	}
	
	public double getCost(int iSelectedTaskNodeAlternative) {
		return listAlternatives.get(iSelectedTaskNodeAlternative).getCost();
	}
	
	public double getDuration(int iSelectedTaskNodeAlternative) {
		return listAlternatives.get(iSelectedTaskNodeAlternative).getDuration();
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, int iSelectedTaskNodeAlternative) {
		return false;
	}
	
	public List<Resource> getListResourcesofSelectedAlternative(int iSelectedTaskNodeAlternative){
		return listAlternatives.get(iSelectedTaskNodeAlternative).getListResources();
	}
	
	public Alternative getAlternativeExtremum(boolean bIsMinCalculated) {
		return null;
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, boolean bIsMinCalculated) {
		return false;
	}
	
	public int getNbAlternatives() {
		return iNbAlternatives;
	}
}

class ComparatorAlternativeDuration implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		if (alt1.getDuration()>alt2.getDuration()) {
			return 1;
		} else if (alt1.getDuration()==alt2.getDuration()) {
			return 0;
		} else {
			return -1;
		}
	}
}

class ComparatorAlternativeCost implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		if (alt1.getCost()>alt2.getCost()) {
			return 1;
		} else if (alt1.getCost()==alt2.getCost()) {
			return 0;
		} else {
			return -1;
		}
	}
}