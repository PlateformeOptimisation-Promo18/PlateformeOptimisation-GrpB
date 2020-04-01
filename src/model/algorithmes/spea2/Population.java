package model.algorithmes.spea2;

import java.util.ArrayList;

public class Population {

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

    public void CalculerDensité() {
        //TODO :
    }


}
