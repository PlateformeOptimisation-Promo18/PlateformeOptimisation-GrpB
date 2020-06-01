package main.model.algorithmes.spea2;


import java.util.ArrayList;
import java.util.List;

import model.generic.InterfaceRandom;
import model.generic.Problem;


/*
 @autor : Simon Marquès et Sophie Pasdeloup
 @create : 09/05/2020
 @update : 31/05/2020
 @version : 1.0
*/

public class Population{
    private int taille;
    private List<Individual> set;

    /**
     * Constructeur de la classe Population
     * @param iSize taille  laquelle la liste d'individu de population est initialisé
     */
    public Population(int iSize){

        this.set = new ArrayList<Individual>();
    }

    /**
     * Retourne le nombre d'individus de la population
     * @return nombre d'individu de la population
     */
    public int getNbIdividual() {
        return this.set.size();
    }

    /**
     * Ajoute à la population un individu
     * @param individual individu à ajouter
     */
    protected void add(Individual ind){
        this.set.add(ind);
    }

    /**
     * Initialise la population
     * @param iPopulationSize nombre d'individu
     * @param pb Problème concerné
     * @param generator Générateur de nombre aléatoire
     */
    public void initialise(int iPopulationSize, Problem pb, InterfaceRandom generator) throws Exception{
        int compteur;
        for(compteur=0;compteur<=iPopulationSize;compteur++){
            Individual ind = new Individual(pb);
            ind.randomSetValue(pb,generator);
            this.set.add(ind);
        }
    }

    /**
     * Evalue chaque individu de la population
     * @param pb Problème concerné
     */
    public void evalue(Problem pb) {
        int compteur;
        for(compteur=0;compteur<taille;i++){
            Individual staticIndividual = set.get(i);
            staticIndividual->setRawFitness(this.iRawFitness);
            staticIndividual->setFitness(this.dFiness);
            staticIndividual->setDensity(this.dDensity);
            staticIndividual->setForce(this.i);
        }
    }

    /**
     * Croisement entre deux parents tirés aléatoirement
     * @param dCrossoverRate Probabilité de croisements des individus
     * @param pb Probléme concerné
     * @param generator Générateur de nombre aléatoire
     * @return la nouvelle population de croisement
     */
    public Population crossover(double dCrossoverRate, Problem pb, InterfaceRandom generator) {
        int iIndexIndividual;
        int iRandom;
        Individual ind1 = new Individu(pb);
        do {
            iIndexIndividual = generator.nextInt(this.set.size());
            iRandom = generator.nextInt(1);
            ind1 = this.set.get(iIndexIndividual);
        }
        while(iRandom > dCrossoverRate);
        Individual ind2 = this.tireParent(ind1, generator);

        ind1.crossoverUniform(ind2, pb, generator);

        return this;
    }

    /**
     * Tire un parent au hazard dans la population différent de ind1 pour faire un croisement
     * @param ind1 premier individu du croisement
     * @param generator de nombre aléatoire
     * @return le 2ème parent pour le crossover
     */
    private Individual tireParent(Individual ind1, InterfaceRandom generator){
        int iIndex;
        Individual ind2 = new Individu();
        do {
            iIndex = generator.nextInt(this.set.size());
            ind2 = this.set.get(iIndex);
        }
        while(ind1.equals(ind2));
        return ind2;
    }

    /**
     * Mute de parent en fonction de la probabilité de mutation, de l'individu
     * et la probabilité de mutation
     * @param childreen Population enfant créé par mutation
     * @param dGeneMutation Probabilité de mutation
     * @param dIndividualMutationRate Probabilité de mutation d'un individu
     * @param pb Problème concerné
     * @param generator Générateur de nombre aléatoire
     */
    public void mutation(Population childreen, double dGeneMutation, double dIndividualMutationRate, Problem pb) {
        for(int i = 0 ; i < childreen.getIndividualSet().size() ; i++) {
            Individual individual = childreen.getIndividual(i);
            int iRandom = generator.nextInt(1);
            if(iRandom < dIndividualMutationRate) {
                for (int j = 0 ; j < this.set.size() ; j++) {
                    iRandom = generator.nextInt(1);
                    if(iRandom < dGeneMutation) {
                        individual.mutation(dGeneMutation, pb, generator);
                    }
                }
            }
        }
    }

    /**
     * Clear l'objet courant
     */
    public void clear() {

        set.clear();
    }

    public List<Individual> getIndividualSet(){

        return this.set;
    }

    public void setIndividualSet(List<Individual> set) {
        this.set = set;
    }

    public Individual getIndividual(int i) {
        return this.set.get(i);
    }
}
