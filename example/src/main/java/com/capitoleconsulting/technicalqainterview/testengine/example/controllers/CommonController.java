package com.capitoleconsulting.technicalqainterview.testengine.example.controllers;

import com.capitoleconsulting.technicalqainterview.testengine.core.TestEngine;

import lombok.Getter;

public class CommonController {

    /**
     * Singleton
     */
    private static final CommonController INSTANCE = new CommonController();

    @Getter private final CoinGeckoController coinGeckoController;
    @Getter private final CoinPaprikaController coinPaprikaController;
    @Getter public UiController uiController;

    public CommonController() {
        this.coinGeckoController = new CoinGeckoController(TestEngine.getINSTANCE().getConfigurator().getConfig().get(CoinGeckoController.class));
        this.coinPaprikaController = new CoinPaprikaController(TestEngine.getINSTANCE().getConfigurator().getConfig().get(CoinPaprikaController.class));
    }

    public static CommonController getINSTANCE() {
        return INSTANCE;
    }

	public CoinGeckoController getCoinGeckoController() {
		return coinGeckoController;
	}
	
	public CoinPaprikaController getCoinPaprikaController() {
		return coinPaprikaController;
	}

}
