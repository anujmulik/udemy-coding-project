package com.codingchallenge.quizlet.controller;

import com.codingchallenge.quizlet.entity.Question;
import com.codingchallenge.quizlet.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping("/api/question")
    public Question getQuestion(@RequestParam("question-id") String questionId) {
        return quizService.getQuestion(questionId);
    }

    @RequestMapping("/api/questions/all")
    public List<String> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    @RequestMapping("/api/answer")
    public String getAnswer(@RequestParam("question-id") String questionId, @RequestParam("answer") String answer) {
        return quizService.getAnswer(questionId, answer);
    }
}