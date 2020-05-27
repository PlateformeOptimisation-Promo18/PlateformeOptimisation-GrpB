package test.model.algorithmes.fourmis;

import main.model.algorithmes.fourmis.AlgoFourmis;
import main.model.generic.Parameter;
import main.model.generic.StopRequired;
import main.utils.TrueRandom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgoFourmisTest {


    private List<Parameter> setParamters(){
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(100,"iNbMaxAnts"));
        parameters.add(new Parameter(10,"iNbAnts"));
        parameters.add(new Parameter(10,"iNbEliteAnt"));
        parameters.add(new Parameter(0.1,"dQuantitéPhéromoneEvaporation"));
        parameters.add(new Parameter(0.05,"dQuantitéPhéromoneAjout"));
        parameters.add(new Parameter(0.05,"dQuantitéMini"));

        return parameters;
    }

    @Test
    public void test_launch(){
        StopRequired stop = new StopRequired();
        int [][] problem = new int[][]{{0,1},{0,1},{0,1},{0,1},{0,1}};
        ProblemMock problemMock = new ProblemMock(problem);
        AlgoFourmis algoFourmis = new AlgoFourmis(problemMock,stop,"AlgoTest");
        algoFourmis.setParameters(setParamters());

        algoFourmis.launch(problemMock,new TrueRandom());

        assertEquals(10,algoFourmis.getBestSolutions().getNbElements());

    }


}