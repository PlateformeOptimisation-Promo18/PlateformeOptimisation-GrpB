package main.model.problemes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import main.model.generic.Problem;
import main.model.generic.Solution;

public class GraphProject implements Problem {

    private String sName;
    protected List<Node> projectGraph;
    protected List<Resource> listInitialResources;
    protected List<Objectif> listObjectives;
    protected int iNbObjectives;
    protected int iNbRessources;
    protected int iNbAndNode;
    protected int iNbOrNode;
    protected int iNbTaskNode;

    public GraphProject (String text) {
    	
    	// Initialisation des listes
    	projectGraph = new ArrayList<Node>();
    	listInitialResources = new ArrayList<Resource>();
    	listObjectives = new ArrayList<Objectif>();
    	
    	// Recherche du fichier
    	Path fic = Paths.get(System.getProperty("user.dir"), text);
		try (Scanner sc = new Scanner(fic)) {
			sc.useLocale(Locale.FRENCH);
			
			// Nom du Project Graph
			sName = sc.nextLine();
			
			// Chargement des objetifs
			this.iNbObjectives = sc.nextInt();
			for(int i=0; i<iNbObjectives;i++) {
				listObjectives.add(new Objectif(sc));
			}
			
			// Chargement des ressources
			this.iNbRessources = sc.nextInt();
			for(int i=0; i<iNbRessources;i++) {
				listInitialResources.add(new Resource(sc));
			}
			
			sc.next();
			// Chargement des taches
			iNbTaskNode = sc.nextInt();
			for(int i=0; i<iNbTaskNode; i++) {
				TaskNode tn = new TaskNode(sc, this);
				tn.setiIdTask(i);
				projectGraph.add(tn);
			}
			
			sc.next();
			// Chargement des noeuds OU
			iNbOrNode = sc.nextInt();
			for(int i=0; i<iNbOrNode; i++) {
				OrNode on = new OrNode(sc);
				on.setiIdOrNode(i);
				projectGraph.add(on);
				projectGraph.add(new EndOrNode(on.getiIdEndOrNode(), on.getiIdNode()));
			}
			
			sc.next();
			// Chargement des noeuds ET
			iNbAndNode = sc.nextInt();
			for(int i=0; i<iNbAndNode; i++) {
				AndNode an = new AndNode(sc);
				projectGraph.add(an);
				projectGraph.add(new EndAndNode(an.getiIdEndAndNode(), an.getiIdNode()));
			}
			
			// Tri de la liste de noeuds dans l'ordre des ID
			projectGraph.sort(null);
			sc.next();
			// Remplissage des listes NextNode et PreviousNode
			for(int i=0; i<sc.nextInt(); i++) {
				Node n = projectGraph.get(sc.nextInt());
				for(int j=0; j<sc.nextInt(); j++) {
					int id = sc.nextInt();
					n.setNextNode(id);
					projectGraph.get(sc.nextInt()).setPreviousNode(n.iIdNode);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public String getName () {
        return this.sName;
    }

    public int getNbOr () {
    	return iNbOrNode;
    }

    public int getNbTasks () {
        return iNbTaskNode;
    }

    public int getNbResources () {
        return iNbRessources;
    }

    public int getNbAnd () {
        return iNbAndNode;
    }

    @Override
    public Solution getSolution() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Solution copySolution(Solution sol) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int[] getTabSizeDomainVariables() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getMaxObjectif(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getMinObjectif(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getNbObjectives() {
        return iNbObjectives;
    }

    @Override
    public int getNbVariables() {
        return 0;
    }

    @Override
    public boolean[] GetActiveVariable(Solution sol) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getTabSizeDomainVariable(int i) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

}