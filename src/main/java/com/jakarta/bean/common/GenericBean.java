package com.jakarta.bean.common;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

import com.jakarta.common.debug.AllLogsQualifier;
import com.jakarta.common.debug.InfoLogsQualifier;
import com.jakarta.common.debug.Logger;

public class GenericBean {
	
	//besides create a new annotation(actually a qualifier), the beans.xml file it's required too
	//https://www.alexgama.io/java/cdi-series/cdi-in-java-series-part-2-qualifiers/
	@Inject @InfoLogsQualifier
	protected Logger logger;
	
	protected void addMessageInfo(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_INFO, message);
	}
	
	protected void addMessageWarn(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_WARN, message);
	}
	
	protected void addMessageError(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_ERROR, message);
	}
	
	protected void addMessageFatal(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_FATAL, message);
	}
	
	protected void addMessageException(String message) {
		addMessage("messages", new FacesMessage(message));
	}
	
	private void addMessageWithSeverity(Severity severity, String message) {
		addMessage("message", new FacesMessage(severity, message, ""));
	}
	
	private void addMessage(String messageId, FacesMessage facesMessage) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(messageId, facesMessage);		
	}
}
