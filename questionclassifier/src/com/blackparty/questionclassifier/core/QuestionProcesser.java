package com.blackparty.questionclassifier.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.blackparty.questionclassifier.models.QuestionItem;
import com.blackparty.questionclassifier.models.Sentence;
import com.blackparty.questionclassifier.models.Word;

public class QuestionProcesser {
	private final String INTERROGATIVE = "interrogative";
	private final String DECLARATIVE = "declarative";
	private final String WH_REGEX = "[who|what|how|where|when|why|which|whose|whom]";
	private final String PUNCTUATION_REGEX = "[.?]";
	private final String NOUN = "NN";

	private Tagger t = new TaggerImpl();

	public void startProcess(String input) {
		QuestionItem qi = distribute(input);
		qi = t.tag(qi);

		showTagSentence(qi);
		Classifier c = new Classifier();
		c.classify(getHeadWord(qi));
	}
	
	public String getHeadWord(QuestionItem qi){
		String headword = "";
		boolean flag = false;
		for(Sentence e:qi.getSentences()){
			List<Word> wordList = e.getWordList();
			for(int i=0;i<wordList.size();i++){
				System.out.println(wordList.get(i).getWordName());
				String word = wordList.get(i).getWordName().toLowerCase();
				if(word.matches("why")||
						word.matches("what")||
						word.matches("when")||
						word.matches("whose")||
						word.matches("who")||
						word.matches("which")
						){
					System.out.println("HIT");
					flag = true;
				}
				if(flag){
					System.out.println(wordList.get(i).getWordName()+" = "+wordList.get(i).getPosTag());
					if(wordList.get(i).getPosTag().contains(NOUN)){
						headword = headword+" "+wordList.get(i).getWordName();
					}else {
						return headword;
					}
				}
			}
		}
		return headword;
	}
	
	public QuestionItem distribute(String input) {
		String regex = "[.?]";
		QuestionItem qi = new QuestionItem();
		List<Sentence> sentenceList = new ArrayList<>();
		Sentence s = null;

		String[] split = splitter(input);
		ArrayList<Word> wordList = new ArrayList<Word>();
		for (int i = 0; i < split.length; i++) {
			Word w = new Word();
			w.setWordName(split[i]);
			wordList.add(w);
			System.out.println("> " + w.getWordName());
			if (wordList.get(wordList.size() - 1).getWordName().matches(regex)) {
				System.out.println("hit!!!!!!!!!");
				if (wordList.get(wordList.size() - 1).getWordName().matches(".")) {
					// sentences that ends with period(.) means either
					// declarative or imperative.
					if (s == null) {
						System.out.println("First Sentence");
						s = new Sentence();
						s.setKindOfSentence(DECLARATIVE);
						s.setWordList(wordList);
					} else {
						sentenceList.add(s);
						s = new Sentence();
					}
				} else {
					// sentence that ends with question mark(?) means
					// interrogative.
					if (s == null) {
						System.out.println("First Sentence");
						s = new Sentence();
						s.setKindOfSentence(INTERROGATIVE);
						s.setWordList(wordList);
					} else {
						sentenceList.add(s);
						s = new Sentence();
					}
				}
			}
		}
		if(s != null){
			sentenceList.add(s);
		}
		qi.setSentences(sentenceList);
		return qi;
	}

	public String[] splitter(String input) {
		// System.out.println("Input = " + input);
		String regex = " ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?";
		return input.split(regex);
	}

	public QuestionItem showTagSentence(QuestionItem qi) {
		List<Sentence> sList = qi.getSentences();
		System.out.println("show tag sentence..\n" + qi.getSentences().size() + "\n");
		for (Sentence e : sList) {
			// read each sentence
			List<Word> wList = e.getWordList();

			// read each word on the sentence list
			for (int i = 0; i < wList.size(); i++) {
				System.out.print("[" + wList.get(i).getWordName() + " | ");
				System.out.print(wList.get(i).getPosTag() + "]");
			}
		}
		return qi;
	}
}
