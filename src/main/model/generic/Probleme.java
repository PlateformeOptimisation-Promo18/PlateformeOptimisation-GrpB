package main.model.generic;

import main.model.generic.Solution;

public interface Probleme {
	
	public Solution getSolution();

	public Solution copySolution(Solution sol);
	
	public int [] getTabSizeDomainVariables();

	public Double getMaxObjectif(int i);

	public Double getMinObjectif(int i);

	public int getNbObjectives();

	public int getNbVariables();

	public boolean[] GetActiveVariable(Solution sol);

	public int getTabSizeDomainVariable(int i) throws Exception;

	public String getName();
	
}
