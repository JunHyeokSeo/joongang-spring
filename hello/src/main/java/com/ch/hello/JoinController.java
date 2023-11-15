package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@RequestMapping("/join")
	//@ModelAttribute : 가입양식에서 넘어온 값을, DTO 객체를 통해 한번에 입력 받을 때 사용 (생략 가능)
	public String join(@ModelAttribute Member member, Model model) {
		System.out.println("id : " + member.getId());
		model.addAttribute("member", member);
		return "joinResult";
	}
}