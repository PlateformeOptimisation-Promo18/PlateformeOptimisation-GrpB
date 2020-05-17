package main.model.algorithmes.spea2;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequired;
import main.model.generic.Problem;

import java.util.ArrayList;

public class SPEA2 extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    private int taillePopulation;
    private int tailleArchive;
    private float probaMutation;
    private float probaMutationDesGenes;
    private float probaCroisement;
    private int nombreGeneration;
    private ArrayList<ArrayList<Integer>> listeDesPossibilite;

    /**
     * Constructeur initialisant les propriétés génériques des algos
     * doit être appelé par les constructeurs des classes d'algorithmes
     *
     * @param pb
     * @param stop          objet écouteur arrêt utilisateur
     * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
     */
    public SPEA2(Problem pb, StopRequired stop, String algorithmName) {
        super(pb, stop, algorithmName);
    }


    @Override
    public void launch(Problem pb, InterfaceRandom generator) {

    }
}
