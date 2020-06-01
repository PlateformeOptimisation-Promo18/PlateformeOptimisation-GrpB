package test.model.problemes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.model.problemes.Node;
import main.model.problemes.PlannedNode;
import main.model.problemes.SharedEnvironmentForPlanification;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestPlannedNode {
	private static Node initialNode;
	private static SharedEnvironmentForPlanification environment;
	private static PlannedNode nodePlanned;

	@BeforeAll
	public static void init() {	
		initialNode = new Node();
		environment = new SharedEnvironmentForPlanification();
		nodePlanned = new PlannedNode(initialNode, environment);
	}
	
	@Test
	@Order(1)
	void constructorTest() {
		assertEquals("class main.model.problemes.PlannedNode",nodePlanned.getClass().toString());
	}
	
	@Test
	@Order(2)
	void testGetInitialNode() {
		assertEquals("class main.model.problemes.Node",nodePlanned.getInitialNode().getClass().toString());
	}
	
	@Test
	@Order(3)
	void testGetListIdToPreviousNodes() {
		assertNotNull(nodePlanned.getListIdToPreviousNodes());
	}
	
	@Test
	@Order(4)
	void testGetEnvironment() {
		assertEquals("class main.model.problemes.SharedEnvironmentForPlanification",nodePlanned.getEnvironment().getClass().toString());
	}
	
	@Test
	@Order(5)
	void testBeginingDate() {
		nodePlanned.setdBeginingDate(2.0);
		assertEquals(2.0,nodePlanned.getdBeginingDate());
	}
	
	@Test
	@Order(6)
	void testEndingDate() {
		nodePlanned.setdEndingDate(3.0);
		assertEquals(3.0,nodePlanned.getdEndingDate());
	}

}
