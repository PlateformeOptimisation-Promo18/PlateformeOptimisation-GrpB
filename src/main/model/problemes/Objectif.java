package main.model.problemes;

import java.util.Scanner;

public class Objectif {
	
	protected String sName;
	protected double dMaximumValue;
	protected double dMinimalValue;
	
	/**
     * Renvoie un String décrivant l'ensemble des éléments de l'objectif
     * @return Descriptif des éléments
     */
	public String toString() {
		return "Name: " + sName + "; Maximum value: " + dMaximumValue + "; Minimal value: " + dMinimalValue;
	}
	
	/**
     * Crée un objet Objectif
     */
	public Objectif(Scanner sc) {
		this.FLoad(sc);
	}
	
	/**
     * Récupère le nom de l'objectif
     * @param sc : Scanner parcourant le fichier
     */
	protected void FLoad(Scanner sc) {
		// Chargement du nom de l'objectif
		sName = sc.next();
	}
	
	/**
     * Renvoie la valeur maximale possible pour cet objectif
     * @return Valeur max
     */
	protected double getdMaximumValue() {
		return dMaximumValue;
	}
	
	/**
     * Renvoie la valeur minimale possible pour cet objectif
     * @return Valeur min
     */
	protected double getdMinimalValue() {
		return dMinimalValue;
	}
	
	/**
     * Défini une valeur maximale pour cet objectif
     * @param dMaximumValue : Valeur max
     */
	protected void setdMaximumValue(double dMaximumValue) {
		this.dMaximumValue = dMaximumValue;
	}
	
	/**
     * Défini une valeur minimale pour cet objectif
     * @return sMinimalValue : Valeur min
     */
	protected void setdMinimalValue(double dMinimalValue) {
		this.dMinimalValue = dMinimalValue;
	}
}