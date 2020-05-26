package main.model.algorithmes.fourmis;

import main.model.generic.InterfaceRandom;
import main.model.generic.Problem;
import main.model.generic.Solution;

public class Fourmi extends Solution {

    public Fourmi(Solution sol) {
        super(sol);
    }

    public Fourmi(Problem problem){
        super(problem);
    }


    @Override
    public void evaluate(Problem pb) {

    }

    @Override
    public void randomSetValues(Problem pb, InterfaceRandom generator) throws Exception {

    }

}
