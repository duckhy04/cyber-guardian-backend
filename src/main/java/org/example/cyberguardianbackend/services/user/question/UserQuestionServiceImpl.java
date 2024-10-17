package org.example.cyberguardianbackend.services.user.question;

import org.example.cyberguardianbackend.dto.QuestionDto;
import org.example.cyberguardianbackend.entity.Category;
import org.example.cyberguardianbackend.entity.Question;
import org.example.cyberguardianbackend.entity.User;
import org.example.cyberguardianbackend.enums.QuestionStatus;
import org.example.cyberguardianbackend.repository.CategoryRepository;
import org.example.cyberguardianbackend.repository.QuestionRepository;
import org.example.cyberguardianbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserQuestionServiceImpl implements UserQuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public UserQuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public QuestionDto addQuestion(QuestionDto questionDto, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow();
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        Question question = new Question();
        question.setTitle(questionDto.getTitle());
        question.setContent(questionDto.getContent());
        question.setUser(user);
        question.setCategory(category);
        question.setQuestionStatus(QuestionStatus.OPEN);
        question.setCreatedAt(LocalDateTime.now());

        return questionRepository.save(question).getQuestionDto();
    }

    public List<QuestionDto> getAllQuestions(){
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(Question::getQuestionDto).collect(Collectors.toList());
    }
}
