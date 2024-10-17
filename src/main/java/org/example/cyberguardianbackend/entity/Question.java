package org.example.cyberguardianbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.cyberguardianbackend.dto.QuestionDto;
import org.example.cyberguardianbackend.enums.QuestionStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;

    private Long viewsCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public QuestionDto getQuestionDto(){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(id);
        questionDto.setTitle(title);
        questionDto.setContent(content);
        questionDto.setUserName(user.getName());
        questionDto.setCategoryName(category.getName());
        questionDto.setQuestionStatus(questionStatus);
        questionDto.setViewsCount(viewsCount);
        questionDto.setCreatedAt(createdAt);
        questionDto.setUpdatedAt(updatedAt);
        return questionDto;
    }

}
