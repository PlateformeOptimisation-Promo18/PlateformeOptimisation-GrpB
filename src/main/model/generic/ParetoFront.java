package main.model.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParetoFront {

    protected double hypervolum = 0.0;
    protected ArrayList<Solution> set;

    public ParetoFront() {

    }

    public ParetoFront(ParetoFront paretoFront) {

    }

    public ArrayList<Solution> getSet(){
        return this.set;
    }
    
    //A supprimer plus tard
    public void setSet(ArrayList<Solution> set) {
    	this.set = set;
    }

    public String toString() {
        return null;
    }

    public double getHypervolum() {
        return this.hypervolum;
    }

    public void add(Solution sol) {
    }

    public int getNbElements() {
        return this.set.size();
    }

    public boolean addSolutionIfIsParetoFrontSolution(Solution solutionToAdd) {
        return false;
    }

    //Teste si une solution en domine une autre
    public static boolean domine(Solution sol1, Solution sol2, Problem pb) {
        return false;
    }
    //Actualise le front de pareto
    public void updateFront(List<Solution> solutionSet, Problem pb) {

    }

    public double calculHV(Problem pb) {
        return 0.0;
    }

    public void remove(Solution sol) {

    }

    public Iterator<Solution> getIteratorSet(){
        return null;
    }

	/**
	 * Reduit le nombre de solution du front de Pareto.
	 * Conserve les solutions les plus réparties sur le front.
	 * Ne fait rien si le nombre de solution a garder est inferieure ou egal au nombre de solution initial.
	 * @param nbMaxSol le nombre de solution à garder
	 * @param pb Problem
	 */
	public void reduceIfNecessary(int nbMaxSol, Problem pb) {
		ArrayList<ArrayList<Solution>> clusters = new ArrayList<ArrayList<Solution>>();

		for (Solution s : set) {
			ArrayList<Solution> solutions = new ArrayList<Solution>();
			solutions.add(s);
			clusters.add(solutions);
		}

		while (clusters.size() > nbMaxSol) {
			int i = 1;
			int besta = -1;
			int bestb = -1;
			double bestvalue = -1;

			for (int a = 0; a < clusters.size(); a++) {
				for (int b = i; b < clusters.size(); b++) {
					double distance = getDistanceClusters(clusters.get(a), clusters.get(b), pb);
					if (distance < bestvalue || bestvalue == -1) {
						bestvalue = distance;
						besta = a;
						bestb = b;
					}
				}
				i++;
			}
			clusters.get(besta).addAll(clusters.get(bestb));
			clusters.remove(bestb);
		}
		set.clear();
		for(ArrayList<Solution> cluster : clusters) {
			set.add(centroide(cluster, pb));
		}

	}

	/**
	 * Retourne la distance entre deux solutions
	 * @param sol1 Solution
	 * @param sol2 Solution
 	 * @param pb Problem
	 * @return la distance entre la sol1 et la sol2
	 */
	public double getDistance(Solution sol1, Solution sol2, Problem pb) {
		double distance = 0;
		for(int i =0;i <pb.getNbObjectives();i++) {
			distance += Math.pow(sol1.getValueObjective(i)-sol2.getValueObjective(i), 2);
		}
		return Math.sqrt(distance);
	}
	
	/**
	 * Retourne la distance entre deux clusters
	 * @param cluster1 liste des solutions
	 * @param cluster2 liste des solutions
 	 * @param pb Problem
	 * @return la distance entre le cluster1 et le cluster2
	 */
	public double getDistanceClusters(ArrayList<Solution> cluster1, ArrayList<Solution> cluster2, Problem pb) {
		double total = 0;

		for (Solution s1 : cluster1) {
			for (Solution s2 : cluster2) {
				total += getDistance(s1, s2, pb);
			}
		}

		return total / (cluster1.size() * cluster2.size());
	}
	
	/**
	 * Retourne la solution centrale d'un cluster
	 * @param cluster liste des solutions
	 * @param pb Problem
	 * @return la solution qui se situe le plus au centre d'un cluster
	 */
	public Solution centroide(ArrayList<Solution> cluster, Problem pb) {
		int i = 1;
		int besta = -1;
		double bestvalue = -1;
		for (int a = 0; a < cluster.size(); a++) {
			int total = 0;
			for (int b = i; b < cluster.size(); b++) {
				total += getDistance(cluster.get(a), cluster.get(b), pb);
			}
			i++;
			if (total < bestvalue || bestvalue == -1) {
				bestvalue = total;
				besta = a;
			}
		}
		return cluster.get(besta);
	}
}
