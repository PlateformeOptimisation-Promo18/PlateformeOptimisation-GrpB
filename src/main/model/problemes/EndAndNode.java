package main.model.problemes;

import java.util.Scanner;

public class EndAndNode extends Node {
		
	protected int iIdBeginAndNode;
	protected int iIdEndAndNode;
		
	public EndAndNode (int IdEndAndNode, int IdBeginAndNode) {
		iIdBeginAndNode = IdBeginAndNode;
		iIdEndAndNode = IdEndAndNode;
	}
		
	protected int getiIdBeginAndNode() {
		return iIdBeginAndNode;
	}
		
	protected void setiIdBeginAndNode(int iBeginAndNode) {
		this.iIdBeginAndNode = iBeginAndNode;
	}
	
	protected int getiIdEndAndNode() {
		return iIdEndAndNode;
	}
		
	protected void setiIdEndAndNode(int iEndAndNode) {
		this.iIdEndAndNode = iEndAndNode;
	}
		
	public String toString() {
		return "Id Begin And Node: " + iIdBeginAndNode + "; Id End And Node: " + iIdEndAndNode + ";";
	}
}