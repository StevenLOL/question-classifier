package com.blackparty.questionclassifier.models;

public class Word {
	private String wordName;
	private String posTag;

	public Word() {
	}

	public Word(String word, String pos) {
		super();
		this.wordName = word;
		this.posTag = pos;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getPosTag() {
		return posTag;
	}

	public void setPosTag(String posTag) {
		this.posTag = posTag;
	}

	@Override
	public String toString() {
		return wordName;
	}

	public String toStringWithTag() {
		return "[ "+this.wordName+" | "+this.posTag+" ]";
	}
}
