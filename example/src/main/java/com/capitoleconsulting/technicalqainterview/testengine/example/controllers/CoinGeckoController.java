package com.capitoleconsulting.technicalqainterview.testengine.example.controllers;

import com.capitoleconsulting.technicalqainterview.testengine.core.DefaultService;
import com.capitoleconsulting.technicalqainterview.testengine.models.ServiceInformation;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.net.MalformedURLException;
import java.util.HashMap;

public class CoinGeckoController extends DefaultService {

    /**
     * Constructor
     *
     * @param serviceInformation
     */
    protected CoinGeckoController(ServiceInformation serviceInformation) {
        super(serviceInformation);
    }

    @SneakyThrows
    public Response pingService() throws MalformedURLException {
        return super.sendGetToService("/api/v3/ping", new HashMap<>(), new HashMap<>());
    }
    
    public Response getList() throws MalformedURLException {
        return super.sendGetToService("/api/v3/coins/list", new HashMap<>(), new HashMap<>());
    }
}
