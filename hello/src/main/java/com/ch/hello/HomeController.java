package com.ch.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//Client 요청을 받을 때 사용하는 어노테이션
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
//		prefix, suffix 생략 -> xml에서 지정한 값(prefix, suffix)이, return 할 때 붙어서 찾아간다고 생각.
		return "home";
	}

	@RequestMapping("/color")
	public String color(Model model) {
		String[] color = { "red", "orange", "yellow", "green", "blue", "navy", "violet" };
		int num = (int) (Math.random() * 7);
		model.addAttribute("color", color[num]);
		return "color";
	}

	@RequestMapping("/gugu")
	public String gugu(Model model) {
		int num = (int) (Math.random() * 8) + 2;
//		int a = num / 0;
		model.addAttribute("num", num);
		return "gugu";
	}
	/*
	 * @ExceptionHandler(ArithmeticException.class) 
	 * public String err() { 
	 * return
	 * "arr-err"; }
	 */
}