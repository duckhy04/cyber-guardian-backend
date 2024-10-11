package org.example.cyberguardianbackend.services.user.question;

import org.example.cyberguardianbackend.dto.QuestionDto;
import org.example.cyberguardianbackend.entity.Question;

public interface UserQuestionService {
    QuestionDto saveQuestion(QuestionDto questionDto);
}
