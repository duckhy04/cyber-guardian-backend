package org.example.cyberguardianbackend.services.user.question;

import org.example.cyberguardianbackend.dto.QuestionDto;
import org.example.cyberguardianbackend.entity.Question;

import java.util.List;

public interface UserQuestionService {
    QuestionDto saveQuestion(QuestionDto questionDto);
    List<QuestionDto> getAllQuestions();
}
