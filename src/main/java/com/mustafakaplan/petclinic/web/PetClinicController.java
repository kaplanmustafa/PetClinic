package com.mustafakaplan.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mustafakaplan.petclinic.service.PetClinicService;

@Controller
public class PetClinicController {

	@Autowired
	PetClinicService petClinicService;
	
	@RequestMapping("/owners")
	public ModelAndView getOwners() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("owners", petClinicService.findOwners());
		mav.setViewName("owners");
		
		return mav;
	}
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		
		return "Welcome to PetClinic World!";
	}
}
