package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	By BTN_CONTACT_SALES = By.xpath("//*[@id='header-navbar']/ul[3]/li[1]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToContactSalesPage() {

		driver.findElement(BTN_CONTACT_SALES).click();

	}

	public void verifyContactSalesButtonExist() {

		driver.findElement(BTN_CONTACT_SALES).isDisplayed();

	}
}
