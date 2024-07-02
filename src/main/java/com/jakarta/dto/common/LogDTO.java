package com.jakarta.dto.common;

import java.time.LocalDateTime;

public class LogDTO {
	private LocalDateTime creation;
	
	private Long idCreator;

	private LocalDateTime change;
	
	private Long idChanger;
	
	private boolean disabled;
	
	private Long idDeactivator;

	public LogDTO(LocalDateTime creation, Long idCreator, LocalDateTime change, Long idChanger, boolean disabled,
			Long idDeactivator) {
		this.creation = creation;
		this.idCreator = idCreator;
		this.change = change;
		this.idChanger = idChanger;
		this.disabled = disabled;
		this.idDeactivator = idDeactivator;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public Long getIdCreator() {
		return idCreator;
	}

	public void setIdCreator(Long idCreator) {
		this.idCreator = idCreator;
	}

	public LocalDateTime getChange() {
		return change;
	}

	public void setChange(LocalDateTime change) {
		this.change = change;
	}

	public Long getIdChanger() {
		return idChanger;
	}

	public void setIdChanger(Long idChanger) {
		this.idChanger = idChanger;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Long getIdDeactivator() {
		return idDeactivator;
	}

	public void setIdDeactivator(Long idDeactivator) {
		this.idDeactivator = idDeactivator;
	}
}
