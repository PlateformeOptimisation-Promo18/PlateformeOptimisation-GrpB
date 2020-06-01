package main.model.problemes;

import java.util.List;

public class PlannedNode {
	protected Node initialNode;
	protected double dBeginingDate = 0.0;
	protected double dEndingDate = 0.0;
	protected List <Integer> listIdToPreviousNodes;
	protected SharedEnvironmentForPlanification environment;
	
	public PlannedNode(Node initalNode, SharedEnvironmentForPlanification environment) {
		this.initialNode = initalNode;
		//this.listIdToPreviousNodes = initialNode.listPrevious;
		this.environment = environment; 
	}

	public Node getInitialNode() {
		return initialNode;
	}

	public List<Integer> getListIdToPreviousNodes() {
		return listIdToPreviousNodes;
	}

	public SharedEnvironmentForPlanification getEnvironment() {
		return environment;
	}

	public double getdBeginingDate() {
		return dBeginingDate;
	}

	public void setdBeginingDate(double dBeginingDate) {
		this.dBeginingDate = dBeginingDate;
	}

	public double getdEndingDate() {
		return dEndingDate;
	}

	public void setdEndingDate(double dEndingDate) {
		this.dEndingDate = dEndingDate;
	}
	
	

}
