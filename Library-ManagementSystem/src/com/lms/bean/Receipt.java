package com.lms.bean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
	private int receiptId;
	private Date issueDate;
	private Date returnDate;
	Employee employee = new Employee();
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public String getIssueDate() {
		return issueDate.toString();
	}
	public void setIssueDate(String issueDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date2=null;
		try {
		    //Parsing the String
		    date2 = dateFormat.parse(issueDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		this.issueDate = date2;
	}
	public String getReturnDate() {
		return returnDate.toString();
	}
	public void setReturnDate(String returnDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date2=null;
		try {
		    //Parsing the String
		    date2 = dateFormat.parse(returnDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		this.issueDate = date2;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
