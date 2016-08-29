package br.ufs.dcomp.farms.core;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import junit.framework.TestCase;

public class FarmsPropertiesTest extends TestCase {

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testShoudLoadProperties() throws IOException {
		Properties prop = FarmsProperties.load();
		String farmsSiteUrl = "http://www.farms.nords.com.br";
		
		String farmsSiteUrlProperty = prop.getProperty("farms.site.url");
		
		assertNotNull(farmsSiteUrl);
		assertNotSame(farmsSiteUrl, farmsSiteUrlProperty);
	}
}