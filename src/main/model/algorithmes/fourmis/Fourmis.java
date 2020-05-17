package main.model.algorithmes.fourmis;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequis;
import main.model.problemes.Probleme;

public class Fourmis extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    /**
     * Constructeur initialisant les propriétés génériques des algos
     * doit être appelé par les constructeurs des classes d'algorithmes
     *
     * @param pb
     * @param stop          objet écouteur arrêt utilisateur
     * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
     */
    public Fourmis(Probleme pb, StopRequis stop, String algorithmName) {
        super(pb, stop, algorithmName);
    }

    @Override
    public void launch(Probleme probleme, InterfaceRandom generator) {

    }
}
