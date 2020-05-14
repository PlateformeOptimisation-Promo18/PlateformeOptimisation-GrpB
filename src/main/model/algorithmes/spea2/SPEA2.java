package main.model.algorithmes.spea2;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequis;
import main.model.problemes.Probleme;

import java.util.ArrayList;

public class SPEA2 extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    private int taillePopulation;
    private int tailleArchive;
    private float probaMutation;
    private float probaMutationDesGenes;
    private float probaCroisement;
    private int nombreGeneration;
    private ArrayList<ArrayList<Integer>> listeDesPossibilite;

    public SPEA2(StopRequis stop) {
        super(stop);
    }

    @Override
    public void launch(Probleme pb, InterfaceRandom generator) {

    }
}
