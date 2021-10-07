package com.capitoleconsulting.technicalqainterview.testengine.example.libraries;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capitoleconsulting.technicalqainterview.testengine.example.controllers.CommonController;
import com.capitoleconsulting.technicalqainterview.testengine.example.model.CoinGeckoInfo;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonLibrary {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final CommonController commonController;

    private final CoinGeckoInfo coinGeckoInfo;

    public CommonLibrary(){
        this.commonController = CommonController.getINSTANCE();
        this.coinGeckoInfo = new CoinGeckoInfo();
    }

    @Before
    public void beforeTests(Scenario scenario){
        LOGGER.info("Hello, here is the beginning of our coin gecko test : {}", scenario.getName());
    }

    @Given("Connexion to CoinGecko ok")
    public void connexionToCoinGeckoOk() throws MalformedURLException
    {
        LOGGER.info("checking if we can access to CoinGecko");
        Assert.assertEquals(200 , this.commonController.getCoinGeckoController().pingService().code());
    }

    @When("Open {string}")
    public void open(String url) {
        this.commonController.uiController.open(url);
    }

	public Logger getLOGGER() {
		return LOGGER;
	}
}
