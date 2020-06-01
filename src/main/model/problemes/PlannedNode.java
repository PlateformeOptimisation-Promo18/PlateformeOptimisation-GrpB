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
		this.listIdToPreviousNodes = initialNode.listPrevious;
		this.environment = environment; 
	}

	/**
	 * @return le noeud initial
	 */
	public Node getInitialNode() {
		return initialNode;
	}

	/**
	 * @return la liste des noeuds precedents
	 */
	public List<Integer> getListIdToPreviousNodes() {
		return listIdToPreviousNodes;
	}

	/**
	 * @return l environement
	 */
	public SharedEnvironmentForPlanification getEnvironment() {
		return environment;
	}

	/**
	 * @return la date de debut du noeud
	 */
	public double getdBeginingDate() {
		return dBeginingDate;
	}

	/**
	 * @param dBeginingDate
	 */
	public void setdBeginingDate(double dBeginingDate) {
		this.dBeginingDate = dBeginingDate;
	}

	/**
	 * @return la date de fin du noeud
	 */
	public double getdEndingDate() {
		return dEndingDate;
	}

	/**
	 * @param dEndingDate
	 */
	public void setdEndingDate(double dEndingDate) {
		this.dEndingDate = dEndingDate;
	}
}
