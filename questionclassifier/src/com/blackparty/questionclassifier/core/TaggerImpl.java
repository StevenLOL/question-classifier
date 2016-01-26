package com.blackparty.questionclassifier.core;

import java.util.StringTokenizer;

import com.blackparty.questionclassifier.models.QuestionItem;
import com.blackparty.questionclassifier.models.Sentence;
import com.blackparty.questionclassifier.models.Word;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TaggerImpl implements Tagger{
	
	@Override
	public String tag(String input) {
		MaxentTagger tagger = new MaxentTagger("D:\\Our Files\\Eric\\J2EE Mars\\question-classifier\\question-classifier\\questionclassifier\\lib\\english-left3words\\english-left3words-distsim.tagger");
		String tagged = tagger.tagString(input);
		System.out.println("Input = "+input);
		System.out.println(tagged);
		return tagged;
	}
	
	
	@Override
	public QuestionItem tag(QuestionItem qi) {
		MaxentTagger tagger = new MaxentTagger("D:\\Our Files\\Eric\\J2EE Mars\\question-classifier\\question-classifier\\questionclassifier\\lib\\english-left3words\\english-left3words-distsim.tagger");
		String[] tagged;
		//System.out.println("Running Question item tag..");
		for(Sentence s:qi.getSentences()){
			for(Word w:s.getWordList()){
				tagged = tagger.tagString(w.getWord()).split("_");
				System.out.println("."+tagged.toString());
				w.setPos(tagged[1]);
			}
		}	
		return qi;
	}
	
	

	
}
