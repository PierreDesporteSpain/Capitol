package com.capitoleconsulting.technicalqainterview.testengine.example.controllers;

import com.capitoleconsulting.technicalqainterview.testengine.core.DefaultService;
import com.capitoleconsulting.technicalqainterview.testengine.models.ServiceInformation;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.net.MalformedURLException;
import java.util.HashMap;

public class CoinPaprikaController extends DefaultService {

    /**
     * Constructor
     *
     * @param serviceInformation
     */
    protected CoinPaprikaController(ServiceInformation serviceInformation) {
        super(serviceInformation);
    }

    @SneakyThrows
    public Response globalService() throws MalformedURLException {
        return super.sendGetToService("/v1/global", new HashMap<>(), new HashMap<>());
    }
    
    public Response getListCoins() throws MalformedURLException {
        return super.sendGetToService("/v1/coins", new HashMap<>(), new HashMap<>());
    }
}
