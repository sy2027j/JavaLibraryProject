package com.java.ex.dto;

public class bookDTO {
   private int BOOK_STOCK;
   private String BOOK_NAME;
   private int BOOK_CODE;
   private String BOOK_AUTHOR;
   private String BOOK_COMPANY;
   private String FNAME;
 
   
   public bookDTO(){
      
   }
   
   public bookDTO(int BOOK_CODE,int BOOK_STOCK,String BOOK_NAME,String BOOK_AUTHOR,String BOOK_COMPANY){
      if(BOOK_NAME==null) BOOK_NAME="";
      if(BOOK_AUTHOR==null) BOOK_AUTHOR="";
      if(BOOK_COMPANY==null) BOOK_COMPANY="";
      
      this.BOOK_STOCK=BOOK_STOCK;
      this.BOOK_NAME=BOOK_NAME;
      this.BOOK_AUTHOR=BOOK_AUTHOR;
      this.BOOK_COMPANY=BOOK_COMPANY;
      this.BOOK_CODE=BOOK_CODE;
   }
   
   public bookDTO(String FNAME,int BOOK_CODE,int BOOK_STOCK,String BOOK_NAME,String BOOK_AUTHOR,String BOOK_COMPANY){
	      if(BOOK_NAME==null) BOOK_NAME="";
	      if(BOOK_AUTHOR==null) BOOK_AUTHOR="";
	      if(BOOK_COMPANY==null) BOOK_COMPANY="";
	      this.FNAME=FNAME;
	      this.BOOK_STOCK=BOOK_STOCK;
	      this.BOOK_NAME=BOOK_NAME;
	      this.BOOK_AUTHOR=BOOK_AUTHOR;
	      this.BOOK_COMPANY=BOOK_COMPANY;
	      this.BOOK_CODE=BOOK_CODE;
	   }

public int getBOOK_STOCK() {
	return BOOK_STOCK;
}

public void setBOOK_STOCK(int bOOK_STOCK) {
	BOOK_STOCK = bOOK_STOCK;
}

public String getBOOK_NAME() {
	return BOOK_NAME;
}

public void setBOOK_NAME(String bOOK_NAME) {
	BOOK_NAME = bOOK_NAME;
}

public int getBOOK_CODE() {
	return BOOK_CODE;
}

public void setBOOK_CODE(int bOOK_CODE) {
	BOOK_CODE = bOOK_CODE;
}

public String getBOOK_AUTHOR() {
	return BOOK_AUTHOR;
}

public void setBOOK_AUTHOR(String bOOK_AUTHOR) {
	BOOK_AUTHOR = bOOK_AUTHOR;
}

public String getBOOK_COMPANY() {
	return BOOK_COMPANY;
}

public void setBOOK_COMPANY(String bOOK_COMPANY) {
	BOOK_COMPANY = bOOK_COMPANY;
}

public String getFNAME() {
	return FNAME;
}

public void setFNAME(String fNAME) {
	FNAME = fNAME;
}


}



   
  