package com.blackparty.questionclassifier.models;

import org.apache.pdfbox.pdmodel.PDPage;

public class Page {
	  private String text;
	    private PDPage page;

	    public Page() {
	    }

	    public Page(String text, PDPage page) {
	        this.text = text;
	        this.page = page;
	    }

	    public String getText() {
	        return text;
	    }

	    public void setText(String text) {
	        this.text = text;
	    }

	    public PDPage getPage() {
	        return page;
	    }

	    public void setPage(PDPage page) {
	        this.page = page;
	    }
}
