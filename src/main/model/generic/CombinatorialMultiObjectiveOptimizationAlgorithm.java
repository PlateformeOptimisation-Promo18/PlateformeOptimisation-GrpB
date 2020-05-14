package main.model.generic;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.model.generic.Parametre;
import main.model.generic.ParetoFront;
import main.model.generic.Solution;
import main.model.generic.StopRequis;
import main.model.problemes.Probleme;

import main.model.generic.InterfaceRandom;

import java.util.Observer;

public abstract class CombinatorialMultiObjectiveOptimizationAlgorithm implements Observer {

	    protected ObservableList<Solution> listSolutionsObservables;
	    protected ObservableList<Double> perfObservable;
	    protected ObservableList<Double> tempsObservable;
	    protected boolean stopRequired;
	    protected List<Parametre> listParam;
	    protected ParetoFront bestSolutions;

		public CombinatorialMultiObjectiveOptimizationAlgorithm(StopRequis stop){
	    	stopRequired = false;
	    	stop.addObserver(this);

	    	bestSolutions = new ParetoFront();
			listSolutionsObservables = FXCollections.observableList(bestSolutions.getSet());
	    }

	    public abstract void launch(Probleme pb, InterfaceRandom generator);
	    public List<Parametre> getParameters(){
	    	return listParam;
	    }
	    public void setParameters(List<Parametre> list){
	    	this.listParam = list;
	    }
		@Override
		public void update(Observable o, Object objEvent) {
			this.stopRequired = true;
		}
	    public ParetoFront getBestSolutions() {
			return bestSolutions;
		}

}
