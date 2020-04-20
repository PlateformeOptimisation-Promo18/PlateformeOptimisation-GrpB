package model.algorithmes;

import javafx.collections.ObservableList;
import model.generic.Parametre;
import model.generic.Solution;
import javafx.beans.Observable;
import model.problemes.Probleme;

import java.util.HashMap;
import java.util.List;

public abstract class Algorithme {
    private ObservableList<Solution> listSolutionsObservables;
    private Observable perfObservable;
    private Observable tempsObservable;

    abstract public void lancer();
    abstract public List<Parametre> obtenirParametres();
    abstract public List<Parametre> obtenirParametresParDefaut();
    abstract public void parametrer(List<Parametre> saisieUtilisateur);
    abstract public void arreter();
}
