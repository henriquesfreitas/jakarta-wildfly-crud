package com.jakarta.common.debug;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		String logPhaseListener = System.getProperty("logPhaseListener");
		if(logPhaseListener.equals("true")) {
			System.out.println("FASE ID: " + event.getPhaseId());
			System.out.println("FASE: " + event.getPhaseId().getName());
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
