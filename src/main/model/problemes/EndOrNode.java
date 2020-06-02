package main.model.problemes;

import java.util.Scanner;

public class EndOrNode extends Node {
		
	protected int iIdBeginOrNode;
		
	/**
     * Créee un noued de fin de choix et lui attribue un identifiant
     * @param IdEndOrNode : ID du noeud actuel
     * @param IdBeginOrNode : ID du noeud de début du choix
     */
	public EndOrNode (int IdEndOrNode, int IdBeginOrNode) {
		super();
		// Attribution de l'ID
		this.setiIdNode(IdEndOrNode);
		iIdBeginOrNode = IdBeginOrNode;
	}
		
	/**
     * Renvoie l'identifiant du noeud de début du choix
     * @return ID du noeud
     */
	protected int getiIdBeginOrNode() {
		return iIdBeginOrNode;
	}
		
	/**
     * Attribue un identifiant au noeud de début du choix
     * @param iBeginOrNode : ID du noeud
     */
	protected void setiIdBeginOrNode(int iBeginOrNode) {
		this.iIdBeginOrNode = iBeginOrNode;
	}
		
	/**
     * Renvoie un String décrivant l'ensemble des éléments du noeud
     * @return Descriptif des éléments
     */
	public String toString() {
		return "Id Node: " + this.getiIdNode() + "; Id Begin Or Node: " + iIdBeginOrNode + ";";
	}
}