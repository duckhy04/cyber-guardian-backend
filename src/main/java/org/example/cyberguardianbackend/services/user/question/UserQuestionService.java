package org.example.cyberguardianbackend.services.user.question;

import org.example.cyberguardianbackend.dto.QuestionDto;

import java.util.List;

public interface UserQuestionService {
    QuestionDto addQuestion(QuestionDto questionDto, Long userId, Long categoryId);
    List<QuestionDto> getAllQuestions();
    List<QuestionDto> getQuestionsByUserId(Long userId);
}
