package com.mysite.sbb.question.service;

import com.mysite.sbb.question.dao.QuestRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.question.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    @Autowired
    private QuestRepository questRepository;
    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questRepository.findAll(pageable);
    }

    public Question getQuestion(Integer id) {
        Optional<Question> opQuestion = this.questRepository.findById(id);
        if(opQuestion.isPresent()) {
            Question question = opQuestion.get();
            question.setViewCount(question.getViewCount() + 1);
            this.questRepository.save(question);
            return question;
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questRepository.save(q);
    }
}
