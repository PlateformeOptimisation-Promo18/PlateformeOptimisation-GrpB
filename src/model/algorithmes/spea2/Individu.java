package model.algorithmes.spea2;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import model.generic.Solution;

public class Individu extends Solution implements Comparable<Individu>, Observable {

    private  int force;
    private int rawFitness;
    private int fitness;


    public void muter(float probaMutation, float probaMutationDesGenes){
        //TODO :
    }

    public Individu[] croiser(Individu individu){
        //TODO :
        return null;
    }


    @Override
    public void evaluer() {

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
