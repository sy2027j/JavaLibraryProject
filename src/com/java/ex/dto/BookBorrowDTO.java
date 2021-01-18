package com.java.ex.dto;

public class BookBorrowDTO {
	public String cust_id;
	public String BOOK_NAME;
	public String BOOK_AUTHOR;
	
	public BookBorrowDTO() {
		
	}
	
	public BookBorrowDTO(String cust_id, String BOOK_NAME, String BOOK_AUTHOR) {
		this.cust_id=cust_id;
		this.BOOK_NAME=BOOK_NAME;
		this.BOOK_AUTHOR=BOOK_AUTHOR;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}

	public String getBOOK_AUTHOR() {
		return BOOK_AUTHOR;
	}

	public void setBOOK_AUTHOR(String bOOK_AUTHOR) {
		BOOK_AUTHOR = bOOK_AUTHOR;
	}
	
	
}
