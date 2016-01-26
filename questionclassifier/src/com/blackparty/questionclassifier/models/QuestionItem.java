package com.blackparty.questionclassifier.models;

import java.util.List;

public class QuestionItem {
	private List<Sentence> sentences;
	private int year;
	private int questionNumber;
	
	public QuestionItem(){}
	
	public QuestionItem(List<Sentence> sentences){
		this.sentences = sentences;
	}
	
	public QuestionItem(int year, int questionNumber){
		this.year = year;
		this.questionNumber = questionNumber;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentenceList(List<Sentence> sentences) {
		this.sentences = sentences;
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
	
	public void displayWordValues(){
		System.out.println("display word values..");
        for(Sentence s : getSentences()){
            for(Word w: s.getWordList()){
                System.out.println(w.getWord());
            }
        }
    }
	
	public void displayWordWithTags(){
		System.out.println("display word with tags...");
		for(Sentence s:getSentences()){
			for(Word w: s.getWordList()){
				System.out.println(w.toStringWithTag());
			}
		}
		
	}
	
}
