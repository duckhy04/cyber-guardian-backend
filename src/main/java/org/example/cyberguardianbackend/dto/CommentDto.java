package org.example.cyberguardianbackend.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private String userName;
    private byte[] byteImage;
    private MultipartFile image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
