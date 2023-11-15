package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

	@RequestMapping("/addr")
	//@RequestParam을 사용하면 매개변수와 Request parameter의 이름이 서로 달라도 명시적으로 매핑할 수 있다.
	//기본적으로 request parameter는 String으로 넘어온다.
	//@RequestParam()을 사용하고 매개변수의 자료형을 원하는 자료형으로 변환한다면 자동으로 형변환되어 삽입된다.
	public String addr(@RequestParam("name") String name, @RequestParam("addr") String addr, Model model) {
		System.out.println("name = " + name);
		System.out.println("addr = " + addr);

		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}

	@RequestMapping("/addr2")
	public String addr2(Person p, Model model) {
		model.addAttribute("person", p);
		return "addr2";
	}
}