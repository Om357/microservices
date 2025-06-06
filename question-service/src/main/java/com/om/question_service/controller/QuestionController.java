package com.om.question_service.controller;

import com.om.question_service.model.Question;
import com.om.question_service.model.QuestionWrapper;
import com.om.question_service.model.Response;
import com.om.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired // Spring will handle this class objects .
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
    return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){ // here as we are gone mention JAVA in address path of URL , we have to make sure about matching that into its parameter.
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){ // you are specifying that JSON data will be passed by client which Spring will convert it and store in DB.
                //RequestBody means you are sending the data in Request format and that data is present in The body.
    return questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestionById(@PathVariable int id){
        return questionService.deleteQuestionById(id);
    }

    // generate questions for QUIZ service
    // give quiz a questions based on the questionID ()
    // getScore (method to implement for quiz service)

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam int numQuestions){
        return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
