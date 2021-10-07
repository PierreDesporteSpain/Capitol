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

public class CoinGeckoStep {

	private final CommonController commonController = new CommonController();
	private String body;
	private CommonLibrary library;

	@Before
	public void beforeTests(Scenario scenario) {
		library.beforeTests(scenario);
	}

	@Given("Connexion to CoinGecko ok")
	public void connect() throws MalformedURLException {
		Assert.assertEquals(200, this.commonController.getCoinGeckoController().pingService().code());
	}

	@When("I call the list of listed coin on CoinGecko")
	public void callListCoin() throws IOException {
		Assert.assertTrue(this.commonController.getCoinGeckoController().getListCoins().isSuccessful());
		body = this.commonController.getCoinGeckoController().getListCoins().body().string();
		Assert.assertTrue(body != null);
	}

	@Then("Verify {string} is listed on CoinGecko")
	public void checkCoinName(String string) {
		Assert.assertTrue(body.contains(string));
	}

}
