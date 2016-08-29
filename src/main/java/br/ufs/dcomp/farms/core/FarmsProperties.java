package br.ufs.dcomp.farms.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FarmsProperties {
	
	public static Properties load() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = FarmsProperties.class.getClassLoader()
				.getResourceAsStream("properties/farms.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
