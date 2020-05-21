package main.model.problemes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskNode extends Node {
	
	protected List<Alternative> listAlternatives;
	protected int iIdTask;
	protected String sName;
	
	public TaskNode(Scanner sc, GraphProject graph) {
		super();
		sName = sc.next();
		iIdTask = sc.nextInt();
		listAlternatives = new ArrayList<Alternative>();
		for(int i=0; i<sc.nextInt(); i++) {
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
		return "";
	}
	
	public double getCost(int iSelectedTaskNodeAlternative) {
		return 0.0;
	}
	
	public double getDuration(int iSelectedTaskNodeAlternative) {
		return 0.0;
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
		return listAlternatives.size();
	}
}

class ComparatorAlternativeDuration implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		return 0;
	}
}

class ComparatorAlternativeCost implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		return 0;
	}
}