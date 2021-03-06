package main.model.algorithmes;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequired;
import main.model.generic.Problem;


public class Glouton extends CombinatorialMultiObjectiveOptimizationAlgorithm {


    /**
     * Constructeur initialisant les propriétés génériques des algos
     * doit être appelé par les constructeurs des classes d'algorithmes
     *
     * @param pb
     * @param stop          objet écouteur arrêt utilisateur
     * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
     */
    public Glouton(Problem pb, StopRequired stop, String algorithmName) {
        super(pb, stop, algorithmName);
    }

    @Override
    public void launch(Problem pb, InterfaceRandom generator) {

    }
}
