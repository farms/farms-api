package br.ufs.dcomp.farms.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Application;

public class FarmsApp extends Application {

	/**
	 * Configure the package to scan the classes with REST annotations.
	 */
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages", "br.ufs.dcomp.farms.rest");
		return properties;
	}
}
