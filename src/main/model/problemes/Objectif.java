package main.model.problemes;

import java.util.Scanner;

public class Objectif {
	
	protected String sName;
	protected double dMaximumValue;
	protected double dMinimalValue;
	
	public String toString() {
		return "Name: " + sName + "; Maximum value: " + dMaximumValue + "; Minimal value: " + dMinimalValue;
	}
	
	public Objectif(Scanner sc) {
		this.FLoad(sc);
	}
	
	protected void FLoad(Scanner sc) {
		sName = sc.next();
	}
	
	protected double getdMaximumValue() {
		return dMaximumValue;
	}
	
	protected double getdMinimalValue() {
		return dMinimalValue;
	}
	
	protected void setdMaximumValue(double dMaximumValue) {
		this.dMaximumValue = dMaximumValue;
	}
	
	protected void setdMinimalValue(double dMinimalValue) {
		this.dMinimalValue = dMinimalValue;
	}
}