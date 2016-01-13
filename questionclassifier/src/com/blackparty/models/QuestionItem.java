package com.blackparty.models;

import java.util.List;

public class QuestionItem {
	private List<Sentence> sentenceList;
	private int year;
	private int questionNumber;
	
	public QuestionItem(){}
	
	public QuestionItem(List<Sentence> sentenceList){
		this.sentenceList = sentenceList;
	}
	
	public QuestionItem(int year, int questionNumber){
		this.year = year;
		this.questionNumber = questionNumber;
	}

	public List<Sentence> getSentenceList() {
		return sentenceList;
	}

	public void setSentenceList(List<Sentence> sentenceList) {
		this.sentenceList = sentenceList;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	
	
}
