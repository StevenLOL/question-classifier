package com.blackparty.questionclassifier.core;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
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

		byte[] bytes = file.getBytes();
		String userDirectory = dataDirectory + "/" + user.getUsername();
		userDirectoryValidate(userDirectory, user);
		userDirectory = dataDirectory + "/" + user.getUsername() + "/"
				+ category;
		File convertedFile = multipartToFile(file);
		FileOutputStream bos = new FileOutputStream(userDirectory + "/"
				+ convertedFile);
		BufferedOutputStream stream = new BufferedOutputStream(bos);
		stream.write(bytes);
		stream.close();
		bos.close();
		System.out.println("Uncropped File uploaded at " + userDirectory);

		/*
		 * Yeyah
		 */

		ArrayList<Page> byPage = processTextPosition(convertedFile);

		System.out.println("im back");
		if (byPage.isEmpty()) {
			System.out.print("it's empty");
		} else {
			ArrayList<Item> byitem = parseQandC(byPage);
			setRectangle(byitem,
					userDirectory + "/" + file.getOriginalFilename());
		}
		return flag;
	}

	public ArrayList<Page> processTextPosition(File file) throws IOException {
		System.out.print("ProcessTextPosition Method >>");
		PDDocument document = null;

		document = PDDocument.load(file);
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

		for (PDPage page : document.getDocumentCatalog().getPages()) {
			PDDocument newdoc = new PDDocument();
			newdoc.addPage(page);
			newdoc.close();
			text = stripper.getText(newdoc);

			// System.out.println("page >>"+pagenum+"\n"+text);

			Page newpage = new Page(text, page);
			byPage.add(newpage);
		}

		document.close();
		return byPage;
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
		}
		return false;
	}

	public ArrayList<Item> parseQandC(ArrayList<Page> bypage) {
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
					// System.out.println("token > " + token);
					Item item = new Item();
					item.setItemNumber("Q" + (index + 1));
					item.setPage(perPage.getPage());
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

	public void setRectangle(ArrayList<Item> byitem, String userDirectory) throws IOException{
		for(int index =0 ; index < byitem.size() ; index++){
			PDRectangle rectangle = new PDRectangle();
			
			PDPage page = byitem.get(index).getPage();

			System.out.println("MAO NI PAGE GI PROCESS " + page);
			System.out.println("THIS IS the text" + byitem.get(index).getText());
			
			if ((index + 1) < byitem.size() && page == byitem.get(index + 1).getPage()) {
				rectangle.setUpperRightY(842 - ((float) byitem.get(index).getyCoordinate() - 30));
				rectangle.setLowerLeftY(842 - ((float) byitem.get(index + 1).getyCoordinate() - 20)); // 0.0
			}else {
				rectangle.setUpperRightY(842 - ((float) byitem.get(index).getyCoordinate() - 30)); // 842
													// (float)byitem.get(i+1).getyCoordinate()+20
				rectangle.setLowerLeftY(842 - 782); // 0.0
			}
			rectangle.setUpperRightX(page.getCropBox().getUpperRightX());
			rectangle.setLowerLeftX(page.getCropBox().getLowerLeftX());
			page.setCropBox(rectangle);
			
			PDDocument croppedDoc = null;
			croppedDoc = new PDDocument();
			croppedDoc.addPage(page);
			croppedDoc.save(userDirectory + byitem.get(index).getItemNumber()+ ".pdf");
			croppedDoc.close();
		}
	}
}
