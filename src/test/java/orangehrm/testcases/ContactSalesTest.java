package orangehrm.testcases;

import org.testng.annotations.Test;

import orangehrm.framework.Base;
import orangehrm.pages.ContactSalesPage;
import orangehrm.pages.HomePage;

public class ContactSalesTest extends Base {
	@Test
	public void firstTest() {

		HomePage homePage = new HomePage(driver);

		homePage.navigateToContactSalesPage();

		ContactSalesPage contactSalesPage = new ContactSalesPage(driver);

		contactSalesPage.submitContactSalesForm();

	}

}
