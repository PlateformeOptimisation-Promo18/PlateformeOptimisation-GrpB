package main.model.algorithmes.fourmis;

import main.model.generic.Solution;
import main.model.problemes.Problem;

import java.util.List;

public class Pheromones {

    private List<double[]> tracePheromones;

    public void setTracePheromones(List<double[]> tracePheromones) {
        this.tracePheromones = tracePheromones;
    }

    public List<double[]> getTracePheromones() {
        return tracePheromones;
    }

    //TODO
    public Pheromones(){}

    //TODO
    public void nouvelleFourmi(){}

    //TODO
    public void evaporer(double quantiteEvaporation){
        for (double[] tache: tracePheromones) {
            for(int i = 0; i < tache.length; i++){
                tache[i] -= quantiteEvaporation;
            }
        }
    }

    //TODO
    public void recompenser(Problem problem, Solution fourmis, double quantitePheromone) {
        boolean[] variablesActives = problem.GetActiveVariable(fourmis);
        int i = 0;

        for (double[] d : tracePheromones) {
            if(variablesActives[i]){

            }
        }
    }

    //TODO
    public void ajuster(double probaTotale, double quantiteMinimalePheromone){
        for (double[] tache: tracePheromones) {
            for (double proba: tache) {
                proba = proba/probaTotale;
                if(proba < quantiteMinimalePheromone){
                    proba += (quantiteMinimalePheromone - proba);
                }
            }
        }
    }


}
