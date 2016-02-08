package com.blackparty.questionclassifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION_TYPE_TABLE")
public class QuestionType {

	@Id
	@Column(name="CODE")
	private String code;
	
	@Column(name="TYPE_NAME")
	private String typeName;

	
	public QuestionType(){}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
