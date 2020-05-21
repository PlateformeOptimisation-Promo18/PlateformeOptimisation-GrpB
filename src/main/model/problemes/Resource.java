package main.model.problemes;

import java.util.Scanner;

public class Resource implements Cloneable {
	
	protected int iIdResource;
	protected double dQuantity;
	
	public int getiIdResource() {
		return iIdResource;
	}
	
	public double getdQuantity() {
		return dQuantity;
	}
	
	public Resource(Scanner sc) {
		iIdResource = sc.nextInt();
		dQuantity = sc.nextDouble();
	}
	
	public Resource(Scanner sc, GraphProject gp) throws Exception {
		
	}
	
	public Resource(Resource resource) {
		
	}
	
	public void removeQuantity(double dQuantity) {
		this.dQuantity -= dQuantity;
	}
	
	public void addQuantity(double dQuantity) {
		this.dQuantity += dQuantity;
	}
	
	protected Resource clone() {
		return null;
	}
}