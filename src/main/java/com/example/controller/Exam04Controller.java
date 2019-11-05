package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/ex04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setupForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@RequestMapping("/register")
	public String register(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return index();
		}

		User user = new User();
		user.setAge(userForm.getIntAge());
		user.setName(userForm.getName());
		user.setComment(userForm.getComment());
		model.addAttribute("user", user);
		return "exam04-result";
	}

}
