package test.model.algorithmes.fourmis;

import main.model.algorithmes.fourmis.AlgoFourmis;
import main.model.generic.Parameter;
import main.model.generic.StopRequired;
import main.utils.TestRandom;
import main.utils.TrueRandom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Robin LECORVAISIER
 */
class AlgoFourmisTest {


    private List<Parameter> setParamters(int nbMaxAnt,int nbAnts,int nbEleiteAnt,double qEvaporation, double qPheromones, double qMini){
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(nbMaxAnt,"iNbMaxAnts"));
        parameters.add(new Parameter(nbAnts,"iNbAnts"));
        parameters.add(new Parameter(nbEleiteAnt,"iNbEliteAnt"));
        parameters.add(new Parameter(qEvaporation,"dQuantitéPhéromoneEvaporation"));
        parameters.add(new Parameter(qPheromones,"dQuantitéPhéromoneAjout"));
        parameters.add(new Parameter(qMini,"dQuantitéMini"));

        return parameters;
    }

    @Test
    public void test_launch_two_ants_only_case_1_and_better_ant(){
        StopRequired stop = new StopRequired();
        int [][] problem = new int[][]{{0,1},{0,1},{0,1},{0,1},{0,1}};
        ProblemMock problemMock = new ProblemMock(problem);
        AlgoFourmis algoFourmis = new AlgoFourmis(problemMock,stop,"AlgoTest");
        algoFourmis.setParameters(setParamters(2,2,10,0.05,0.1,0.05));

        TestRandom randomGenerator = new TestRandom();

        randomGenerator.setDoubles(new double[]{0.9, 0.9, 0.9, 0.9, 0.9,0.44,0.44,0.46,0.44,0.46});

        algoFourmis.launch(problemMock,randomGenerator);

        SolutionMock fourmiAttenduPremiere = new SolutionMock(problemMock);
        fourmiAttenduPremiere.setValuesVariables(new int[]{0,0,1,0,1});
        fourmiAttenduPremiere.evaluate(problemMock);

        SolutionMock fourmiAttenduSecond = new SolutionMock(problemMock);
        fourmiAttenduSecond.setValuesVariables(new int[]{1,1,1,1,1});
        fourmiAttenduSecond.evaluate(problemMock);


        assertTrue(fourmiAttenduSecond.isDomined(fourmiAttenduPremiere));
        assertEquals(fourmiAttenduPremiere,algoFourmis.getBestSolutions().getSet().get(0));
        assertEquals(fourmiAttenduSecond,algoFourmis.getBestSolutions().getSet().get(1));
    }


}