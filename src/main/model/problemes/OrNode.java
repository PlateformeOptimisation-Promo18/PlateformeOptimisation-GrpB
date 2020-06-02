package main.model.problemes;

import java.util.Scanner;

public class OrNode extends Node {
	
	protected int iIdEndOrNode;
	protected int iIdOrNode;
	
	public OrNode(Scanner sc) {
		super();
		// Attribution de l'ID
		this.setiIdNode(sc.nextInt());
		iIdEndOrNode = sc.nextInt();
	}
	
	protected int getiIdEndOrNode() {
		return iIdEndOrNode;
	}
	
	protected void setiIdEndOrNode(int iIdEndOrNode) {
		this.iIdEndOrNode = iIdEndOrNode;
	}
	
	protected int getiIdOrNode() {
		return iIdOrNode;
	}
	
	protected void setiIdOrNode(int iIdOrNode) {
		this.iIdOrNode = iIdOrNode;
	}
	
	public String toString() {
		return "Id Node: " + this.getiIdNode() + "; Id End Or Node: " + iIdEndOrNode + ";";
	}
}