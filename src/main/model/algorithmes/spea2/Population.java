package main.model.algorithmes.spea2;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;

public class Population implements Observable {

    private ArrayList<Individu> individus;

    public void Union(Population population) {
        individus.addAll(population.individus);
    }

    public Population selection(int nombreSelection) {
        //TODO :
        return null;
    }

    public void evaluerPopulation() {
        //TODO :
    }

    public void CalculerFitness() {
        //TODO :
    }

    public void CalculerRawFitness() {
        //TODO :
    }

    public void CalculerForce() {
        //TODO :
    }

    public void CalculerDensite() {
        //TODO :
    }

    public void croiserPopulation(float probaCroisement){
        // TODO :
    }

    public void muterPopulaiton(float probaMutation, float probaMutaionDesGenes){
        // TODO :
    }


    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
