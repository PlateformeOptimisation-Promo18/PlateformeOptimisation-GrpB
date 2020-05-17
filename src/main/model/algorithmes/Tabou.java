package main.model.algorithmes;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequis;
import main.model.problemes.Probleme;

public class Tabou extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    public Tabou(StopRequis stop) {
        super(stop);
    }

    @Override
    public void launch(Probleme pb, InterfaceRandom generator) {

    }
}
