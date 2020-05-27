package main.model.algorithmes.spea2;

import javafx.beans.InvalidationListener;

import java.util.ArrayList;
import java.util.List;

import model.generic.InterfaceRandom;
import model.generic.Problem;

import main.model.generic.Solution;

/*
 @autor : Simon Marquès
 @create : 09/05/2020
 @update : 31/05/2020
 @version : 1.0
*/

public class Population{
    private int taille;
    private List<Individual> set;

    public Population(int iSize){

        this.set = new ArrayList<Individual>();
    }

    public int getNbIdividual() {
        return this.set.size();
    }

    protected void add(Individual ind){
        this.set.add(ind);
    }

    public void initialise(int iPopulationSize, Problem pb, InterfaceRandom generator) throws Exception{
        int i;
        Solution tabSolution[] = new Solution();
        for(i=0;i<=iPopulationSize;i++){
            Solution staticSolution = pb.GetSolution();
            staticSolution->randomSetValues();
            tabSolution[i] = staticSolution;
        }
    }

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

    public Population crossover(double dCrossoverRate, Problem pb, InterfaceRandom generator) {
        for(Individual individual : this.set) {
            individual.crossoverUniform(individual, pb, generator);
        }
        return this;
    }

    private Individual tireParent(Individual ind1, InterfaceRandom generator){
        return ind1;
    }

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

    public int Individual getNbIndividuals(int i) {

        return set.size(get(i));
    }

    public void clear() {

        set.clear();
    }

    public List<Individual> getIndividualSet(){
        return this.set;
    }

    public void setIndividualSet(List<Individual> set) {
        this.set = set;
    }

    public List<Solution> getAssociatedSolutionSet(){

    }

    public Individual getIndividual(int i) {
        return this.set.get(i);
    }
}
