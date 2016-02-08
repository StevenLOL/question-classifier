package com.blackparty.questionclassifier.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.TextPosition;
import org.springframework.web.multipart.MultipartFile;


import com.blackparty.questionclassifier.models.Item;
import com.blackparty.questionclassifier.models.Page;
import com.blackparty.questionclassifier.models.User;

public class Uploader {
	private static String question_regex = "^(\\[X=\\d*\\.?\\d*\\]\\[Y=\\d*\\.?\\d*\\])\\s*(Q\\d+\\.)\\s*(.*([^a-zA-Z\\d+]|[.*]))+";
	private String dataDirectory = System.getProperty("catalina.base")
			+ "/User";

	private boolean flag = false;

	public Uploader() {
		dataDirectoryValidate();
	}

	public boolean dataDirectoryValidate() {
		File f = new File(dataDirectory);
		if (!f.exists()) {
			System.out.println("Cannot find directory for data.");
			f.mkdir();
			System.out.println("User directory created at " + dataDirectory);
		}
		return false;
	}

	public File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		System.out.print("multipart");
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

	public boolean upload(MultipartFile file, User user, String category)
			throws Exception {

		//byte[] bytes = file.getBytes();
		String userDirectory = dataDirectory + "/" + user.getUsername();
		userDirectoryValidate(userDirectory, user);
		userDirectory = dataDirectory + "/" + user.getUsername() + "/";
		File convertedFile = multipartToFile(file);
		//FileOutputStream bos = new FileOutputStream(userDirectory + "/"
		//		+ convertedFile);
		//BufferedOutputStream stream = new BufferedOutputStream(bos);
		//stream.write(bytes);
		//stream.close();
		//bos.close();
		System.out.println("Uncropped File uploaded at " + userDirectory);

		/*
		 * Yeyah
		 */

		ArrayList<Page> byPage = processTextPosition(convertedFile);

		System.out.println("im back");
		if (byPage.isEmpty()) {
			System.out.print("it's empty");
		} else {
			String nfilename = file.getOriginalFilename().split("\\.")[0];
			ArrayList<Item> byitem = parseQandC(byPage, nfilename);
			byitem = getItemPositiononPage(byitem);
			setRectangle(byitem,userDirectory + "/",convertedFile);
		}
		return flag;
	}
	
	public ArrayList<Page> processTextPosition(File file) throws IOException {
		System.out.print("ProcessTextPosition Method >>");
		PDDocument document = null;

		document = PDDocument.load(file);
		if (document.isEncrypted()) {
            try {
                document.decrypt("");
            } catch (InvalidPasswordException e) {
                System.err.println("Error: Document is encrypted with a password.");
                System.exit(1);
            } catch (CryptographyException ex) {
                Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		String text;
		
		ArrayList<Page> byPage = new ArrayList<Page>();

		PDFTextStripper stripper = new PDFTextStripper() {
			@Override
			protected void startPage(PDPage page) throws IOException {
				startOfLine = true;
				super.startPage(page);
			}

			@Override
			protected void writeLineSeparator() throws IOException {
				startOfLine = true;
				super.writeLineSeparator();
			}

			@Override
			protected void writeString(String text,
					List<TextPosition> textPositions) throws IOException {
				if (startOfLine) {
					TextPosition firstProsition = textPositions.get(0);
					writeString(String.format("[X=%s]", firstProsition.getX()));
					writeString(String.format("[Y=%s]", firstProsition.getY()));

					startOfLine = false;
				}
				super.writeString(text + " ", textPositions);
			}

			boolean startOfLine = true;
		};
		List<PDPage> allPages =  document.getDocumentCatalog().getAllPages();
		for (int pagenum = 0; pagenum < allPages.size()+1; pagenum++) {
            stripper.setStartPage(pagenum);
            stripper.setEndPage(pagenum);
            text = stripper.getText(document);
            //  System.out.println("page = " + pagenum + "\ncontent = " + text);

            Page page = new Page(text,pagenum);
            byPage.add(page);
        }

		document.close();
		return byPage;
	}
	public ArrayList<Item> getItemPositiononPage(ArrayList<Item> byitem){
		int flag=0;
		System.out.println("getItemPositiononPage");
		for(int i=0; i < byitem.size() ; i++){
			if((i!=0 ) && byitem.get(i).getPagenum() == byitem.get(i-1).getPagenum()){
				flag++;
				byitem.get(i).setPosition(flag);
			}else{
				flag=0;
				byitem.get(i).setPosition(flag);
			}
			//System.out.println(byitem.get(i).getItemNumber() +"  >  "+byitem.get(i).getPosition());
		}
		return byitem;
	}
	/*
	 * public boolean upload(MultipartFile file, User user, String category)
	 * throws Exception { byte[] bytes = file.getBytes(); String userDirectory =
	 * dataDirectory + "/" + user.getUsername();
	 * userDirectoryValidate(userDirectory, user); userDirectory = dataDirectory
	 * + "/" + user.getUsername() + "/" + category; File f = new
	 * File(userDirectory + "/" + file.getOriginalFilename() + ".pdf");
	 * FileOutputStream bos = new FileOutputStream(f); BufferedOutputStream
	 * stream = new BufferedOutputStream(bos); stream.write(bytes);
	 * stream.close(); System.out.println("File uploaded at " + userDirectory);
	 * return flag; }
	 */
	public boolean userDirectoryValidate(String userDirectory, User user) {
		System.out.println("userDirval");
		File f = new File(userDirectory);
		if (!f.exists()) {
			System.out.println("Cannot find directory for "
					+ user.getUsername() + ".");
			f.mkdir();
			System.out.println("Directory for " + user.getUsername()
					+ " is created. at " + userDirectory);
			File f1 = new File(userDirectory + "/Knowledge");
			File f2 = new File(userDirectory + "/Process");
			File f3 = new File(userDirectory + "/Understanding");
			File f4 = new File(userDirectory + "/Product");
			File f5 = new File(userDirectory + "/temp");
			f1.mkdir();
			System.out.println("Knowledge folder for " + user.getUsername()
					+ " is created.");
			f2.mkdir();
			System.out.println("Process folder for " + user.getUsername()
					+ " is created.");
			f3.mkdir();
			System.out.println("Understanding folder for " + user.getUsername()
					+ " is created.");
			f4.mkdir();
			System.out.println("Product folder for " + user.getUsername()
					+ " is created.");
			f5.mkdir();
			System.out.println("temp folder for " + user.getUsername()
					+ " is created.");
		}
		return false;
	}

	public ArrayList<Item> parseQandC(ArrayList<Page> bypage, String filename) throws IOException {
		System.out.println("parseQandC");
		double[] coordinates = new double[2];
		ArrayList<Item> byitem = new ArrayList<Item>();
		int index = 0;
		Pattern q_regex = Pattern.compile(question_regex);
		Matcher q_matcher;
		for (Page perPage : bypage) {
			Scanner scanner = new Scanner(perPage.getText());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				q_matcher = q_regex.matcher(line);
				while (q_matcher.find()) {
					String token = q_matcher.group(0);
					//System.out.println("page ==  token > "+perPage.getPagenum()+" ==  " + token);
					Item item = new Item();
					item.setFilename(filename);
					item.setItemNumber("Q" + (index + 1));
					item.setPageNum(perPage.getPagenum());
					coordinates = getFloat(line);
					item.setxCoordinate(coordinates[0]);
					item.setyCoordinate(coordinates[1]);
					item.setText(token);
					index++;
					byitem.add(item);
				}
			}
			scanner.close();
		}
		return byitem;
	}

	public double[] getFloat(String s) {
		double digit[] = new double[2];
		int countO = 0, countC = 0;
		String[] str = { "", "" };
		if (s != null && !s.isEmpty()) {
			for (char c : s.toCharArray()) {
				// System.out.println("c > " + c);
				if (Character.isDigit(c) || c == '.') {
					if (countO == 1) {
						str[0] += c;
					} else {
						str[1] += c;
					}
				}
				if (c == '[') {
					countO++;
				}
				if (c == ']') {
					countC++;
				}
				if (countC == 1 && countO == 1) {
					// System.out.println("Str > " + str[0]);
					digit[0] = Double.parseDouble(str[0]);
				}
				if (countC == 2 && countO == 2) {
					// System.out.println("Str > " + str[1]);
					digit[1] = Double.parseDouble(str[1]);
					break;
				}
			}
		}
		return digit;
	}
	
	public void setRectangle(ArrayList<Item> byitem, String userDirectory, File file){

		PDDocument document = null;
		try {
			document = PDDocument.load(file);
		for(int index =0 ; index < byitem.size()+1; index++){
			PDRectangle rectangle = new PDRectangle();
			PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(byitem.get(index).getPagenum()-1);
			
			PDDocument doc = new PDDocument();
			doc.addPage(page);
			
			PdfTextParser parser = new PdfTextParser();
			String question = parser.parseText(doc, byitem.get(index).getPosition());
			System.out.println("returned question "+question);
			byitem.get(index).setQuestion(question);
			byitem.get(index).setCategory("Knowledge");
			doc.close();
			
			if ((index + 1) < byitem.size()+1 && byitem.get(index).getPagenum() == byitem.get(index+1).getPagenum()) {
				rectangle.setUpperRightY(842 - ((float) byitem.get(index + 1).getyCoordinate() - 20));
				rectangle.setLowerLeftY(842 - ((float) byitem.get(index).getyCoordinate() - 30)); // 0.0
			}else {
				rectangle.setUpperRightY(842 - ((float) byitem.get(index).getyCoordinate() - 30)); // 842
													// (float)byitem.get(i+1).getyCoordinate()+20
				rectangle.setLowerLeftY(842 - 782); // 0.0
			}

			rectangle.setUpperRightX(page.findCropBox().getUpperRightX());
			rectangle.setLowerLeftX(page.findCropBox().getLowerLeftX());
			page.setCropBox(rectangle);
			
			PDDocument croppedDoc = null;
			croppedDoc = new PDDocument();
			croppedDoc.addPage(page);

			croppedDoc.save(userDirectory+byitem.get(index).getCategory()+"/"+byitem.get(index).getFilename() + "-"+byitem.get(index).getItemNumber()+ ".pdf");
			croppedDoc.close();

		}
			document.close();

		} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(">> "+e+" setRectangle");
			} catch (COSVisitorException e) {
			System.out.println( ">> "+e+" setRectangle");
		}
	}
	
}
