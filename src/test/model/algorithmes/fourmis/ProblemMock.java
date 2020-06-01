package test.model.algorithmes.fourmis;

import main.model.generic.Problem;
import main.model.generic.Solution;

import java.util.Arrays;

/**
 * @author Robin LECORVAISIER et Jade Panchaud
 *
 */
public class ProblemMock implements Problem {


    private int [][] tabInit;

    /**
     * @param tabInit tableau des cas possible du problème
     */
    public ProblemMock(int [][] tabInit) {

        this.tabInit = new int[tabInit.length][];

        for (int i = 0 ; i < tabInit.length ; i++){
            this.tabInit[i] = Arrays.copyOf(tabInit[i],tabInit[i].length);
        }
    }

    /**
     *
     * @return une solution
     */
    @Override
    public Solution getSolution() {
        return new SolutionMock(this);
    }

    /**
     * @param sol la solution à copier
     * @return une copie de la solution
     */
    @Override
    public Solution copySolution(Solution sol) {
        return new SolutionMock(sol);
    }

    /**
     *
     * @return un tableau du nombre de cas possible pour chaque étape
     */
    @Override
    public int[] getTabSizeDomainVariables() {

        int[] returnTab = new int[this.tabInit.length];

        for (int i = 0 ; i < tabInit.length ; i++) {
            returnTab[i] = tabInit[i].length;
        }

        return returnTab;
    }

    @Override
    public Double getMaxObjectif(int i) {
        return null;
    }

    @Override
    public Double getMinObjectif(int i) {
        return null;
    }

    @Override
    public int getNbObjectives() {
        return 0;
    }

    @Override
    public int getNbVariables() {
        return 0;
    }

    @Override
    public boolean[] GetActiveVariable(Solution sol) {

        int[] parcours = sol.getValuesVariables();
        int tailleMax = 0;

        for (int[] etape: tabInit) {
            tailleMax += etape.length;
        }

        boolean[] activeVariable = new boolean[tailleMax];

        int tailleCumule = 0;

        for(int i = 0 ; i < tabInit.length ; i++){
            int index = parcours[i] + tailleCumule;
            tailleCumule += tabInit[i].length;

            activeVariable[index] = true;
        }
        return activeVariable;
    }

    @Override
    public int getTabSizeDomainVariable(int i) throws Exception {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
