package main.model.problemes;

import java.util.Scanner;

public class EndOrNode extends Node {
		
	protected int iIdBeginOrNode;
		
	public EndOrNode (int IdEndOrNode, int IdBeginOrNode) {
		this.setiIdNode(IdEndOrNode);
		iIdBeginOrNode = IdBeginOrNode;
	}
		
	protected int getiIdBeginOrNode() {
		return iIdBeginOrNode;
	}
		
	protected void setiIdBeginOrNode(int iBeginOrNode) {
		this.iIdBeginOrNode = iBeginOrNode;
	}
		
	public String toString() {
		return "Id Node: " + this.getiIdNode() + "; Id Begin Or Node: " + iIdBeginOrNode + ";";
	}
}