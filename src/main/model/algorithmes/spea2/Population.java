package main.model.algorithmes.spea2;

import javafx.beans.InvalidationListener;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

import javafx.beans.Observable;

import java.util.ArrayList;

public class Population{

    private List<Individu> set;

    public Population(int iSize){

    }

    protected void add(Individual ind){

    }

    public void initialise(int iPopulationSize, Problem pb, InterfaceRandom generator) throws Exception{

    }

    public void evalue(Problem pb) {

    }

    public Population crossover(double dCrossoverRate, Problem pb, InterfaceRandom generator) {

    }

    private Individual tireParent(Individual ind1, InterfaceRandom generator){

    }

    public void mutation(Population childreen, double dGeneMutation, double dIndividualMutationRate, Problem pb) {

    }

    public int Individual getNbIndividuals(int i) {

    }

    public void clear() {

    }

    public List<Individual> getIndividualSet(){

    }

    public void setIndividualSet(List<Individual> set) {

    }

    public List<Solution> getAssociatedSolutionSet(){

    }
}
