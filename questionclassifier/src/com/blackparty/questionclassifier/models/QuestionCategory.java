package com.blackparty.questionclassifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION_CATEGORY_TABLE")
public class QuestionCategory {
	
	@Id
	@Column(name="CODE")
	private String code;
	
	@Column(name="LEVEL_NAME")
	private String levelName;
	
	public QuestionCategory(){}
	public QuestionCategory(String code, String levelName) {
		super();
		this.code = code;
		this.levelName = levelName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	
}
