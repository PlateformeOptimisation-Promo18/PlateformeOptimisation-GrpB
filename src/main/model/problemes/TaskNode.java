import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskNode extends Node {
	
	protected List<Alternative> listAlternatives;
	protected int iIdTask;
	protected String sName;
	
	public TaskNode(Scanner sc, GraphProject graph) {
		
	}
	
	protected int getiIdTask() {
		return iIdTask;
	}
	
	protected void setiIdTask(int iIdTask) {
		this.iIdTask = iIdTask;
	}
	
	public String toString() {
		
	}
	
	public double getCost(int iSelectedTaskNodeAlternative) {
		
	}
	
	public double getDuration(int iSelectedTaskNodeAlternative) {
		
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, int iSelectedTaskNodeAlternative) {
		
	}
	
	public List<Resource> getListResourcesofSelectedAlternative(int iSelectedTaskNodeAlternative){
		return listAlternatives(iSelectedTaskNodeAlternative);
	}
	
	public Alternative getAlternativeExtremum(boolean bIsMinCalculated) {
		
	}
	
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, boolean bIsMinCalculated) {
		
	}
	
	public int getNbAlternatives() {
		return listAlternatives.size();
	}
}

class ComparatorAlternativeDuration implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		
	}
}

class ComparatorAlternativeCost implements Comparator<Alternative>{
	public int compare(Alternative alt1, Alternative alt2) {
		
	}
}