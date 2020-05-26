package main.model.algorithmes.fourmis;
import main.model.generic.*;

import java.util.ArrayList;
import java.util.List;

public class AlgoFourmis extends CombinatorialMultiObjectiveOptimizationAlgorithm {

    private static final int NB_MAX_ANT = 1000;
    private static final int NB_ANT = 100;
    private static final int NB_ELITE_ANTS = 100;
    private static final double QUANTITY_ADD = 0.1;
    private static final double QUANTITY_EVAPORATION = 0.05;
    private static final double MINIMAL_QUANTITY = 0.05;

    private Pheromones tracePheromones;


    /**
     * Constructeur initialisant les propriétés génériques des algos
     * doit être appelé par les constructeurs des classes d'algorithmes
     *
     * @param pb
     * @param stop          objet écouteur arrêt utilisateur
     * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
     */
    public AlgoFourmis(Problem pb, StopRequired stop, String algorithmName) {
        super(pb, stop, algorithmName);
        setParameters();
    }

    @Override
    public void launch(Problem pb, InterfaceRandom generator) {

        List<Parameter> listParam = getParameters();

        int iNbMaxAnts = listParam.get(0).getValue().intValue();
        int iNbAnts = listParam.get(1).getValue().intValue();
        int iNbMaxEliteAnts = listParam.get(2).getValue().intValue();
        double dQuantitePheromoneEvaporation = listParam.get(3).getValue().doubleValue();
        double dQuantitePheromoneAjout = listParam.get(4).getValue().doubleValue();
        double dQuantiteMini = listParam.get(5).getValue().doubleValue();

        try{
            long lStartTime = System.nanoTime();
            do {
                for (int i = 0 ; i < iNbAnts ; i++){
                    Fourmi fourmi = tracePheromones.nouvelleFourmi(pb);
                    fourmi.evaluate(pb);
                    bestSolutions.addSolutionIfIsParetoFrontSolution(fourmi);
                }
                bestSolutions.reduceIfNecessary(iNbMaxEliteAnts,pb);
                tracePheromones.evaporer(dQuantitePheromoneEvaporation);

                for (Solution solution : bestSolutions.getSet()) {
                    tracePheromones.recompenser(pb,solution,dQuantitePheromoneAjout);
                }

                tracePheromones.ajuster(1,dQuantiteMini);

                long lEstimatedTime = System.nanoTime() - lStartTime;
                evolutionHypervolum.add(bestSolutions.calculHV(pb));
                evolutionTime.add(lEstimatedTime);
                iNbMaxAnts -= iNbAnts;
            } while (iNbMaxAnts > 0 && !stopRequired);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private void setParameters() {
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter(NB_MAX_ANT,"iNbMaxAnts"));
        parameters.add(new Parameter(NB_ANT,"iNbAnts"));
        parameters.add(new Parameter(NB_ELITE_ANTS,"iNbEliteAnt"));
        parameters.add(new Parameter(QUANTITY_EVAPORATION,"dQuantitéPhéromoneEvaporation"));
        parameters.add(new Parameter(QUANTITY_ADD,"dQuantitéPhéromoneAjout"));
        parameters.add(new Parameter(MINIMAL_QUANTITY,"dQuantitéMini"));

        this.setParameters(parameters);
    }
}
