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
	
	@Test
	public void LoginNotNullTest(){
		//Testfall 1: Vorhandenes Mitglied einloggen		
		try {
			Assert.assertNotNull(MitgliedBO.getInstance().validiere("mamu", "mamu1"));
		} catch (MitgliedNichtExistentException e) {
			e.getMessage();
		} 
	}
	
	@Test
	public void LoginNullTest(){
		//Testfall 2: Nicht-Vorhandenes Mitglied einloggen versuchen		
		try {
			Assert.assertNull(MitgliedBO.getInstance().validiere("mamu", "mamuWRONG"));
		} catch (MitgliedNichtExistentException e) {
			e.getMessage();
		} 
	}

}
