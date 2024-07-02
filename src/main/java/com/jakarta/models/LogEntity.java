package com.jakarta.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LogEntity {
	
//	@Column(name = "startTime", columnDefinition="DATETIME")
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creation;
	
	@Column(name = "id_creator")
	private Long idCreator;

//	@Temporal(TemporalType.TIMESTAMP) temporal it's only used with Date
	private LocalDateTime change;
	
	@Column(name = "id_changer")
	private Long idChanger;
	
	private boolean disabled = false;
	
	@Column(name = "id_deactivator")
	private Long idDeactivator;
	
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

	public Long getIdDeactivator() {
		return idDeactivator;
	}

	public void setIdDeactivator(Long idDeactivator) {
		this.idDeactivator = idDeactivator;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}
