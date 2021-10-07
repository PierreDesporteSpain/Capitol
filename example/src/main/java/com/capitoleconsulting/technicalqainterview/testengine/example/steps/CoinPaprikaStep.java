package com.capitoleconsulting.technicalqainterview.testengine.example.steps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;

import com.capitoleconsulting.technicalqainterview.testengine.example.controllers.CommonController;
import com.capitoleconsulting.technicalqainterview.testengine.example.libraries.CommonLibrary;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoinPaprikaStep {

	private final CommonController commonController = new CommonController();
	private String body;
	private CommonLibrary library;

	@Before
	public void beforeTests(Scenario scenario) {
		library.getLOGGER().info("Beginning of our coin paprika test : {}", scenario.getName());
	}

	@Given("Connexion to CoinPaprika ok")
	public void connect() throws MalformedURLException {
		Assert.assertEquals(200, this.commonController.getCoinPaprikaController().globalService().code());
	}

	@When("I call the list of listed coin on CoinPaprika")
	public void callListCoin() throws IOException {
		Assert.assertTrue(this.commonController.getCoinPaprikaController().getListCoins().isSuccessful());
		body = this.commonController.getCoinPaprikaController().getListCoins().body().string();
		Assert.assertTrue(body != null);
	}

	@Then("Verify {string} is listed on CoinPaprika")
	public void checkCoinName(String string) {
		Assert.assertTrue(body.contains(string));
	}

}
