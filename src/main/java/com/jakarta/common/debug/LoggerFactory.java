package com.jakarta.common.debug;

import jakarta.enterprise.inject.Produces;

import com.jakarta.models.LogConfiguration;

public class LoggerFactory {

	//besides create a new annotation(actually a qualifier), the beans.xml file it's required too
	//https://www.alexgama.io/java/cdi-series/cdi-in-java-series-part-2-qualifiers/
	@Produces @AllLogsQualifier
	public Logger createAllLogs() {
		LogConfiguration logConfiguration = new LogConfiguration();
		logConfiguration.setAllMode(true);

	    return new Logger(logConfiguration);
	}
	
	@Produces @InfoLogsQualifier
	public Logger createInfoLogs() {
		LogConfiguration logConfiguration = new LogConfiguration();
		logConfiguration.setInfoMode(true);
		
		return new Logger(logConfiguration);
	}
	
}
