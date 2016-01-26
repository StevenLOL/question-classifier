package com.blackparty.questionclassifier.core;

import com.blackparty.questionclassifier.models.QuestionItem;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public interface Tagger {
	public String tagged = "";
	public String tag(String input);
	public QuestionItem tag(QuestionItem qi);
}
