package model.algorithmes;

import javafx.collections.ObservableList;
import model.generic.Parametre;
import model.generic.Solution;
import model.generic.StopRequis;
import model.problemes.Probleme;

import java.util.List;
import java.util.Observer;

public abstract class Algorithme implements Observer {
    private ObservableList<Solution> listSolutionsObservables;
    private ObservableList<Double> perfObservable;
    private ObservableList<Double> tempsObservable;
    private StopRequis stop; //Il faut observer cette valeur pour savoir quand il faut arrêter l'algorithme.
    private List<Parametre> listParametre;
    //TODO ajouter attribut front de pareto

    abstract public void lancer(Probleme probleme);

    /**
     * Permet de savoir le nom des paramètres que l'utilisateur doit renseigner.
     *
     * @return une liste de Parametre, dont la valeur numérique est nulle.
     */
    abstract public List<Parametre> obtenirParametres();

    /**
     * Permet de connaître le paramétrage par défaut.
     *
     * @return une liste de Parametre, avec des noms et des valeurs non nulles.
     */
    abstract public List<Parametre> obtenirParametresParDefaut();

    /**
     * Paramètre l'algorithme selon les entrées utilisateurs.
     *
     * @param saisieUtilisateur une liste de Parametre, avec des noms et des valeurs non nulles.
     *
     * TODO Doit lever une exception, si les valeurs sont incorrectes.
     */
    abstract public void parametrer(List<Parametre> saisieUtilisateur);
}
