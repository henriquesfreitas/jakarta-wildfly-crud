package com.jakarta.dao.common;

import jakarta.ejb.Stateless;

import com.jakarta.dto.common.GenericDTO;
import com.jakarta.models.GenericEntity;

@Stateless
public interface GenericDAOInterface<DTO extends GenericDTO, ENT extends GenericEntity> {
	
	public abstract ENT convertFromDTO(DTO dto);
	public abstract DTO convertFromEntity(ENT entity);

}
