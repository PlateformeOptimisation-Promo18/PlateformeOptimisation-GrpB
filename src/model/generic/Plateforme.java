package model.generic;

import javafx.collections.ObservableList;
import model.algorithmes.Algorithme;
import model.problemes.Probleme;
import model.problemes.TypeDeProbleme;
import model.visualisations.Visualisation;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Plateforme implements Observer {
    private Algorithme algoChoisis;
    private TypeDeProbleme typeDeProblemeChoisis;
    private Probleme problemeChoisis;
    private Visualisation visualisationChoisis;

    private ObservableList<Solution> solutionsObservables;
    private ObservableList<Double> perfObservable;
    private ObservableList<Double> tempsObservable;
    private StopRequis stop;
    private List<Parametre> listParametre;
    //TODO ajouter attribut front de pareto

    public void lancerOptimisation(Algorithme algoChoisis){

    }

    public void lancerComparaison(){

    }

    public void lancerAffichage(Visualisation visualisationChoisis){

    }

    public void stop(){

    }

    public void choixProbleme(){

    }

    public void choixAlgorithme(){

    }

    public void choixVisualisation(){

    }

    public void choixParametrages(){

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
