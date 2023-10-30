package com.taoge.springmvcdemo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Student extends SchoolEntity
{
	// ***** Fields *****

	@NotNull(message = "is required")
	private String grade;

	@Min(value = 0, message = "cannot be less than 0.0")
	@Max(value = 4, message = "cannot be more than 4.0")
	@NotNull(message = "is required")
	private Double gpa;

	private boolean hasFinancialAid;

	// ***** Getters/Setters *****

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public Double getGpa()
	{
		return gpa;
	}

	public void setGpa(Double gpa)
	{
		this.gpa = gpa;
	}

	public boolean getHasFinancialAid()
	{
		return hasFinancialAid;
	}

	public void setHasFinancialAid(boolean hasFinancialAid)
	{
		this.hasFinancialAid = hasFinancialAid;
	}
}
