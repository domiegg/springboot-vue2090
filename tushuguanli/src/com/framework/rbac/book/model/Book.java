package com.framework.rbac.book.model;

public class Book {

	private Integer id;
	private String bookName;
	private String bookType;
	private Integer bookNumber;
	private String bookStatus;
	private String bookWriter;
	private String bookHouse;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookHouse() {
		return bookHouse;
	}
	public void setBookHouse(String bookHouse) {
		this.bookHouse = bookHouse;
	}
	
	
	
}
