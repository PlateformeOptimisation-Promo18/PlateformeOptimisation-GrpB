package main.model.algorithmes.spea2;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import main.model.generic.InterfaceRandom;
import main.model.generic.Solution;
import main.model.generic.Problem;

public class Individu extends Solution implements Comparable<Individu>, Observable {

    private  int force;
    private int rawFitness;
    private int fitness;

    @Override
    public void evaluate(Problem pb) {

    }

    @Override
    public void randomSetValues(Problem pb, InterfaceRandom generator) throws Exception {

    }

    public Individu(Solution sol) {
        super(sol);
    }

    public void muter(float probaMutation, float probaMutationDesGenes){
        //TODO :
    }

    public Individu[] croiser(Individu individu){
        //TODO :
        return null;
    }

    @Override
    public int compareTo(Individu o) {
        return 0;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }

}
