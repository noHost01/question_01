package com.mysite.sbb.question.service;

import com.mysite.sbb.question.dao.AnswerRepository;
import com.mysite.sbb.question.domain.Answer;
import com.mysite.sbb.question.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setReplyLike(false);
        this.answerRepository.save(answer);
    }

    public void setLike(Integer answerId) {
        Answer answer = answerRepository.findById(answerId).get();
        if(answer.getReplyLike() == true) {
            answer.setReplyLike(false);
        } else {
            answer.setReplyLike(true);
        }
        this.answerRepository.save(answer);
    }
}
