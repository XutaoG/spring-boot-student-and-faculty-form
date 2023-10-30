package com.taoge.springmvcdemo.controller;

import com.taoge.springmvcdemo.model.SchoolEntity;
import com.taoge.springmvcdemo.model.Faculty;
import com.taoge.springmvcdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolController
{
	@Value("${schoolEntityTypes}")
	private List<String> schoolEntityTypes;

	@Value("${facultyTypes}")
	private List<String> facultyTypes;

	@Value("${studentGrades}")
	private List<String> studentGrades;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/getAddForm")
	public String getAddForm(Model model)
	{
		model.addAttribute("schoolEntity", new SchoolEntity());
		model.addAttribute("schoolEntityTypes", schoolEntityTypes);

		return "add-form";
	}

	@PostMapping("/processAddForm")
	public String processAddForm(@Validated @ModelAttribute("schoolEntity") SchoolEntity entity, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("schoolEntityTypes", schoolEntityTypes);
			return "add-form";
		}

		if (entity.isFaculty())
		{
			Faculty faculty = new Faculty();
			faculty.setFirstName(entity.getFirstName());
			faculty.setLastName(entity.getLastName());

			model.addAttribute("faculty", faculty);
			model.addAttribute("facultyTypes", facultyTypes);
			return "faculty-form";
		}
		Student student = new Student();
		student.setFirstName(entity.getFirstName());
		student.setLastName(entity.getLastName());

		model.addAttribute("student", student);
		model.addAttribute("studentGrades", studentGrades);
		return "student-form";
	}

	@PostMapping("/processFacultyForm")
	public String processFacultyForm(@Validated @ModelAttribute("faculty") Faculty faculty, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("faculty", faculty);
			model.addAttribute("facultyTypes", facultyTypes);
			return "faculty-form";
		}
		return "faculty-confirmation-form";
	}

	@PostMapping("/processStudentForm")
	public String processFacultyForm(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("student", student);
			model.addAttribute("studentGrades", studentGrades);
			return "student-form";
		}
		return "student-confirmation-form";
	}
}
