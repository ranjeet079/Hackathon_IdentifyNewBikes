package pageObjects;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;
import factory.BaseClass;

//import baseClass.BaseClass;

public class Usedcars extends BasePage{
	ExcelUtils Eu=new ExcelUtils();
	
	public Usedcars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

/*	public UsedCars(WebDriver driver) {
		super(driver);
	}*/
	
	
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsMenu;
	
//	@FindBy(xpath = "//li/span[text()=\"Chennai\"]")
	@FindBy(xpath = "*//span[@data-tag-url='/used-car/Chennai']")
	WebElement chennaiUsedCars;
	
	@FindBy(xpath = "//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	List<WebElement> checkboxOfCars;

	@FindBy(xpath = "//span[normalize-space()='Brand and Model']")
	WebElement BrandAndModel;
	
public void usedCarsMenu() {
		
		Actions action = new Actions(driver);
		action.moveToElement(usedCarsMenu).perform();

	}

public void selectChennaiUsedCars() throws IOException {
	new BaseClass().screenshot("UsedCarLocation");
	chennaiUsedCars.click();

}

public void extractPopularModels() throws IOException, InterruptedException {
	System.out.println("Total no of cars:" + checkboxOfCars.size());
	Eu.setCellData("PopularModels", 0, 0, "PopularModelsList");
	int row=1;
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",BrandAndModel );
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	for (WebElement model : checkboxOfCars) {
		try {
			System.out.println(model.getText());
			Eu.setCellData("PopularModels", row, 0, model.getText());
			row++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

}
