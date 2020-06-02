package main.model.problemes;

import java.util.Scanner;

public class Resource implements Cloneable {
	
	protected int iIdResource;
	protected double dQuantity;
	
	/**
     * Renvoie l'identifiant de la ressource
     * @return ID de ressource
     */
	public int getiIdResource() {
		return iIdResource;
	}
	
	/**
     * Renvoie la quantité de la ressource
     * @return Quantité de la ressource
     */
	public double getdQuantity() {
		return dQuantity;
	}
	
	/**
     * Crée un ressource
     * @param sc : Scanner parcourant le fichier
     */
	public Resource(Scanner sc) {
		iIdResource = sc.nextInt();
		dQuantity = sc.nextDouble();
	}
	
	/**
     * Crée une ressource
     * @param sc : Scanner parcourant le fichier
     * @param gp : GraphProject de la ressource
     */
	public Resource(Scanner sc, GraphProject gp) throws Exception {
		
	}
	
	/**
     * Crée une ressource à partir d'une autre ressource
     * @param resource : Ressource à copier
     */
	public Resource(Resource resource) {
		iIdResource = resource.getiIdResource();
		dQuantity = resource.getdQuantity();
	}
	
	/**
     * Réduit la quantité de la ressource
     * @param dQuantity : Quantité à retirer
     */
	public void removeQuantity(double dQuantity) {
		this.dQuantity -= dQuantity;
	}
	
	/**
     * Augmente la quantité de la ressource
     * @param dQuantity : Quantité à ajouter
     */
	public void addQuantity(double dQuantity) {
		this.dQuantity += dQuantity;
	}
	
	/**
     * Clone une ressource
     * @return Clone de la resource
     */
	protected Resource clone() {
		return new Resource(this);
	}
}