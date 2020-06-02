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
	
	/**
     * Crée un noeud de tache et ses alternatives
     * @param sc : Scanner parcourant le fichier
     * @param gp : GraphProject contenant le noeud
     */
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
	
	/**
     * Renvoie l'identifiant de tache du noeud
     * @return ID de tache
     */
	protected int getiIdTask() {
		return iIdTask;
	}
	
	/**
     * Attribue un indentifiant de tache au noeud
     * @param iIdTask : ID de la tache
     */
	protected void setiIdTask(int iIdTask) {
		this.iIdTask = iIdTask;
	}
	
	/**
     * Renvoie un String décrivant l'ensemble des éléments du noeud
     * @return Descriptif des éléments
     */
	public String toString() {
		String msg = "Name: " + sName + "; IdTask: " + iIdTask + "; ";
		for(int i=0; i<listAlternatives.size(); i++) {
			msg += "Alternative " + (i+1) + ": "+listAlternatives.get(i) + "; ";
		}
		return msg;
	}
	
	/**
     * Renvoie le cout de l'alternative séléctionnée
     * @param iSelectedTaskNodeAlternative : index de l'alternative séléctionnée
     * @return Coût de l'alternative
     */
	public double getCost(int iSelectedTaskNodeAlternative) {
		return listAlternatives.get(iSelectedTaskNodeAlternative).getCost();
	}
	
	/**
     * Renvoie la durée de l'alternative séléctionnée
     * @param iSelectedTaskNodeAlternative : index de l'alternative séléctionnée
     * @return Durée de l'alternative
     */
	public double getDuration(int iSelectedTaskNodeAlternative) {
		return listAlternatives.get(iSelectedTaskNodeAlternative).getDuration();
	}
	
	/**
     * 
     * @return 
     */
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, int iSelectedTaskNodeAlternative) {
		return false;
	}
	
	/**
     * Renvoie la liste des ressources utilisés par l'alternative séléctionnée
     * @param iSelectedTaskNodeAlternative : index de l'alternative séléctionnée
     * @return Liste des ressources
     */
	public List<Resource> getListResourcesofSelectedAlternative(int iSelectedTaskNodeAlternative){
		return listAlternatives.get(iSelectedTaskNodeAlternative).getListResources();
	}
	
	/**
     * 
     * @return 
     */
	public Alternative getAlternativeExtremum(boolean bIsMinCalculated) {
		return null;
	}
	
	/**
     * 
     * @return 
     */
	public boolean isResourcesAvailable(List<Resource> listAvailableResources, boolean bIsMinCalculated) {
		return false;
	}
	
	/**
     * Renvoie le nombre d'alternatives de la tache
     * @return Nombre d'alternatives
     */
	public int getNbAlternatives() {
		return iNbAlternatives;
	}
}

class ComparatorAlternativeDuration implements Comparator<Alternative>{
	/**
     * Compare les durées de deux alternatives
     * @param alt1 : Première alternative à comparer
     * @param alt2 : Seconde alternative à comparer
     * @return Entier décrivant à la relation de superiorité
     */
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
	/**
     * Compare les coûts de deux alternatives
     * @param alt1 : Première alternative à comparer
     * @param alt2 : Seconde alternative à comparer
     * @return Entier décrivant à la relation de superiorité
     */
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