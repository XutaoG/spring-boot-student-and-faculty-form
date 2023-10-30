package com.taoge.springmvcdemo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SchoolEntity
{
	// ***** Fields *****

	@NotNull(message = "is required")
	private String firstName = "";

	@NotNull(message = "is required")
	private String lastName = "";

	private String schoolEntityType;

	// ***** Getters/Setters *****

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getSchoolEntityType()
	{
		return schoolEntityType;
	}

	public void setSchoolEntityType(String schoolEntityType)
	{
		this.schoolEntityType = schoolEntityType;
	}

	public boolean isFaculty()
	{
		return (schoolEntityType.compareTo("Faculty") == 0);
	}

	public boolean isStudent()
	{
		return (schoolEntityType.compareTo("Student") == 0);
	}
}
