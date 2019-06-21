package com.paper.entity;

public class Code {
	int Code;
	String text;
	public Code(int code, String text) {
		Code = code;
		this.text = text;
	}
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}