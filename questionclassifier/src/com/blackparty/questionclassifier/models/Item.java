package com.blackparty.questionclassifier.models;


public class Item {
	  private String itemNumber;
	    private String text;
	    private int pagenum;
	    private double xCoordinate;
	    private double yCoordinate;

	    public Item() {
	    }

	    public Item(String text,String itemNumber, int pagenum, double xCoordinate, double yCoordinate) {
	        this.itemNumber = itemNumber;
	        this.xCoordinate = xCoordinate;
	        this.yCoordinate = yCoordinate;
	        this.text = text;
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
	    
	    
}
