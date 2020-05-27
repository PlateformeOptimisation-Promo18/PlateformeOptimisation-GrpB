package main.model.algorithmes.fourmis;

import main.model.generic.InterfaceRandom;
import main.model.generic.Problem;
import main.model.generic.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe servant à reproduire les phéromones des fourmis en récompensant les meilleurs fourmis
 * (ajout de phéromone sur le chemin) et en reproduisant l'évaporation des phéromones. Elle sera
 * manipulée par l'algorithme des fourmis.
 * @author jade panchaud
 *
 */

public class Pheromones {

    private double[][] tracePheromones;


    //-----------------GETTER ET SETTER POUR TESTS UNIQUEMENT----------------------------
    public void setTracePheromones(double[][] tracePheromones) {
        this.tracePheromones = tracePheromones;
    }

    public double[][] getTracePheromones() {
        return tracePheromones;
    }
    //------------------------------------------------------------------------------------

    /**
     * Ce constructeur permet d'initialiser le tableau de phéromones.
     * A l'état initial, les phéromones, ou probabilité de passer sur un chemin,
     * est la même entre un nombre n de choix (choix entre 3 chemins : 1/3 de phéromones
     * sur chacun d'entre eux).
     *
     * Pré-requis : avoir un problème initialisé.
     *
     * @param problem le problème où l'on récupère le nombre de variable ainsi que de tâches
     */
    public Pheromones(Problem problem){
        int taille = problem.getTabSizeDomainVariables().length;
        this.tracePheromones = new double[taille][];

        for (int i = 0; i < taille; i++){
            int tailleChoix = problem.getTabSizeDomainVariables()[i];
            double[] choix = new double[tailleChoix];

            for(int j = 0; j < tailleChoix; j++){
                choix[j] = 1/(tailleChoix*1.0);
            }
            this.tracePheromones[i] = choix;
        }
    }

    /**
     *Cette méthode permet d'initialiser une fourmis, alias une solution.
     *
     * Pré-requis : le tableau de traces a été initialisé.
     *
     * @return un objet Fourmi avec le chemin par lequel elle est passée dans le problème selon
     * les phéromones.
     */
    public Fourmi nouvelleFourmi(Problem problem, InterfaceRandom random) {
        Fourmi fourmi = new Fourmi(problem);
        int[] cheminPris = new int[tracePheromones.length];

        for (int i = 0; i < tracePheromones.length; i++) {
            boolean choixFait = false;
            double proba = 0;
            int choixAleatoire = random.nextInt(1);

            for (int j = 0; j < tracePheromones[i].length; j++) {
                proba += tracePheromones[i][j];

                if (!choixFait) {
                    if (choixAleatoire <= proba) {
                        cheminPris[i] = j;
                        choixFait = true;
                    }
                }
            }
        }
            fourmi.setValuesVariables(cheminPris);
            return fourmi;
    }

    /**
     *Permet de faire s'évaporer les phéromones de la liste tracePheromones. Elle s'effectue après la récompense.
     *
     * Pré-requis : la liste tracePheromones est instanciée.
     *
     *  @param quantiteEvaporation : quantité de phéromone qui disparait sur l'ensemble des chemins après chaque itération.
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
     *
     * Pré-requis : la fourmis est passée par l'un des chemins du problème, et elle a été sélectionné comme étant l'une des meilleures solutions.
     *
     *  @param problem le probleme sur lequel on cherche des solutions.
     * @param fourmis une des solutions au problème, que l'on veut récompenser car l'une des meilleures.
     * @param quantitePheromone la quantité de phéromone à rajouter sur le chemin.
     */
    public void recompenser(Problem problem, Solution fourmis, double quantitePheromone) {
        boolean[] variablesActives = problem.GetActiveVariable(fourmis);
        int parcoursVariablesActives = 0;
        int i = 0;

        for (double[] tache : tracePheromones) {
            while(i < tache.length) {
                if (variablesActives[parcoursVariablesActives]) {
                    tache[i] += quantitePheromone;
                }
                    i++;
                    parcoursVariablesActives++;
                }
            i = 0;
            }
        }

    /**
     *Permet d'ajuster les phéromones sur la liste tracePheromones. On cherche ici à ce que chaque tableau
     *  au sein de cette liste (soit un ensemble de choix de chemins), ait la même probabilité totale.
     *Si, lorsque l'on effectue cet ajustement, l'une des probabilités sur les chemins est en dessous de
     * la quantité minimale, alors on lui attribut cette valeur pour ne pas qu'il disparaisse.
     *
     * Pré-requis : la liste tracePheromones est initialisée.
     *
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
