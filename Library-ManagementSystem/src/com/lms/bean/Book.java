package com.lms.bean;

public class Book {
	
	private String bookName;
	private int isbnNumber;
	private String authorName;
	private String publisherName;
	
	public Book(String bookName, int isbnNumber, String authorName, String publisherName) {
		super();
		this.bookName = bookName;
		this.isbnNumber = isbnNumber;
		this.authorName = authorName;
		this.publisherName = publisherName;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getIsbnNumber() {
		return isbnNumber;
	}
	
	public void setIsbnNumber(int isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
