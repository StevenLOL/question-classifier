package com.blackparty.models;

public class Word {
	private String word;
	private String pos;
	
	public Word(){}

	public Word(String word, String pos) {
		super();
		this.word = word;
		this.pos = pos;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
