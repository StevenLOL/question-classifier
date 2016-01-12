package com.blackparty.questionclassifier.core;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Tagger {
	
	
	public String tag(String input){
		String tagged="";
		MaxentTagger tagger = new MaxentTagger("D:\\Our Files\\Eric\\J2EE Mars\\questionclassifier\\lib\\edu\\stanford\\nlp\\models\\pos-tagger\\english-left3words\\english-left3words-distsim.tagger");
		tagged = tagger.tagString(input);
		System.out.println("Input = "+input);
		System.out.println(tagged);
		return tagged;
	}
	
}
