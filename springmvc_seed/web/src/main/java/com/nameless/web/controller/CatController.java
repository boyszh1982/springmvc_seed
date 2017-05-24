package com.nameless.web.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nameless.model.CatVo;
import com.nameless.model.CatVoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/cat")
public class CatController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new CatVoValidator());
	}
	/**
	 * spring validator
	 * http://localhost:8080/web/showCat -> {"color":"null"}
	 * @param catVo
	 * @param result
	 * @return
	 */
	@RequestMapping(value="showCat",method=RequestMethod.POST)
	public ModelAndView showCat(@RequestBody @Validated CatVo catVo , BindingResult result ){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("invalid");
			mav.addObject("message", result.getFieldError().getDefaultMessage());
			return mav;
		}
		mav.setViewName("showMessage");
		mav.addObject("message", catVo.getColor());
		return mav;
	}
}
