package orangehrm.testcases;

import org.testng.annotations.Test;

import orangehrm.framework.Base;
import orangehrm.pages.HomePage;

public class VerifyHomePageElementsTest extends Base {
	@Test
	public void verifyHomePageElements() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyContactSalesButtonExist();
	}
}
