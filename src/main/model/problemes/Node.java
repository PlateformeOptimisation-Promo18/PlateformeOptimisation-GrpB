import java.util.List;

public abstract class Node implements Comparable<Node>{
	
	protected int iIdNode;
	List<Integer> listNexts;
	List<Integer> listPrevious;
	
	public Node() {
		
	}
	
	public int getiIdNode() {
		return iIdNode;
	}
	
	protected void setiIdNode(int iIdNode) {
		this.iIdNode = iIdNode;
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
		return listNexts;
	}
	
	public int compareTo(Node o) {
		
	}
	
	public int getNbNexts() {
		return listNexts.size();
	}
	
	public int getNbPrevious() {
		return listPrevious.size();
	}
	
	public int getNext(int i) {
		return listNexts(i);
	}
}