package main.model.algorithmes;

import main.model.generic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tabou extends CombinatorialMultiObjectiveOptimizationAlgorithm {


	private static final int NB_IERATION_MAX = 100;
	private static final int NB_NEIGHBOUR = 10;
	private static final int SIZE_TABOU_LIST = 100;	
	
    /**
     * Constructeur initialisant les propriétés génériques des algos
     * doit être appelé par les constructeurs des classes d'algorithmes
     *
     * @param pb
     * @param stop          objet écouteur arrêt utilisateur
     * @param algorithmName nom de l'algorithme pour l'affichage et la sauveguarde des résulats
     */
    public Tabou(Problem pb, StopRequired stop, String algorithmName) {
        super(pb, stop, "Tabou");
        
        Parameter nbIterationMax = new Parameter(NB_IERATION_MAX, "Nombre d'it�ration max");
        this.listParam.add(nbIterationMax);
        
        Parameter tabouListSize = new Parameter(SIZE_TABOU_LIST, "Taille de la liste Tabou");
        this.listParam.add(tabouListSize);
        
        Parameter nbNeighbour = new Parameter(NB_NEIGHBOUR, "Nombre de voisins par solution");
        this.listParam.add(nbNeighbour);
       
    }

    @Override
    public void launch(Problem pb, InterfaceRandom generator) {
    	int iNbIteration = listParam.get(0).getValue().intValue();
    	int iTabouListSize = listParam.get(1).getValue().intValue();
    	Solution sSolutionCurrent = pb.getSolution();

    	try {
			sSolutionCurrent.randomSetValues(pb, generator);}
    	catch (Exception e) {
			e.getMessage();
		}
			Set<Solution> listTabou = new HashSet<>();
			
			while((listTabou.size()<iTabouListSize)||(iNbIteration != 0) || !stopRequired){
				

				long lStartTime = System.nanoTime();
				sSolutionCurrent.evaluate(pb);
				evolutionHypervolum.add(sSolutionCurrent.evaluatePerf(pb));
				bestSolutions.addSolutionIfIsParetoFrontSolution(sSolutionCurrent);
				listTabou.add(sSolutionCurrent);

				//cr�ation des voisins pour la solution
				List<Solution> sNeighbours = new ArrayList<>();
				int i;
				for(i=0; i<listParam.get(2).getValue().intValue();i++) {
					Solution sRandomNeighbour = pb.getSolution();
					try {
						sRandomNeighbour.randomSetValues(pb, generator);
					} catch (Exception e) {
						e.getMessage();
					}
					sNeighbours.add(sRandomNeighbour);
				}
				
				Solution sBestSolution = sSolutionCurrent;
				//evaluation des meilleurs voisins
				for (i=0; i<sNeighbours.size();i++) {
					if((sNeighbours.get(i).evaluatePerf(pb))>sBestSolution.evaluatePerf(pb)&&(!listTabou.contains(sNeighbours.get(i)))) {

						sBestSolution = sNeighbours.get(i);
					}
				}
				long lTemps = (System.nanoTime() - lStartTime) / 1000000;
				evolutionTime.add(lTemps);


				//selection du meilleur voisin t
				bestSolutions.addSolutionIfIsParetoFrontSolution(sBestSolution);
				//insertion du mouvement t dans la liste tabou
				listTabou.add(sBestSolution);
				//nouvelle configuration s = t
				sSolutionCurrent = sBestSolution;

				List<Solution> newSolution = new ArrayList<>();
				newSolution.add(sBestSolution);
				
				iNbIteration--;

				try {
					updateAndSave(newSolution,lTemps);
				} catch (IOException e) {
					e.getMessage();
				}

			}

  	
    }
}
