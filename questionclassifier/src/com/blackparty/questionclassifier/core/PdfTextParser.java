package com.blackparty.questionclassifier.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class PdfTextParser {
	private static String question_regex = "^(Q\\d+\\.)\\s*(.*([^a-zA-Z\\d+]|[.*]))+";
	private static String choices_regex = "^([a-z]\\)\\s.*\\n*)+";
	
	public PdfTextParser() {

	}
	
	/*	public void openPDFile(String userDirectory, int position) throws FileNotFoundException, IOException{
//	String userDirectory = dataDirectory + "/" + user.getUsername() + "/"+ category;
		PDDocument document = null;
        COSDocument cosDoc = null;
        System.out.println("opedPDFile");
		File file = new File(userDirectory);
		if (file.isDirectory()) {
			System.out.println("hey im in");
            File[] listFiles = file.listFiles();
            for (File afile : listFiles) {
            	System.out.println("yeah biatch");
            	PDFParser parser = new PDFParser(new FileInputStream(afile));
                parser.parse();
                cosDoc = parser.getDocument();
                document = new PDDocument(cosDoc);
               // parseText(document);
            }
		}else{
			System.out.println("yeah biatch");
        	PDFParser parser = new PDFParser(new FileInputStream(file));
            parser.parse();
            cosDoc = parser.getDocument();
            document = new PDDocument(cosDoc);
            parseText(document,position);
		}
		document.close();
		cosDoc.close();
	
		
	}*/

	public String parseText(PDDocument document, int position) {
		System.out.println("ParseText");
		PDFTextStripper pdfStripper = null;
		String question = "";
		try {
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(document.getNumberOfPages());
			String parsedText = pdfStripper.getText(document);

			question = getQuestion(parsedText, position);
			//System.out.println("Question : "+question);
			document.close();
			
			
		} catch (IOException e) {
			System.out.println(">> "+e+" parsetext");
		}
		return question;
	}

	public String getQuestion(String parsedText, int position) {
		String question="";
		String others, choices;
		ArrayList<String> question_list = new ArrayList<String>();
		Pattern q_regex = Pattern.compile(question_regex);
		Pattern c_regex = Pattern.compile(choices_regex);
		Matcher q_matcher,c_matcher;
		try (Scanner scanner = new Scanner(parsedText)) {
			boolean qflag = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.equals(" ") & !line.matches("^(\\s*-\\s(\\d+)\\s-)$")) {
					question = "";
					others = "";
					choices = "";
					q_matcher = q_regex.matcher(line);
					c_matcher = c_regex.matcher(line);
					while (q_matcher.find()) {
						String token = q_matcher.group(0);
						question += token;
						qflag = true;
					}
					while (c_matcher.find()) {
                        String token = c_matcher.group(0);
                        choices += token;
                        qflag = false;
                    }
					if (!question.isEmpty()) {
                        question_list.add(question);
                    }
					if ((!line.matches(question_regex + "$"))&& (!line.matches(choices_regex + "$"))) {
						others = line;
					}
					if (!question_list.isEmpty()) {
                        if ((!others.isEmpty()) && qflag) {
                            String temp = question_list.get(question_list.size() - 1) + "\n" + others;
                            question_list.remove(question_list.size() - 1);
                            question_list.add(temp);
                        }
                    }
				}

			}
			
			return question_list.get(position);
		}
	}
	
}
