package com.blackparty.questionclassifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="FLAG_CODE_TABLE")
public class FlagCode {
	
	@Id
	@Column(name="FLAG_CODE")
	private String flagCode;
	@Column(name="FLAG_NAME")
	private String flagName;
	
	public FlagCode(){}

	public String getFlagCode() {
		return flagCode;
	}

	public void setFlagCode(String flagCode) {
		this.flagCode = flagCode;
	}

	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	
}
