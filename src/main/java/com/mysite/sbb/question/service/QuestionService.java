package com.mysite.sbb.question.service;

import com.mysite.sbb.question.dao.QuestRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.util.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestRepository questRepository;
    public List<Question> getList() {
        return questRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
