package com.ch.ch07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value = "upload.do", method = RequestMethod.GET)
	public String uploadForm() {
		return "upload";
	}

	@RequestMapping(value = "upload.do", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile mf, Model model, HttpSession session) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();		// 첨부파일명
		int fileSize = (int) mf.getSize();              // 첨부파일 크기(Byte)
		//request 객체를 사용하기 위해선 정의하는 과정이 필요.
		//매개변수로 session을 받아오기 때문에 간단하게 session 사용
		String path = session.getServletContext().getRealPath("/upload");
		
//		방법1. 파일 업로드
//		FileOutputStream fos = new FileOutputStream(path + "/" + fileName);
//		fos.write(mf.getBytes());
//		fos.close();
		
//		방법2.
		mf.transferTo(new File(path+"/"+fileName));
		 
		System.out.println("path:"+ path);
		
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		return "uploadResult";
	}

	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("login.do")
	public String login(String id, String pass, HttpSession session, Model model) {
		if (id.equals("java") && pass.equals("1234")) {
			session.setAttribute("id", id);
			return "loginSuccess";
		} else {
			model.addAttribute("msg", "똑바로 입력해");
			return "loginForm";
		}
	}
}