package practica.letiimonzon.github.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Prueba1 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@DataProvider(name = "dtGenerico")
	public Object[][] dataProvider() {
//		Object[] st = new Object[4];
//		st[0] = "Pepe";
//		st[1] = "Pepe1";
//		st[2] = "Pepe2";
//		st[3] = "Pepe3";
//		
//		Object[] st2 = new Object[4];
//		st2[0] = "Pepe2";
//		st2[1] = "Pepe12";
//		st2[2] = "Pepe22";
//		st2[3] = "Pepe32";
//		
//		Object[][] tmb = new Object[10][];
//
//		tmb[0] = st;
//		tmb[1] = st2;

		Object[][] t2 = new Object[][] { { "Analia", 14 }, { "Leti", 22 }, { "Gaston", 12 }, };

		return t2;

	}

	@DataProvider(name = "personas")
	public Object[][] dPP() {
		Object[][] personas = new Object[][] { { "Analia", 14 }, { "Leti", 22 }, { "Gaston", 12 }, };
		return personas;

	}

	@Test(dataProvider = "personas")
	public void testEdad(String nombre, Integer edad) {
		SoftAssert softAssert = new SoftAssert();
		Integer dif = edad - 18;
		softAssert.assertTrue(dif >= 0, "Menor de edad");
		softAssert.assertFalse(nombre.contains("o"), "Contiene la letra o");
		softAssert.assertAll();

	}

	@Test(dataProvider = "dtGenerico")
	public void test1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

	@Test(dependsOnMethods = { "test2" })
	public void test3() {
		System.out.println("test3");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@AfterMethod
	public void afterTest() {
		System.out.println("afterTest");
	}
}
