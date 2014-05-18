package data_access_objectsTest;

import static org.junit.Assert.*;

import org.junit.*;

import sonstiges.Adresse;
import data_access_objects.MitgliedDAO;

public class MitgliedDAO_Test {
	
	@BeforeClass
	public static void create() {
		// Neues MitgliedDAO erschaffen
		MitgliedDAO.getInstance();
		System.out.println("[jUnit] Testbeginn - Mitglieds-Instanz erschaffen");
		
	}
	
	@Test
	public void createTest(){
		// Testfall 1: Neues Mitglied in DB eintragen		
		MitgliedDAO.getInstance().create("Müller", "Peter", "pemü", "pemü1", "1990-06-21", new Adresse("strasse", 12, 22234, "Dorf", "Deutschland"));
	}
	
	@Test
	public void readTest(){
		// Testfall 2: Nicht vorhandenes Mitglied aus DB lesen	
		assertNull(MitgliedDAO.getInstance().read(9999));
	}
}
