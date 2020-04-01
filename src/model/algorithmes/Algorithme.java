package model.algorithmes;

import model.Solution;
import javafx.beans.Observable;

import java.util.List;

public abstract class Algorithme {
    private List<Solution> listSolutionsObservables;
    private Observable perfObservable;
    private Observable tempsObservable;

    abstract public void lancer();
    abstract public List<String> obtenirParametres();
//    abstract public
}
