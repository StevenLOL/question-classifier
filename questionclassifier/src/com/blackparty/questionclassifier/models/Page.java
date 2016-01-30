package com.blackparty.questionclassifier.models;

import org.apache.pdfbox.pdmodel.PDPage;

public class Page {
	  private String text;
	  private int pagenum;

	    public Page() {
	    }

	    public Page(String text,int pagenum) {
	        this.text = text;
	        this.pagenum = pagenum;
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

		public void setPagenum(int pagenum) {
			this.pagenum = pagenum;
		}

	  

	    
}
