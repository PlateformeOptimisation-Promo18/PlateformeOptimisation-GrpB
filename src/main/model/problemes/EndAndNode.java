package main.model.problemes;

import java.util.Scanner;

public class EndAndNode extends Node {
		
	protected int iIdBeginAndNode;
		
	public EndAndNode (Scanner sc) {
			
	}
		
	protected int getiIdBeginAndNode() {
		return iIdBeginAndNode;
	}
		
	protected void setiIdBeginAndNode(int iBeginAndNode) {
		this.iIdBeginAndNode = iBeginAndNode;
	}
		
	public String toString() {
		return "Id Begin And Node: " + iIdBeginAndNode + ";";
	}
}