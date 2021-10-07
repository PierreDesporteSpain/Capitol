package com.capitoleconsulting.technicalqainterview.testengine.example.steps;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capitoleconsulting.technicalqainterview.testengine.example.controllers.UiController;
import com.capitoleconsulting.technicalqainterview.testengine.example.libraries.CommonLibrary;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleCheckStep extends UiController {

	private final UiController controller = new UiController();
	private String nameCoin = "";
	private CommonLibrary library;

	@Before
	public void beforeTests(Scenario scenario) {
		library.getLOGGER().info("Beginning of our Google Check test : {}", scenario.getName());
	}

	@Given("Set our favourite coin to {string}")
	public void setFavouriteCoin(String name) throws MalformedURLException {
		nameCoin = name;
	}

	@When("Open {string}")
	public void open(String url) {
		controller.open(url);
	}

	@And(" Make a google search")
	public void search() {
		controller.getDriver()
				.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys(nameCoin);

	}

	@And("Close Browser")
	public void closeBrowser() {
		controller.getDriver().findElement(By.name("btnK")).click();
	}

	@Then("Verify There is a wikipedia link")
	public void checkWkipediaLink(String string) {

		// wait until the page shows the result
		new WebDriverWait(controller.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

		List<WebElement> findElements = controller.getDriver()
				.findElements(By.xpath("//*[@id=\"rso\"]/div[*]/div/div/div[1]/a/h3"));

		
		List<String> linkName = new ArrayList<String>();
		for (WebElement webElement : findElements) {
			linkName.add(webElement.getText());
		}
		
		Assert.assertTrue(linkName.contains("Wikipedia"));
		library.getLOGGER().info("Wikipedia link is present");
	}
}
