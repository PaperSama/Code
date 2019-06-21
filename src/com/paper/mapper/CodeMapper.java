package com.paper.mapper;

import java.util.ArrayList;

import com.paper.entity.Code;

public interface CodeMapper {
	boolean addNewCode(Code code);
	ArrayList<Code> queryAllCode();
}