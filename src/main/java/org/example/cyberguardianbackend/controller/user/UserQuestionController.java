package org.example.cyberguardianbackend.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.cyberguardianbackend.dto.QuestionDto;
import org.example.cyberguardianbackend.services.user.question.UserQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserQuestionController {

    private final UserQuestionService userQuestionService;

    @PostMapping("/question")
    public ResponseEntity<QuestionDto> saveQuestion(@RequestBody QuestionDto questionDto) {
        QuestionDto question = userQuestionService.saveQuestion(questionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        List<QuestionDto> questions = userQuestionService.getAllQuestions();
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }
}
