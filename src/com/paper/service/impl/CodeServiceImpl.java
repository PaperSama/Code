package com.paper.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paper.entity.Code;
import com.paper.mapper.CodeMapper;
import com.paper.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	CodeMapper codeMapper;
	
	void setCodeMapper(CodeMapper codeMapper) {
		this.codeMapper = codeMapper;
	}
	
	String regex = "\\d{1}";
	ArrayList<Code> allCode;
	
	@Override
	public String toCode(String text) {
		allCode = codeMapper.queryAllCode();
		ArrayList<Code> answer = new ArrayList<>();
		char[] text_charArray = text.toCharArray();
		for(Character text_char : text_charArray){
			String text_String = text_char.toString();
			boolean has = false;
			for(Code code : allCode) {
				if(text_String.equals(code.getText())){
					has = true;
					answer.add(code);
					break;
				}
			}
			if(!has) {
				Code code = new Code(allCode.size(),text_String);
				System.out.println(code.getCode()+"---"+code.getText());
				codeMapper.addNewCode(code);
				answer.add(code);
			}
		}
		StringBuffer answer_string = new StringBuffer();
		for(Code code : answer) {
			answer_string.append(code.getCode()+" ");
		}
		return answer_string.toString();
	}

	@Override
	public String toText(String code) {
		allCode = codeMapper.queryAllCode();
		char[] code_charArray = code.toCharArray();
		StringBuffer code_group = new StringBuffer();
		boolean jam = false;
		ArrayList<Code> answer = new ArrayList<>();
		for(Character code_char : code_charArray) {
			if(code_char.toString().matches(regex)) {				
				code_group.append(code_char);			
			}else {
				if(!(code_char == 32)) {
					jam = true;
				}
			}
			if(code_group.length()==4) {
				for(Code c : allCode) {
					if(c.getCode()==Integer.parseInt(code_group.toString())) {
						answer.add(c);
					}
					break;
				}
				answer.add(new Code(Integer.parseInt(code_group.toString()),"?"));
			}
		}
		StringBuffer answer_string = new StringBuffer();
		for(Code c : answer) {
			answer_string.append(c.getText());
		}
		if(jam) {
			answer_string.append(" ***");
		}
		return answer_string.toString();
	}
}