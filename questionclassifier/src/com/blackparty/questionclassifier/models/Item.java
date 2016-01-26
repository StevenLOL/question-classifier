package com.blackparty.questionclassifier.models;

import org.apache.pdfbox.pdmodel.PDPage;

public class Item {
	  private String itemNumber;
	    private String text;
	    private PDPage page;
	    private double xCoordinate;
	    private double yCoordinate;

	    public Item() {
	    }

	    public Item(String text,String itemNumber, PDPage page, double xCoordinate, double yCoordinate) {
	        this.itemNumber = itemNumber;
	        this.page = page;
	        this.xCoordinate = xCoordinate;
	        this.yCoordinate = yCoordinate;
	        this.text = text;
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

	    public PDPage getPage() {
	        return page;
	    }

	    public void setPage(PDPage page) {
	        this.page = page;
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
	    
	    
}
