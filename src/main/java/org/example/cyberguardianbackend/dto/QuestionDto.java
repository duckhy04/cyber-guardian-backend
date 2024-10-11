package org.example.cyberguardianbackend.dto;

import lombok.Data;
import org.example.cyberguardianbackend.enums.QuestionStatus;

@Data
public class QuestionDto {
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Long categoryId;

    private QuestionStatus questionStatus;

    private Long viewsCount;

    private String categoryName;

    private String userName;
}
