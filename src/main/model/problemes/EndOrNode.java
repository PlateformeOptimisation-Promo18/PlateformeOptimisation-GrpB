package main.model.problemes;

import java.util.Scanner;

public class EndOrNode extends Node {
		
	protected int iIdBeginOrNode;
	protected int iIdEndOrNode;
		
	public EndOrNode (int IdEndOrNode, int IdBeginOrNode) {
		iIdEndOrNode = IdEndOrNode;
		iIdBeginOrNode = IdBeginOrNode;
	}
		
	protected int getiIdBeginOrNode() {
		return iIdBeginOrNode;
	}
		
	protected void setiIdBeginOrNode(int iBeginOrNode) {
		this.iIdBeginOrNode = iBeginOrNode;
	}
	
	protected int getiIdEndOrNode() {
		return iIdEndOrNode;
	}
		
	protected void setiIdEndOrNode(int iEndOrNode) {
		this.iIdEndOrNode = iEndOrNode;
	}
		
	public String toString() {
		return "Id Begin Or Node: " + iIdBeginOrNode + "; Id End Or Node: " + iIdEndOrNode + ";";
	}
}