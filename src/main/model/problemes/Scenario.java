package main.model.problemes;

import main.model.generic.InterfaceRandom;
import main.model.generic.Problem;
import main.model.generic.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
     * Cette classe ne devrait plus avoir d'erreurs lorsque les classes suivantes auront été créées :
     * 	- Resource
     *  - ResourcesPlanned
     *  - PlannedNode
     *  - SharedEnvironmentForPlanification
     *  - Node
     *  - OrNode
     *  - TaskNode
     *  
     *  Ligne 51: il faut trouver le nom de la dernière méthode à appeler
     */

public class Scenario extends Solution {

    public Scenario(GraphProject gp) {
        super(gp);
        valuesObjectives = new ArrayList<>(gp.getNbObjectives());
        valuesObjectives.add(0.0);
        valuesObjectives.add(0.0);

        valueVariables = new int[gp.getNbTasks() + gp.getNbOr()];
        // we fill scenario with 0 initially
        Arrays.fill(valueVariables, 0);
    }

    protected void setDuration(double iVal) {
        valuesObjectives.set(0, iVal);
    }

    protected void setCost(double iVal) {
        valuesObjectives.set(1, iVal);
    }

    /**
     * Évalue un scénario : détermine le coût et la durée du chemin correspondant
     * @param gpTest : Le graphe de projet
     */
    public void evaluate(Problem gpTest) {
    	GraphProject gp = (GraphProject) gpTest;
    	//initialisation des listes
    	List<PlannedNode> listNodeToPlan = new LinkedList<>();
    	initializeListNodeToPlan(listNodeToPlan, gp);
    	List<Resource> listAvailableResources = gp.getCopyListInitialResources();
    	
    	PriorityQueue<ResourcesPlanned> listResourcesPlanned = new PriorityQueue<>();
    	SharedEnvironmentForPlanification envir = new SharedEnvironmentForPlanification(listAvailableResources, listResourcesPlanned);
    	
    	
    	while(!listNodeToPlan.isEmpty()) {
    		PlannedNode noeudCourant = searchForNodeWithoutPreviousNodeAndWithAvailableResources(listNodeToPlan, listAvailableResources);
    		if (noeudCourant != null) {
    			Node initialNode = noeudCourant.getInitialNode();
    			if(noeudCourant.getClassInitialNode == OrNode.class) {
    				OrNode orNode = (OrNode) initialNode;
    				int iSelectedOrNodeAlternative = getSelectedOrAlternative(((OrNode) initialNode).getIdOrNode()).getId());
    				int iIdNodeSelectedAlternative = orNode.getNext(iSelectedOrNodeAlternative);
    				removeUnselectedBranch(listNodeToPlan, gp, orNode, iIdNodeSelectedAlternative);
    			} else {
    				if(noeudCourant.getClassInitialNode() == TaskNode.class) {
    					taskProcessing(noeudCourant, envir);
    				}
    			}
    			updateNextNodes(listNodeToPlan, noeudCourant);
    			listNodeToPlan.remove(noeudCourant);
			} else {
				ResourcesPlanned releaseResources = listResourcesPlanned.poll();
				envir.setCurrentDate(releaseResources.getReleaseDate());
				List<Resource> listToRelease = releaseResources.getListResources();
				for(Resource res : listToRelease) {
					listAvailableResources.get(currentResource.getIdResource()).addQuantity(currentResource.getdQuantity());
				}
			}
    	}
    	setDuration(envir.getEndingDate());
    	setCost(envir.getdBranchTotalCost());
    	computeNormalizedObjective(gpTest);
    }

    /*private void taskProcessing(PlannedNode currentNode, SharedEnvironmentForPlanification envir) {}
    private void planResourceTask(Collection<ResourcesPlanned> listResourcesPlanned, List<Resource> listAvailableResources, TaskNode task, int iSelectedTaskNodeAlternative, double dBeginningDate) {}
    private void updateNextNodes(List<PlannedNode> listNodeToPlan, PlannedNode plannedNode) {}
    private void removeUnselectedBranch(List<PlannedNode> listNodeToPlan, GraphProject gp, OrNode orNode, int iIdNodeSelectedAlternative) {}
    private PlannedNode searchForNodeWithoutPreviousNodeAndWithAvailableResources(List<PlannedNode> listNodeToPlan, List<Resource> listAvailableResources) { return null; }
    private void initializeListNodeToPlan(List<PlannedNode> listNodeToPlan, GraphProject pb) {}*/


    @Override
    public void randomSetValues(Problem pb, InterfaceRandom generator) throws Exception {
        // TODO Auto-generated method stub

    }
}
