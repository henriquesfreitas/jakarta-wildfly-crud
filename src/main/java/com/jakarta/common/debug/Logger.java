package com.jakarta.common.debug;

import java.io.Serializable;

import com.jakarta.models.LogConfiguration;

public class Logger implements Serializable {
	
	private static final long serialVersionUID = 4438510140160323703L;

	private LogConfiguration configuration;

	private String showLog;
	
	public Logger(LogConfiguration configuration) {
		this.configuration = configuration;
		//this property only controls if the log will show or not
		//to level controls, change the log qualifier in the GenericBean
		this.showLog = System.getProperty("showLog", "/application.properties");
	}
	
	public void printInfo(String message) {
		if(configuration.isInfoMode()) {
			println("INFO: " + message);
		}
	}

	public void printDebug(String message) {
		if(configuration.isDebugMode()) {
			println("DEBUG: " + message);
		}
	}
	
	public void printWarn(String message) {
		if(configuration.isWarnMode()) {
			println("WARN: " + message);
		}
	}
	
	private void println(String message) {
		if(showLog.equals("true")) {
			System.out.println(message);
		}
	}
	
}
