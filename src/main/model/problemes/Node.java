import java.util.List;

public abstract class Node implements Comparable<Node>{
	
	protected int iIdNode;
	List<Integer> listNexts;
	List<Integer> listPrevious;
	
	public Node() {
		
	}
	
	public int getiIdNode() {
		
	}
	
	protected void setiIdNode(int iIdNode) {
		
	}
	
	protected void setNextNode(int iNumNext) {
		
	}
	
	protected void setPreviousNode(int iNumNext) {
		
	}
	
	protected List<Integer> getCopyListPrevious(){
		
	}
	
	public List<Integer> getCopyListNexts(){
		
	}

	public List<Integer> getListNexts(){
		
	}
	
	public int compareTo(Node o) {
		
	}
	
	public int getNbNexts() {
		
	}
	
	public int getNbPrevious() {
		
	}
	
	public int getNext(int i) {
		
	}
}