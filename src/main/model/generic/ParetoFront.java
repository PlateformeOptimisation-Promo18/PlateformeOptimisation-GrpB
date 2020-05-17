package main.model.generic;

import main.model.problemes.Probleme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParetoFront {

    protected double hypervolum = 0.0;
    protected ArrayList<Solution> set;

    public ParetoFront() {

    }

    public ParetoFront(ParetoFront paretoFront) {

    }

    public ArrayList<Solution> getSet(){
        return this.set;
    }

    public String toString() {
        return null;
    }

    public double getHypervolum() {
        return this.hypervolum;
    }

    public void add(Solution sol) {
    }

    public int getNbElements() {
        return this.set.size();
    }

    public void addSolutionIfIsParetoFrontSolution(Solution solutionToAdd) {

    }
    //Teste si une solution en domine une autre
    public static boolean domine(Solution sol1, Solution sol2, Probleme pb) {
        return false;
    }
    //Actualise le front de pareto
    public void updateFront(List<Solution> solutionSet, Probleme pb) {

    }

    public double calculHV(Probleme pb) {
        return 0.0;
    }

    public void remove(Solution sol) {

    }

    public Iterator<Solution> getIteratorSet(){
        return null;
    }


    public void reduceIfNecessary(int nbMaxSol, Probleme pb) {

    }

    private double getDistance(Solution sol1, Solution sol2, Probleme pb) {
        return 0.0;
    }

    private double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Probleme pb) {
        return 0.0;
    }

    private Solution centroide(ArrayList<Solution> cluster, Probleme pb) {
        return null;
    }
}
