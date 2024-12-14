package com.example.onetomanymapping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onetomanymapping.model.Answer;
import com.example.onetomanymapping.model.Question;

@Repository
public interface QADaoI extends JpaRepository<Question, Integer>
{
	@Query("select a from Answer a where a.question=?1")
	public List<Answer> findAllAnswersOfQuestion(Question qid);
}
