package com.example.onetomanymapping.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Answer_Details")
public class Answer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Answer_Id")
	private int aid;
	
	@Column(name="Answer")
	private String ans;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;

	@JsonBackReference
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	
	public Answer(int aid, String ans, Question question) {
		super();
		this.aid = aid;
		this.ans = ans;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", ans=" + ans + ", question=" + question + "]";
	}

	
	
	
}
