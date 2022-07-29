package com.lms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Employee {
	private int employeeId;
	private int empName;
	private int numberOfBooksIssued;
	private int phoneNumber;
}
