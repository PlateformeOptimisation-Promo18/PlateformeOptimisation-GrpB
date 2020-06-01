package test.model.algorithmes.fourmis;

import main.model.algorithmes.fourmis.Pheromones;
import main.model.generic.Solution;
import main.utils.TestRandom;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PheromonesTest {
    Pheromones pheromones;
    ProblemMock problem;
    Solution fourmi;
    TestRandom generator;

    @BeforeEach
    void setUp(){
        int[][] chemin = {{1}, {1,2}, {1,2,3}};
        problem = new ProblemMock(chemin);
        pheromones = new Pheromones(problem);
        fourmi = new SolutionMock(problem);
        generator = new TestRandom();

    }

    @Test
    void pheromonesTrails_initialisation(){
        double[][] pheromonesTab = {{1}, {1/2., 1/2.}, {1/3., 1/3., 1/3.}};
        Assert.assertArrayEquals(pheromonesTab, pheromones.getTracePheromones());
    }

    @Test
    void new_ant(){
        int[] chemin = new int[]{0,1,2};
        generator.setDoubles(new double[]{0.5, 0.8, 0.667});
        Solution fourmiTest = pheromones.nouvelleFourmi(problem, generator);
        Assert.assertArrayEquals(chemin, fourmiTest.getValuesVariables());
    }

    @Test
    void pheromonesTrails_should_recompense_ant_of_01(){
        double qtePheromone = 0.1;
        pheromones.recompenser(problem, fourmi, qtePheromone);
        double[][] pheromonesTab = {{1 + qtePheromone}, {1/2., 1/2. + qtePheromone}, {1/3., 1/3., 1/3. + qtePheromone}};

        Assert.assertArrayEquals(pheromonesTab, pheromones.getTracePheromones());
    }

    @Test
    void pheromonesTrails_should_evaporate_of_01(){
        double evaporate = 0.1;
        pheromones.evaporer(0.1);
        double[][] pheromonesTab = {{1 - evaporate}, {1/2. - evaporate, 1/2. - evaporate}, {1/3. - evaporate, 1/3. - evaporate, 1/3. - evaporate}};

        Assert.assertArrayEquals(pheromonesTab, pheromones.getTracePheromones());
    }

    @Test
    void total_proba_should_equals_1(){
        pheromones.ajuster(1, 0);
        for (double[] tache: pheromones.getTracePheromones()) {
            double proba = 0;
            for(int i = 0; i < tache.length; i++){
                proba += tache[i];
            }
            assertEquals(1.0, proba);
        }
    }

}