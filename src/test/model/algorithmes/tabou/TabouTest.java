package test.model.algorithmes.tabou;

import main.model.algorithmes.Tabou;
import main.model.generic.*;
import main.model.problemes.GraphProject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TabouTest {

    private static GraphProject gp;

    @Before
    public void setUp() throws Exception {
        gp = new GraphProject("Graph test");
    }

    @Test
    public void testLaunch() {
        StopRequired stop = new StopRequired();
        Tabou tabou = new Tabou(gp, stop, "Tabou");

        List<Parameter> param = tabou.getParameters();
        param.get(0).setValue(3);
        param.get(1).setValue(3);
        tabou.setParameters(param);

        InterfaceRandom random = new MockRandom();
        tabou.launch(gp,random);

        ParetoFront pareto = tabou.getBestSolutions();
        assertTrue(isEquals(pareto.getHypervolum(), 1.619047619));
    }

    public static boolean isEquals (double d1, double d2) {
        return false;
    }

}