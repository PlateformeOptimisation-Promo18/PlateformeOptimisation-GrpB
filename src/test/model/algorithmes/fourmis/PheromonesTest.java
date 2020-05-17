package test.model.algorithmes.fourmis;

import main.model.algorithmes.fourmis.Pheromones;
import main.model.problemes.Probleme;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PheromonesTest {
    Pheromones pheromones;
    @BeforeEach
    void setUp(){
        pheromones = new Pheromones();
        List<double[]> pheromoneTrails = new LinkedList<>();
        double[] tab2 = {0.5,0.5};
        double[] tab3 = {1/3, 1/3, 1/3};
        double[] tab2b = {0.5,0.5};
        pheromoneTrails.add(tab2);
        pheromoneTrails.add(tab3);
        pheromoneTrails.add(tab2b);
        pheromones.setTracePheromones(pheromoneTrails);
    }

    @Test
    void pheromonesTrails_should_have_ant_way_up_of_01(){

    }

    @Test
    void proba_should_equals_1(){
        pheromones.ajuster(1, 0);
        for (double[] tache: pheromones.getTracePheromones()) {
            double proba = 0;
            for(int i = 0; i < tache.length; i++){
                proba += tache[i];
            }
            assertEquals(1.0, proba);
        }
    }

    @Test
    void proba_first_tab_should_evaporate_of_01(){
        List<double[]> testEvaporate = new LinkedList<>();
        double[] tab2 = {0.4,0.4};
        double[] tab3 = {0.233, 0.233, 0.233};
        testEvaporate.add(tab2);
        testEvaporate.add(tab3);
        testEvaporate.add(tab2);

        pheromones.evaporer(0.1);
        assertArrayEquals(testEvaporate.get(0), pheromones.getTracePheromones().get(0));
    }

    @Test
    void proba_second_tab_should_evaporate_of_01(){
        List<double[]> testEvaporate = new LinkedList<>();
        double[] tab2 = {0.4,0.4};
        double[] tab3 = {0.233, 0.233, 0.233};
        testEvaporate.add(tab2);
        testEvaporate.add(tab3);
        testEvaporate.add(tab2);

        pheromones.evaporer(0.1);
        assertArrayEquals(testEvaporate.get(1), pheromones.getTracePheromones().get(1));
    }

    @Test
    void proba_third_tab_should_evaporate_of_01(){
        List<double[]> testEvaporate = new LinkedList<>();
        double[] tab2 = {0.4,0.4};
        double[] tab3 = {0.233, 0.233, 0.233};
        testEvaporate.add(tab2);
        testEvaporate.add(tab3);
        testEvaporate.add(tab2);

        pheromones.evaporer(0.1);
        assertArrayEquals(testEvaporate.get(2), pheromones.getTracePheromones().get(2));
    }

}