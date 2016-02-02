package com.blackparty.questionclassifier.core;

import java.util.Collection;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

public class RelationshipExtractor {
	private String input;

    public RelationshipExtractor(){

    }

    public RelationshipExtractor(String input){
        this.input= input;
    }

    public Collection<TypedDependency> extract(String input){
        System.out.println("Input = "+input);
        LexicalizedParser lp = LexicalizedParser.loadModel(
        		"D:/Our Files/Eric/J2EE Mars/questionclassifier/lib/edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz",
        		"-maxLength",
        		"80", "-retainTmpSubcategories");
        TreebankLanguagePack tlp = new PennTreebankLanguagePack();
        GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
        
        //needs to include punctuation marks on the array.
        String[] sent = input.split(" ");
        Tree parse = lp.apply(Sentence.toWordList(sent));
        GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
        Collection<TypedDependency> tdl = gs.typedDependencies();
        System.out.println(tdl);

        return tdl;
    }
}
