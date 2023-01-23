package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class SearchTrain extends TestBase {
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[1]/div[1]/p-autocomplete[1]/span[1]/input[1]")
	WebElement fromLoc;

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[1]/div[2]/p-autocomplete[1]/span[1]/input[1]")
	WebElement toLoc;

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/input[1]")
	WebElement date;

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[2]/p-dropdown[1]/div[1]")
	WebElement trClass;

	public SearchTrain() {
		PageFactory.initElements(driver, this);
	}

	public void searchLoc() throws InterruptedException {
		fromLoc.sendKeys("Delhi");
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		toLoc.sendKeys("Mumbai");
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void selDate() {
		date.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]")));
		String monYear = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]"))
				.getText();
		System.out.println(monYear);
		while (!(monYear.equals("April2023"))) {
			driver.findElement(By.xpath(
					"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/a[2]/span[1]"))
					.click();
			monYear = driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]"))
					.getText();
			System.out.println(monYear);
		}
		driver.findElement(By.xpath("//a[contains(text(),'15')]")).click();
	}

	public void selClass() {
		trClass.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[2]/p-dropdown[1]/div[1]/div[4]")));
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for (int i = 0; i < list.size(); i++) {
			String txt = list.get(i).getText();
			if (txt.equals("Sleeper (SL)")) {
				list.get(i).click();
			}
		}
	}

	public void clickBtn() {
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
	}
	
	public void countTrains() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-sm-5 col-xs-11 train-heading']"));
		System.out.println("No of trains: "+list.size());
	}
}