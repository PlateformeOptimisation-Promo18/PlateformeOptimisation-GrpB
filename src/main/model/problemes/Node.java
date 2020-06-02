package main.model.problemes;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements Comparable<Node>{
	
	protected int iIdNode;
	List<Integer> listNexts;
	List<Integer> listPrevious;
	
	/**
     * Crée un objet noeud
     */
	public Node() {
		// Initialisation des listes
		listNexts = new ArrayList<Integer>();
		listPrevious = new ArrayList<Integer>();
	}
	
	/**
     * Renvoie l'identifiant du noeud
     * @return ID du noeud
     */
	public int getiIdNode() {
		return iIdNode;
	}
	
	/**
     * Attribue un identifiant au noeud
     * @param iIdNode : ID du noeud
     */
	protected void setiIdNode(int iIdNode) {
		this.iIdNode = iIdNode;
	}
	
	/**
     * Ajoute un noeud à la liste des noeuds suivants
     * @param iNumNext : ID du noeud a ajouter
     */
	protected void setNextNode(int iNumNext) {
		listNexts.add(iNumNext);
	}
	
	/**
     * Ajoute un noeud à la liste des noeuds précédents
     * @param iNumNext : ID du noeud a ajouter
     */
	protected void setPreviousNode(int iNumPrev) {
		listPrevious.add(iNumPrev);
	}
	
	/**
     * Renvoie une copie de la liste des noeuds précédents
     * @return Liste d'ID de noeuds
     */
	protected List<Integer> getCopyListPrevious(){
		List lNew = new ArrayList<Integer>();
		for(int i=0; i<listPrevious.size(); i++) {
			lNew.add(listPrevious.get(i));
		}
		return lNew;
	}
	
	/**
     * Renvoie une copie de la liste des noeuds suivants
     * @return Liste de noeuds
     */
	public List<Integer> getCopyListNexts(){
		List lNew = new ArrayList<Integer>();
		for(int i=0; i<listNexts.size(); i++) {
			lNew.add(listNexts.get(i));
		}
		return lNew;
	}

	/**
     * Renvoie la liste des noeuds suivants
     * @return Liste des suivants
     */
	public List<Integer> getListNexts(){
		return listNexts;
	}
	
	/**
     * Compare deux noeuds entre eux en se basant sur leur identifiant
     * @param o : noeud à comparer avec le noeud actuel
     * @return Entier décrivant la relation de supériorité
     */
	public int compareTo(Node o) {
		if (o.getiIdNode()<this.getiIdNode()){
			return 1;
		} else if (o.getiIdNode()==this.getiIdNode()){
			return 0;
		} else {
			return -1;
		}
	}
	
	/**
     * Renvoie la taille de la liste des noeuds suivants
     * @return Taille de la liste
     */
	public int getNbNexts() {
		return listNexts.size();
	}
	
	/**
     * Renvoie la taille de la liste de noeuds précédents
     * @return Taille de la liste
     */
	public int getNbPrevious() {
		return listPrevious.size();
	}
	
	/**
     * Renvoie un noeud parmi les noeuds suivants
     * @param i : index du noeud à récupérer
     * @return Liste des suivants
     */
	public int getNext(int i) {
		return listNexts.get(i);
	}
}