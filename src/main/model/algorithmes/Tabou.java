package main.model.algorithmes;

import main.model.generic.*;

import java.io.IOException;
import java.util.*;

/**
 * La classe Tabou est utilisé pour rechercher la meilleur solution à un problème
 *
 * @author GARIS Damien
 *
 */
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

        Parameter nbNeighbour = new Parameter(NB_NEIGHBOUR, "Nombre de voisins par solution");
		this.listParam.add(nbNeighbour);

		Parameter nbIterationMax = new Parameter(NB_IERATION_MAX, "Nombre d'it�ration max");
        this.listParam.add(nbIterationMax);
        
        Parameter tabouListSize = new Parameter(SIZE_TABOU_LIST, "Taille de la liste Tabou");
        this.listParam.add(tabouListSize);
        

       
    }

    @Override
    public void launch(Problem pb, InterfaceRandom generator) {
    	int iNbIteration = listParam.get(0).getValue().intValue();
    	int iTabouListSize = listParam.get(1).getValue().intValue();

    	//Solution intiale
    	Solution sSolutionCurrent = pb.getSolution();

    	try {
			sSolutionCurrent.randomSetValues(pb, generator);}
    	catch (Exception e) {
			e.getMessage();
		}
		//Liste Tabou vide
		List<Solution> listTabou = new ArrayList<>();

		listTabou.add(sSolutionCurrent);

    	//Détermine si on continue la recherche de solution
    	while((iNbIteration != 0) || !stopRequired){

    		long lStartTime = System.nanoTime();
    		sSolutionCurrent.evaluate(pb);
    		evolutionHypervolum.add(sSolutionCurrent.evaluatePerf(pb));


    		//création des voisins pour la solution
			List<Solution> sNeighbours = new ArrayList<>();
			int i;
			for(i=0; i<listParam.get(2).getValue().intValue();i++) {
				Solution sRandomNeighbour = pb.copySolution(sSolutionCurrent);
				int[] tCaseValues = pb.getTabSizeDomainVariables();
				int iIndexVariable = generator.nextInt(sSolutionCurrent.getNbVariables());
				int iValue = generator.nextInt(tCaseValues[iIndexVariable]);
				sRandomNeighbour.setValuesVariables(iIndexVariable,iValue );
				sNeighbours.add(sRandomNeighbour);
			}

			Solution sBestSolution = sSolutionCurrent;

			//evaluation des voisins de la solution
			for (i=0; i<sNeighbours.size();i++) {
				//On vérifie si la solution n'existe pas déjà pour ne pas l'évaluer de nouveau
				if (listTabou.contains(sNeighbours.get(i))){
					int[] tCaseValues = pb.getTabSizeDomainVariables();
					int iIndexVariable = generator.nextInt(sSolutionCurrent.getNbVariables());
					int iValue = generator.nextInt(tCaseValues[iIndexVariable]);
					sNeighbours.get(i).setValuesVariables(iIndexVariable,iValue );
				}

				listTabou.add(sNeighbours.get(i));

				if((sNeighbours.get(i).evaluatePerf(pb))>sBestSolution.evaluatePerf(pb)) {
					sBestSolution = sNeighbours.get(i);
				}
			}
			long lTemps = (System.nanoTime() - lStartTime) / 1000000;
			evolutionTime.add(lTemps);

			bestSolutions.addSolutionIfIsParetoFrontSolution(sBestSolution);

			//insertion du meilleur voisin dans la liste tabou
			listTabou.add(sBestSolution);

			if (listTabou.size()>iTabouListSize){
				//supression du dernier element de la liste tabou
				listTabou.remove(listTabou.size()-1);
			}

			//nouvelle configuration, le meilleur voisin devient la solution courante
			sSolutionCurrent = sBestSolution;

			//liste de nouvelles solutions pour la mise à jour et la sauvegarde
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
