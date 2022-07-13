package com.mysite.sbb.question.dao;

import com.mysite.sbb.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Question, Integer> {
}
