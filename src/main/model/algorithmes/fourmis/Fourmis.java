package main.model.algorithmes.fourmis;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequis;
import main.model.problemes.Probleme;

public class Fourmis extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    public Fourmis(StopRequis stop) {
        super(stop);
    }

    @Override
    public void launch(Probleme pb, InterfaceRandom generator) {

    }

}
