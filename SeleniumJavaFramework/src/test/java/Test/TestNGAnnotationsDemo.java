package Test;

import org.apache.xmlbeans.xml.stream.EndElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

	@Test(groups = { "sanity" })
	public void a() {

		System.out.println("This is test 1");
		System.out.println( "this is for test");
	}

	@Test(groups = { "regression" })
	public void b() {

		System.out.println("This is test 2");
	}

	@Test(groups = { "regression", "windows.sanity" })
	public void c() {

		System.out.println("This is test 3");
	}

	@Ignore
	@Test(groups = { "windows.sanity" })
	public void d() {

		System.out.println("This is test 4");

	}

	@Test(priority = 1)
	public void e() {

		System.out.println("This is for priority");
	}

	@Test
	@Parameters({ "name" })
	public void f(@Optional("Abhi") String name) {

		System.out.println("This is for parameter annotation and my name is " + name);

	}

	@Test(dependsOnMethods = { "f" })
	public void g() {

		System.out.println("This is for Dependencieson methods");
	}

	@Test(dependsOnGroups= {"windows.sanity"})
	public void h() {

		System.out.println("This is for Dependencies on groups");
	}

}
