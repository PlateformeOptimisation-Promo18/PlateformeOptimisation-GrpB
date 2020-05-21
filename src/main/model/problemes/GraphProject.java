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
    protected int iNbAndNode;
    protected int iNbOrNode;
    protected int iNbTaskNode;

    public GraphProject (String text) {
    	projectGraph = new ArrayList<Node>();
    	listInitialResources = new ArrayList<Resource>();
    	listObjectives = new ArrayList<Objectif>();
    	Path fic = Paths.get(System.getProperty("user.dir"), "gpTest.prj");
		try (Scanner sc = new Scanner(fic)) {
			sc.useLocale(Locale.FRENCH);
			sName = sc.next();
			for(int i=0; i<sc.nextInt();i++) {
				listObjectives.add(new Objectif(sc));
			}
			for(int i=0; i<sc.nextInt();i++) {
				listInitialResources.add(new Resource(sc));
			}
			iNbTaskNode = sc.nextInt();
			for(int i=0; i<iNbTaskNode; i++) {
				TaskNode tn = new TaskNode(sc, this);
				projectGraph.add(tn.getiIdTask(), tn);
			}
			iNbOrNode = sc.nextInt();
			for(int i=0; i<iNbOrNode; i++) {
				OrNode on = new OrNode(sc);
				projectGraph.add(on.getiIdOrNode(), on);
				on.getiIdEndOrNode();
			}
			iNbAndNode = sc.nextInt();
			for(int i=0; i<iNbAndNode; i++) {
				AndNode an = new AndNode(sc);
				//projectGraph.add(an.getiIdAndNode(), an);
				//an.getiIdEndAndNode();
			}
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
        return listInitialResources.size();
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
        return listObjectives.size();
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