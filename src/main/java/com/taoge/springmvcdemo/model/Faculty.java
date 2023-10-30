package com.taoge.springmvcdemo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Faculty extends SchoolEntity
{
	// ***** Fields *****

	@NotNull(message = "is required")
	private String facultyType;

	@Min(value = 0, message = "cannot be less than 0.00")
	@NotNull(message = "is required")
	private Double salary;

	// ***** Getters/Setters *****

	public String getFacultyType()
	{
		return facultyType;
	}

	public void setFacultyType(String facultyType)
	{
		this.facultyType = facultyType;
	}

	public Double getSalary()
	{
		return salary;
	}

	public void setSalary(Double salary)
	{
		this.salary = salary;
	}
}
