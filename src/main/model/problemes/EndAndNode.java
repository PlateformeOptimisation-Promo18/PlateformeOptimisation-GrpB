package main.model.problemes;

import java.util.Scanner;

public class EndAndNode extends Node {
		
	protected int iIdBeginAndNode;
		
	public EndAndNode (int IdEndAndNode, int IdBeginAndNode) {
		this.setiIdNode(IdEndAndNode);
		iIdBeginAndNode = IdEndAndNode;
	}
		
	protected int getiIdBeginAndNode() {
		return iIdBeginAndNode;
	}
		
	protected void setiIdBeginAndNode(int iBeginAndNode) {
		this.iIdBeginAndNode = iBeginAndNode;
	}
		
	public String toString() {
		return "Id Node: " + this.getiIdNode() + "; Id Begin And Node: " + iIdBeginAndNode + ";";
	}
}