package org.example.cyberguardianbackend.dto;

import lombok.Data;
import org.example.cyberguardianbackend.enums.QuestionStatus;

import java.time.LocalDateTime;

@Data
public class QuestionDto {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String categoryName;
    private QuestionStatus questionStatus;
    private Long viewsCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
