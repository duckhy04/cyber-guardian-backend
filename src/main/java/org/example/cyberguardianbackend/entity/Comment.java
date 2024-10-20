package org.example.cyberguardianbackend.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.example.cyberguardianbackend.dto.CommentDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public CommentDto getCommentDto(){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(id);
        commentDto.setText(text);
        commentDto.setUserName(user.getName());
        commentDto.setByteImage(image);
        commentDto.setCreatedAt(createdAt);
        commentDto.setUpdatedAt(updatedAt);
        return commentDto;
    }
}
