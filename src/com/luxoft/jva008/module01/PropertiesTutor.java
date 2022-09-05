package com.luxoft.jva008.module01;

import org.junit.Test;

import java.util.Properties;

import static com.luxoft.jva008.Logger.log;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertiesTutor {

	/**
	 * Returns the value of the system property java.version
	 */
	public String getJavaVersion() {
		return "";
	}

	@Test
	public void testJavaVersion() {
		String version = getJavaVersion();
		log(getJavaVersion());
		assertTrue(version.startsWith("11."));
	}

	/**
	 * Loads the properties file from the files / props.properties folder
	 * And returns the downloaded properties
	 *
	 * @return
	 */
	public Properties getProperties() {
		return new Properties();
	}

	@Test
	public void testGetProperties() {
		Properties props = getProperties();
		log("country=" + props.getProperty("country"));
		log("color=" + props.getProperty("color"));
		assertEquals("Australia", props.getProperty("country"));
		assertEquals("red", props.getProperty("color"));
	}

}
