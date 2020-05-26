package main.model.algorithmes.fourmis;

import main.model.generic.InterfaceRandom;
import main.model.generic.Problem;
import main.model.generic.Solution;

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

    /**
     *
     * @param fourmis
     * @param random
     */
    public void nouvelleFourmi(Fourmis fourmis, InterfaceRandom random){

    }

    /**
     *Permet de faire s'évaporer les phéromones de la liste tracePheromones. Elle s'effectue après la récompense.
     * Pré-requis : la liste tracePheromones est instanciée.
     * @param quantiteEvaporation : quantité de phéromone qui disparait sur l'ensemble des chemins après chaque itération.
     */
    public void evaporer(double quantiteEvaporation){
        for (double[] tache: tracePheromones) {
            for(int i = 0; i < tache.length; i++){
                tache[i] -= quantiteEvaporation;
            }
        }
    }

    /**
     *Permet de déposer des phéromones sur le chemin impreinté par une fourmis et ainsi de mettre à jour la liste tracePheromone.
     * Pré-requis : la fourmis est passée par l'un des chemins du problème, et elle a été sélectionné comme étant l'une des meilleures solutions.
     * @param problem le probleme sur lequel on cherche des solutions.
     * @param fourmis une des solutions au problème, que l'on veut récompenser car l'une des meilleures.
     * @param quantitePheromone la quantité de phéromone à rajouter sur le chemin.
     */
    public void recompenser(Problem problem, Solution fourmis, double quantitePheromone) {
        boolean[] variablesActives = problem.GetActiveVariable(fourmis);
        int i = 0;

        for (double[] tâche : tracePheromones) {
            while(i < tâche.length) {
                if (variablesActives[i]) {
                    tâche[i] += quantitePheromone;
                    i++;
                }
            }
            i= 0;
        }
    }

    /**
     *Permet d'ajuster les phéromones sur la liste tracePheromones. On cherche ici à ce que chaque tableau
     *  au sein de cette liste (soit un ensemble de choix de chemins), ait la même probabilité totale.
     *Si, lorsque l'on effectue cet ajustement, l'une des probabilités sur les chemins est en dessous de
     * la quantité minimale, alors on lui attribut cette valeur pour ne pas qu'il disparaisse.
     * Pré-requis : la liste tracePheromones est initialisée.
     * @param probaTotale la probabilité totale qu'on souhaite pour chaque tâche.
     * @param quantiteMinimalePheromone la quantité de phéromone que l'on souhaite sur un chemin pour ne pas qu'il disparaisse.
     */
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
