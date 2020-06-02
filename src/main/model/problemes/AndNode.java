package main.model.problemes;

import java.util.Scanner;

public class AndNode extends Node {
	
	protected int iIdEndAndNode;
	
	public String toString() {
		return "Id Node: " + this.getiIdNode() + "; Id End And Node: " + iIdEndAndNode + ";";
	}
	
	public AndNode(Scanner sc) {
		super();
		// Attribution de l'ID
		this.setiIdNode(sc.nextInt());
		iIdEndAndNode = sc.nextInt();
	}
	
	protected void setiIdEndAndNode(int iIdEndAndNode) {
		this.iIdEndAndNode = iIdEndAndNode;
	}
	
	protected int getiIdEndAndNode() {
		return iIdEndAndNode;
	}
}