package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactSalesPage {
	private WebDriver driver;

	By TXT_FIRST_NAME = By.id("Form_submitForm_FirstName");

	By TXT_LAST_NAME = By.id("Form_submitForm_LastName");

	By LST_EMPLOYEES = By.id("Form_submitForm_NoOfEmployees");

	By LST_COUNTRY = By.id("Form_submitForm_Country");

	By BTN_SUBMIT = By.id("Form_submitForm_action_request");

	public ContactSalesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void submitContactSalesForm() {

		driver.findElement(TXT_FIRST_NAME).sendKeys("SQA");

		driver.findElement(TXT_LAST_NAME).sendKeys("GURU");

		Select selectEmployee = new Select(driver.findElement(LST_EMPLOYEES));

		selectEmployee.selectByVisibleText("101 - 150");

		Select selectCountry = new Select(driver.findElement(LST_COUNTRY));

		selectCountry.selectByVisibleText("India");

		driver.findElement(BTN_SUBMIT).submit();

	}
}
