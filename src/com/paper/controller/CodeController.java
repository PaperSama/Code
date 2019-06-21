package com.paper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paper.service.impl.CodeServiceImpl;

@RestController
public class CodeController {
	
	@Autowired
	CodeServiceImpl codeService;
	
	void setCodeService(CodeServiceImpl codeService) {
		this.codeService = codeService;
	}
	
	@RequestMapping("toCode")
	String toCode(@RequestParam("translate_input") String input) {
		return codeService.toCode(input);
	}
	
	@RequestMapping("toText")
	String toText(@RequestParam("translate_input") String input) {
		return codeService.toText(input);
	}
}