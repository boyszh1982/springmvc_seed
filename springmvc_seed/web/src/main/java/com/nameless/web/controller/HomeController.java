package com.nameless.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nameless.model.CatVo;
import com.nameless.model.CatVoValidator;
import com.nameless.model.HomeVo;
import com.nameless.service.IHome;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private IHome homeService ;
	/**
	 * hibernate validator JSR303
	 * http://localhost:8080/web/toHome -> {"version1":"v1.1.0","host":"192.168.168.1"}
	 * @param homeVo
	 * @param result
	 * @return
	 */
	@RequestMapping(value="toHome",method=RequestMethod.POST)
	public ModelAndView toHome(@RequestBody @Valid HomeVo homeVo , BindingResult result ){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("invalid");
			mav.addObject("message",result.getFieldError().getDefaultMessage());
			return mav;
		}
		mav.setViewName("showMessage");
		mav.addObject("message", homeService.toHome(homeVo));
		return mav;
	}
	
	@RequestMapping(value="version/{v}",method=RequestMethod.GET)
	public @ResponseBody Object version(@PathVariable("v") String version){
		return version;
	}
}
