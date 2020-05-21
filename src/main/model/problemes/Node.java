package main.model.problemes;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements Comparable<Node>{
	
	protected int iIdNode;
	List<Integer> listNexts;
	List<Integer> listPrevious;
	
	public Node() {
		listNexts = new ArrayList<Integer>();
		listPrevious = new ArrayList<Integer>();
	}
	
	public int getiIdNode() {
		return iIdNode;
	}
	
	protected void setiIdNode(int iIdNode) {
		this.iIdNode = iIdNode;
	}
	
	protected void setNextNode(int iNumNext) {
		listNexts.add(iNumNext);
	}
	
	protected void setPreviousNode(int iNumNext) {
		listPrevious.add(iNumNext);
	}
	
	protected List<Integer> getCopyListPrevious(){
		return null;
	}
	
	public List<Integer> getCopyListNexts(){
		return null;
	}

	public List<Integer> getListNexts(){
		return listNexts;
	}
	
	public int compareTo(Node o) {
		return 0;
	}
	
	public int getNbNexts() {
		return listNexts.size();
	}
	
	public int getNbPrevious() {
		return listPrevious.size();
	}
	
	public int getNext(int i) {
		return listNexts.get(i);
	}
}