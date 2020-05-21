package main.model.problemes;

import java.util.Scanner;

public class OrNode extends Node {
	
	protected int iIdEndOrNode;
	protected int iIdOrNode;
	
	public OrNode(Scanner sc) {
		iIdOrNode = sc.nextInt();
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
		this.iIdEndOrNode = iIdOrNode;
	}
	
	public String toString() {
		return "";
	}
}