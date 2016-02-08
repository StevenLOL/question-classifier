package com.blackparty.questionclassifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="QUESTION_PROCESSED_TABLE")
public class QuestionProcessed {

	@Column(name="QUESTION_ID")
	private int questionId;
	@Column(name="FLAG_CODE")
	private String flagCode;
	
	public QuestionProcessed(){}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getFlagCode() {
		return flagCode;
	}

	public void setFlagCode(String flagCode) {
		this.flagCode = flagCode;
	}
	
	
}
