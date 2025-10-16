package com.ecrops.dto;

import java.util.Map;

public class DistrictTargetDto {
	
	private Long id;
    private Map<String, String> editedData;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Map<String, String> getEditedData() {
		return editedData;
	}
	public void setEditedData(Map<String, String> editedData) {
		this.editedData = editedData;
	}
	@Override
	public String toString() {
		return "DistrictTargetDto [id=" + id + ", editedData=" + editedData + ", getId()=" + getId()
				+ ", getEditedData()=" + getEditedData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
