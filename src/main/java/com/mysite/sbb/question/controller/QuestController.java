package com.mysite.sbb.question.controller;

import com.mysite.sbb.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question")
@Controller
public class QuestController {
    @Autowired
    private QuestController questController;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(String title, String body) {

    }
}
