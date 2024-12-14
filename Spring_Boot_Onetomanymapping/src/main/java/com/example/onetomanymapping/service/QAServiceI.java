package com.example.onetomanymapping.service;

import java.util.List;

import com.example.onetomanymapping.model.Answer;
import com.example.onetomanymapping.model.Question;

public interface QAServiceI
{
	public void addQuestion(Question que);
	
	public void deleteQuestion(int qid);
	
	public List<Answer> showallanswerofquestion(Question qid);
}
