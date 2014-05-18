package GUIsTest;

import org.junit.*;
import sonstiges.MitgliedNichtExistentException;
import business_objects.MitgliedBO;

public class LoginGUI_Test {
	
	@Before
	public void vor() {
	      // Diese Methode wird vor jedem Testfall ausgeführt
	      System.out.println("[jUnit] Testbeginn Mitgliedsvalidierung");
	}
	
	@Test(expected= MitgliedNichtExistentException.class)
	public void LoginTest(){
		//Testfall 1: Vorhandenes Mitglied einloggen		
		try {
			Assert.assertNotNull(MitgliedBO.getInstance().validiere("mamu", "mamu1"));
		} catch (MitgliedNichtExistentException e) {
			System.out.println("[jUnit] Fehler beim validieren vom Login:");
			e.getMessage();
		} 
	}

}
