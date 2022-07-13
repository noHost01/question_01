package com.mysite.sbb.question.controller;

import com.mysite.sbb.question.dao.QuestRepository;
import com.mysite.sbb.question.domain.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question")
@Controller
@AllArgsConstructor
public class QuestController {

    private final QuestRepository questRepository;

    @RequestMapping("/list")
    public String showList(Model model) {
        List<Question> questionList = this.questRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
