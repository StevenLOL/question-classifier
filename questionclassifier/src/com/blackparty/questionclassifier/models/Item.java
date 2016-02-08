package com.blackparty.questionclassifier.models;

public class Item {
	private String itemNumber;
	private String filename;
	private String question;
	private String text;
	private int pagenum;
	private int position;
	private double xCoordinate;
	private double yCoordinate;
	private String category;

	public Item() {
	}

	public Item(String text, String category, String question,
			String itemNumber, int pagenum, double xCoordinate,
			double yCoordinate, int position, String filename) {
		this.itemNumber = itemNumber;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.text = text;
		this.pagenum = pagenum;
		this.position = position;
		this.question = question;
		this.category = category;
		this.filename = filename;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPageNum(int pagenum) {
		this.pagenum = pagenum;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
