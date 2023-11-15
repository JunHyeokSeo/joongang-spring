package com.ch.hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody
//DTO 객체를 JSON 형태로 변환하는 역할 (Jackson Library + @ResponseBody)
@RestController
public class SampleController {
	@RequestMapping("/sample")
	//@ResponseBody : @RestController 안에 이미 정의되어 있기 때문에 별도로 지정할 필요 없음
	//{"mno":23,"firstName":"홍","lastName":"길동"}
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		return sv;
	}

	@RequestMapping("/list")
	public List<SampleVo> list() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		for (int i = 1; i <= 10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			list.add(sv);
		}
		return list;
	}
}