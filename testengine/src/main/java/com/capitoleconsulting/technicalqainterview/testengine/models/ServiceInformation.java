package com.capitoleconsulting.technicalqainterview.testengine.models;

import io.vavr.control.Option;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ServiceInformation {
    @Setter @Getter private String serviceUrl;
    @Setter @Getter private Option<String> servicePort;
    
	public String getServiceUrl() {
		return serviceUrl;
	}

	public Option<String> getServicePort() {
		return servicePort;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public void setServicePort(Option<String> servicePort) {
		this.servicePort = servicePort;
	}
}
