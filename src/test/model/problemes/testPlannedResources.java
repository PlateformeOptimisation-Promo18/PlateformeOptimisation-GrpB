package test.model.problemes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import main.model.problemes.PlannedResources;
import main.model.problemes.Resource;

class testPlannedResources {
	private static List <Resource> resourcesList;
	private static double dLiberationDate;
	private static PlannedResources plannedResources;

	@BeforeAll
	public static void init() {	
		dLiberationDate = 3.0;
		plannedResources = new PlannedResources(resourcesList, dLiberationDate);
	}
	
	@Test
	@Order(1)
	void constructorTest() {
		assertEquals("class main.model.problemes.PlannedResources",plannedResources.getClass().toString());
	}
	
	@Test
	@Order(2)
	void testCompareTo() {
		PlannedResources plannedResourcesToCompare = new PlannedResources(resourcesList, 1.0);
		assertEquals(1, plannedResources.compareTo(plannedResourcesToCompare));
		assertEquals(-1, plannedResourcesToCompare.compareTo(plannedResources));
		assertEquals(0, plannedResources.compareTo(plannedResources));
	}
	
	@Test
	@Order(3)
	void testGetResourcesList() {
		assertNotNull(plannedResources.getResourcesList() instanceof List);
	}

}
