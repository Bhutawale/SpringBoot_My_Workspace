package com.example.onetomanymapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomanymapping.model.Answer;
import com.example.onetomanymapping.model.Question;
import com.example.onetomanymapping.service.QAImpl;

@RestController
@RequestMapping("/question_answer")
public class QAController 
{
	@Autowired
	private QAImpl  s;

	@PostMapping("/question")
	public void add(@RequestBody Question que)
	{
		s.addQuestion(que);
	}
	
	@DeleteMapping("/deletebyid/{qid}")
	public void delete(@PathVariable int qid)
	{
		s.deleteQuestion(qid);
	}
	
	@GetMapping("/showanswers/{qid}")
	public List<Answer> showallanswerofquestion(@PathVariable Question qid)
	{
		return s.showallanswerofquestion(qid);
	}
}