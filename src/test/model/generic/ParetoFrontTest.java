package test.model.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.model.generic.ParetoFront;
import main.model.generic.Solution;
import main.model.problemes.GraphProject;
import main.model.problemes.Scenario;

public class ParetoFrontTest extends ParetoFront{

	
	private ParetoFront pFront;
	private GraphProject gpt;
	private Solution sol0;
	private Solution sol1;
	private Solution sol2;
	private Solution sol3;

	@Before
	public void setUp() throws Exception {
		ArrayList<Solution> set = new ArrayList<Solution>();
		this.pFront = new ParetoFront();
		this.gpt = new GraphProject("test");
		int[] tab0 = {0,0,0,0,1};
		this.sol0 = new Scenario(gpt);
		sol0.setValuesVariables(tab0);
		sol0.evaluate(gpt);

		int[] tab1 = {1,0,0,0,1};
		this.sol1 = new Scenario(gpt);
		sol1.setValuesVariables(tab1);
		sol1.evaluate(gpt);

		int[] tab2 = {1,0,1,1,1};
		this.sol2 = new Scenario(gpt);
		sol2.setValuesVariables(tab2);
		sol2.evaluate(gpt);
		
		int[] tab3 = {1,0,1,0,1};
		this.sol3 = new Scenario(gpt);
		sol3.setValuesVariables(tab3);
		sol3.evaluate(gpt);
		
		set.add(sol0);
		set.add(sol1);
		set.add(sol2);
		set.add(sol3);
		
		pFront.setSet(set);
	}
	
	@After
	public void tearDown() throws Exception {
		this.pFront=null;
		this.gpt=null;
		this.sol0=null;
		this.sol1=null;
		this.sol2=null;
	}
	

	@Test
	public void testGetDistance() {
		assertEquals(8.3868, this.pFront.getDistance(sol0, sol1, gpt),0.0001);
		assertEquals(5.3758, this.pFront.getDistance(sol2, sol3, gpt),0.0001);
	}
	
	@Test
	public void testGetDistanceCluster() {
		ArrayList<Solution> cluster0 = new ArrayList<Solution>();
		ArrayList<Solution> cluster1 = new ArrayList<Solution>();
		cluster0.add(this.sol0);
		cluster0.add(this.sol1);
		cluster1.add(this.sol2);
		cluster1.add(this.sol3);
		
		assertEquals(4.8647, this.pFront.getDistanceClusters(cluster0, cluster1,this.gpt),0.0001);
	}
	
	@Test
	public void testCentroide() {
		ArrayList<Solution> cluster = new ArrayList<Solution>();
		cluster.add(this.sol0);
		cluster.add(this.sol1);
		cluster.add(this.sol2);

		assertTrue(this.pFront.centroide(cluster, this.gpt).equals(this.sol2));
	}
	
	@Test
	public void testReductionFrontPareto() {
		this.pFront.reduceIfNecessary(2, this.gpt);
		assertEquals(2,this.pFront.getSet().size());
		assertEquals(sol3,this.pFront.getSet().get(0));
		assertEquals(sol2,this.pFront.getSet().get(1));
	}
	

}
