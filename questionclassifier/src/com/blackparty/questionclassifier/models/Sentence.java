package com.blackparty.questionclassifier.models;

import java.util.List;

public class Sentence {
	private List<Word> wordList;
	private String kindOfSentence;
	
	public Sentence(){}

	public Sentence(List<Word> wordList, String kindOfSentence) {
		super();
		this.wordList = wordList;
		this.kindOfSentence = kindOfSentence;
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	public String getKindOfSentence() {
		return kindOfSentence;
	}

	public void setKindOfSentence(String kindOfSentence) {
		this.kindOfSentence = kindOfSentence;
	}
	
	
}
