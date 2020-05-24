package main.model.problemes;

import java.util.Scanner;

public class AndNode extends Node {
	
	protected int iIdAndNode;
	protected int iIdEndAndNode;
	
	public String toString() {
		return "Id And Node: " + iIdAndNode + "; Id End And Node: " + iIdEndAndNode + ";";
	}
	
	public AndNode(Scanner sc) {
		iIdAndNode = sc.nextInt();
		iIdEndAndNode = sc.nextInt();
	}
	
	protected void setiIdEndAndNode(int iIdEndAndNode) {
		this.iIdEndAndNode = iIdEndAndNode;
	}
	
	protected void setiIdAndNode(int iIdAndNode) {
		this.iIdAndNode = iIdAndNode;
	}
	
	protected int getiIdAndNode() {
		return iIdAndNode;
	}
	
	protected int getiIdEndAndNode() {
		return iIdEndAndNode;
	}
}