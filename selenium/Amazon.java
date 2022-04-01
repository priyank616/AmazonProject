package selenium;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {

	static WebDriver driver;
	static Signupobject pom;
	boolean result;

	@BeforeTest
	public void openbrowser() {

		driver = Signupobject.Initalization(driver, "chrome");
		pom = new Signupobject(driver);

	}

	@Test(priority = 1)

	public void Screen() throws IOException {
		pom.ScreenShot(driver);

	}

	@Test(priority = 2)

	public void AmTitle() {
		String Atitle = driver.getTitle();
		String title = pom.Titlecheck();
		Assert.assertEquals(Atitle, title);

	}

	@Test(priority = 3)

	public void Hello() {
		pom.SendHello(driver);

	}

	@Test(priority = 4)

	public void Login() {

		pom.typeFname("Harry", "abc@gmail.com", "qwerty", "qwerty");
	}

}
