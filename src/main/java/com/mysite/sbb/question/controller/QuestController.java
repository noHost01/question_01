package com.mysite.sbb.question.controller;

import com.mysite.sbb.question.dao.QuestRepository;
import com.mysite.sbb.question.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question")
@Controller
public class QuestController {
    @Autowired
    private QuestRepository questRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Question> showList() {
        return questRepository.findAll();
    }
}
