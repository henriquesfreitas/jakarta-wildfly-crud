package com.jakarta.models;

public class LogConfiguration {
	
    private boolean infoMode;

    private boolean debugMode;

    private boolean warnMode;

	public boolean isAllMode() {
		return infoMode && debugMode && warnMode;
	}

	public void setAllMode(boolean allMode) {
		this.infoMode = allMode;
		this.debugMode = allMode;
		this.warnMode = allMode;
	}

	public boolean isInfoMode() {
		return infoMode;
	}

	public void setInfoMode(boolean infoMode) {
		this.infoMode = infoMode;
	}

	public boolean isDebugMode() {
		return debugMode;
	}

	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}

	public boolean isWarnMode() {
		return warnMode;
	}

	public void setWarnMode(boolean warnMode) {
		this.warnMode = warnMode;
	}

}
