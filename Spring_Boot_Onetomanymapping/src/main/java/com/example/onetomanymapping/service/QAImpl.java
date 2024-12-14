package com.example.onetomanymapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomanymapping.dao.QADaoI;
import com.example.onetomanymapping.model.Answer;
import com.example.onetomanymapping.model.Question;

@Service
public class QAImpl implements QAServiceI 
{
	@Autowired
	private QADaoI d;
	
	@Override
	public void addQuestion(Question que) 
	{
		d.save(que);
	}

	@Override
	public void deleteQuestion(int qid) 
	{
		d.deleteById(qid);
	}

	@Override
	public List<Answer> showallanswerofquestion(Question qid)
	{
		return d.findAllAnswersOfQuestion(qid);
	}

}
