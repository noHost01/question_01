package com.mysite.sbb.question.dao;

import com.mysite.sbb.question.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
