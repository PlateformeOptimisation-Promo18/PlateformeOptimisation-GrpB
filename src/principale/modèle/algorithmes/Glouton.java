package model.algorithms.Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.model.generic.StopRequired;
import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.Parameter;
import main.model.generic.Problem;
import main.model.generic.Solution;

/**
 *	@author Yannick et Remi
 *
 *	@param pb
 *  @param stop : objet écouteur arrêt utilisateur
 *  
 *  @return la méthode va retouner la meilleure solution qui à était tiré en les comparents
 * 
 *  @version 1.0
 *
 */

public class RandomSearchAlgo extends CombinatorialMultiObjectiveOptimizationAlgorithm {
	private static final int NB_ITERATION_MAX = 10;
	
	public RandomSearchAlgo(Problem pb, StopRequired stop) {
		super(pb, stop, "RandomSearch");
		Parameter nbIterationMax = new Parameter(NB_ITERATION_MAX, "nb iteration max");
		listParam.add(nbIterationMax);
	}
	
	@Override
	public void launch( Problem probleme,InterfaceRandom generator) {

		int iNbIterationMax = listParam.get(0).getValue().intValue();
		try {
			long lStartTime = System.nanoTime();
			
			//bloucle qui va parcourir les differentes cases de la solution
			do {
				Solution solutionCurrent = pb.getSolution();
				solutionCurrent.randomSetValues(pb, generator); //genere une soution aleatoire
				solutionCurrent.evaluatePerf(pb);
				int i = solutionCurrent.getNbVariables();
				do {
					int j;
					j= (int) Math.random()*((solutionCurrent.getNbVariables() - 0)+1); //tire un nombre aleatoire
					ArrayList<Integer> nombres = new ArrayList<Integer>();
					
					//on verifie que le nombre tire aleatoirement n'est pas deja sortie 
					while (nombres.contains(j) && !stopRequired) {
						j= (int) Math.random()*((solutionCurrent.getNbVariables() - 0)+1);
					}
					nombres.add(j);
					int nbVal = solutionCurrent.getValueVariable(j);
					int k = 0;
					double hyp1,hyp2;
					
					// boucle qui compare deux solution et garde la meilleure
					while( k < nbVal && !stopRequired) {
						hyp1 = solutionCurrent.getHypervolum();
						Solution solutionCurrent2 = pb.copySolution(solutionCurrent); // cree une copie de la premiere solution 
						solutionCurrent2.setValuesVariables(j, k); // on change une valeur 
						hyp2 = solutionCurrent2.getHypervolum();
						if(hyp2 > hyp1) {
							solutionCurrent = solutionCurrent2; //on garde la meilleure solution
						}
						k++;
					}
					i--;
				} while ( i != 0 && !stopRequired);
				long lEstimatedTime = System.nanoTime() - lStartTime;
				List<Solution> listNewSolution = new LinkedList<>();
				listNewSolution.add(solutionCurrent);
				updateAndSave(listNewSolution,lEstimatedTime);
				iNbIterationMax--;
			} while (iNbIterationMax > 0 && !stopRequired);
		} catch (Exception e) {
			System.out.println("Erreur lors de l'lagorithme RandomSearch");
			e.printStackTrace();
		}
	}
}
