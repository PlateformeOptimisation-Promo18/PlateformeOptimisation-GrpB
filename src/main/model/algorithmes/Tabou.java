package main.model.algorithmes;

import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;
import main.model.generic.StopRequired;
import main.model.generic.Problem;

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
        super(pb, stop, algorithmName);
        
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
    	Solution solutionCurrent = pb.getSolution();
    	try {
			solutionCurrent.randomSetValues(pb, generator);
			
			Set<Solution> listTabou = new HashSet<>(); 
			listTabou.add(solutionCurrent);
			
			
			while((listTabou.size()<iTabouListSize)||(iNbIteration != 0) || !stopRequired){
				
				
				Solution sbestSolution = solutionCurrent;
				
				//cr�ation des voisins pour la solution
				List<Solution> sNeighbours = new ArrayList<>();
				int i;
				for(i=0; i<listParam.get(2).getValue().intValue();i++) {
					Solution sRandomNeighbour = pb.getSolution();
					sRandomNeighbour.randomSetValues(pb, generator);
					sNeighbours.add(sRandomNeighbour);
				}
				
				
				//evaluation des meilleurs voisins
				for (i=0; i<sNeighbours.size();i++) {
					if((sNeighbours.get(i).evaluatePerf(pb))>sbestSolution.evaluatePerf(pb)&&(!listTabou.contains(sNeighbours.get(i)))) {
						
						sbestSolution = sNeighbours.get(i);
						
					}
				}
				
				long lStartTime = System.nanoTime();
				sbestSolution.evaluate(pb);
				double dHyperVolume = sbestSolution.evaluatePerf(pb);
				long lEstimatedTime = System.nanoTime() - lStartTime;
				long lTemps = lEstimatedTime / 1000000;
				evolutionHypervolum.add(dHyperVolume);
				evolutionTime.add(lTemps);
				
				//selection du meilleur voisin t
				bestSolutions.addSolutionIfIsParetoFrontSolution(sbestSolution);
				//insertion du mouvement t dans la liste tabou
				listTabou.add(sbestSolution);
				//nouvelle configuration s = t
				solutionCurrent = sbestSolution;
				
				iNbIteration--;
				
				updateAndSave(listTabou,lTemps);
				
			}
		} catch (Exception e) {
			e.getMessage();
		}	
  	
    }
}
