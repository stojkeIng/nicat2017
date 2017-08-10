package com.nicat2017.kopitaneskita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    public String helloWorld() {

        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(@RequestParam(value="n") String name) {

        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/questions")
    public Question greeting(@RequestParam(value="q", required = true) String question,
                             @RequestParam(value="a", required = false) String author) {

        Question newQuestion = new Question(question, author);
        questionRepository.save(newQuestion);
        return newQuestion;
    }

    @RequestMapping("/questions")
    public List<Question> getAllQuestions() {

        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }
}
