package main.model.algorithmes.spea2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import model.generic.InterfaceRandom;
import model.generic.ParetoFront;
import model.generic.Problem;

/*
 @autor : Simon Marquès et Sophie Pasdeloup
 @create : 09/05/2020
 @update : 31/05/2020
 @version : 1.0
*/

public class Archive extends Population {

    /**
     * Constructeur de la classe Archive
     * @param isArchiveSize taille de l'archive
     */
    public Archive(int isArchiveSize){

        this.taille = isArchiveSize;
    }

    /**
     * Met à jour l'archive en rajoutant les meilleur d'une nouvelle population
     * @param population Nouvelle population à étudier
     * @param iArchiveSize Taille max de l'archive
     * @param pb Problem concerné
     */
    public void updateArchive(Population population, int iArchiveSize, Problem pb) {
        int iSizePop = population.getIndividualSet().size();
        ParetoFront pareto = new ParetoFront();

        //calcul force
        calculForce(population, iSizePop, pb);

        //calcul rawFitness
        calculRawFitness(population, iSizePop, pb);

        //calcul density
        calculDensity(population, iSizePop, iArchiveSize, pb, pareto);

        //calcul fitness
        for(Individual individual : population.getIndividualSet()) {
            individual.setFitness(individual.getRawFitness() + individual.getDensity());
        }

        Collections.sort(population.getIndividualSet());

        PriorityQueue<Individual> queue = new PriorityQueue<>(iSizePop);
        queue.addAll(set);

        for(int i = 0 ; i<iSizePop && population.getIndividual(i).getFitness() < 1 ; i++) {
            this.set.add(queue.poll());
        }

        if(this.set.size() > iArchiveSize) {
            pareto.reduceIfNecessary(iArchiveSize, pb);
        }else {
            for(int i = 0 ; i < iArchiveSize-this.set.size() ; i++) {
                this.add(queue.poll());
            }
        }
    }

    /**
     * Calcul la force de chaque individu d'une population
     * @param population Population d'individus dont on doit calculer la force
     * @param iSizePop Taille de la population
     * @param pb Problème concerné
     */
    private void calculForce(Population population, int iSizePop, Problem pb) {
        Individual ind1;
        int force = 0;
        for(int i = 0 ; i<iSizePop ; i++) {
            ind1 = population.getIndividual(i);
            for (int j = 0 ; j<iSizePop ; j++) {
                if(ParetoFront.domine(ind1.getSolution(), population.getIndividual(j).getSolution(), pb)) {
                    force += 1;
                }
            }
            ind1.setForce(force);
        }
    }

    /**
     * Calcul le rawFitness de chaque individu d'une population
     * @param population Population d'individus dont on doit calculer le rawFitness
     * @param iSizePop Taille de la population
     * @param pb Problème concerné
     */
    private void calculRawFitness(Population population, int iSizePop, Problem pb) {
        Individual ind1;
        int rawFitness = 0;
        for(int i = 0 ; i<iSizePop ; i++) {
            ind1 = population.getIndividual(i);
            for (int j = 0 ; j<iSizePop ; j++) {
                if(ParetoFront.domine(population.getIndividual(j).getSolution(),ind1.getSolution(), pb)) {
                    rawFitness += ind1.getForce();
                }
            }
            ind1.setRawFitness(rawFitness);
        }
    }

    /**
     * Calcul la densité de chaque individus d'une population
     * @param population Population d'individu dont on doit calculer la densité
     * @param iSizePop Taille de population
     * @param iArchiveSize Taile de l'archive
     * @param pb Porbleme concerné
     * @param pareto Front de pareto
     */
    private void calculDensity(Population population, int iSizePop, int iArchiveSize, Problem pb, ParetoFront pareto) {
        int dKIndividu = (int) Math.sqrt(iSizePop + iArchiveSize);
        PriorityQueue<Individual> test = new PriorityQueue<>();
        for(Individual ind : population.getIndividualSet()) {
            test.add(ind);
        }
        double[] dDistance = new double[iSizePop];
        for (int i = 0 ; i<iSizePop ; i++) {
            for(int j = i ; j < iSizePop ; j++) {
                dDistance[j] = pareto.getDistance(population.getIndividual(i).getSolution(), population.getIndividual(j).getSolution(), pb);
            }
            double dDensity = 1/(dDistance[dKIndividu] + 2);
            population.getIndividual(i).setDensity(dDensity);
        }
    }

    /**
     *
     * @return la configuration de la population
     */
    private List<Individual> getSet(){

        return set;
    }

    /**
     * Mise à jour de la population
     * @param pb
     * @param populationTemp
     */
    private void miseAjourDistancePop(Problem pb, Population populationTemp) {

        set.add(populationTemp);
    }


    /**
     * Enlève les individu en double de l'archive
     */
    public void enleveDoublons(){
        int compteur;
        int i;
        for(compteur=0;compteur<set.size();compteur++){
            elementList = set.get(compteur);
            for(i=0;i<set.size();i++){
                if( elementList == set.get(+1)){
                    set.remove(i);
                }
            }
            i=0;
        }
    }

    /**
     * Selection d'élément dans la population
     * @param population population concerné
     * @param generator
     * @param iPopSize
     * @param iNumkVoisin
     */
    public void selection(Population population, InterfaceRandom generator, int iPopSize, int iNumkVoisin) {
        int compteur;
        for(compteur=0;compteur<taille;compteur++){
            if(this == null){
                this = population;
            }

        }
    }

    /**
     * Selection des parents dans la population courante
     * @param nombreParent indice de où se situe les parents dans la population
     */
    public Population selectionParents(int nombreParent){
        Population popParents = new Population(nombreParent);
        int compteur;
        for(int compteur = 0 ; compteur < this.getIndividualSet().size() ; compteur++) {
            populationParent.add(this.getIndividual(i));
        }
        return populationParent;
    }

    /**
     * Sélection de l'archive
     * @param population population concerné
     */
    public void SelectionArchive(Population population){
        for(int i = 0 ; i < this.set.size() ; i ++) {
            if(this.set.isEmpty()) {
                this.set.set(i, population.getIndividual(i));
            }

        }
    }
}
