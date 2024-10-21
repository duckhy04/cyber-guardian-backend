package org.example.cyberguardianbackend.services.user.comment;

import org.example.cyberguardianbackend.dto.CommentDto;

import java.io.IOException;
import java.util.List;

public interface UserCommentService {
    CommentDto saveComment(CommentDto commentDto, Long userId, Long questionId) throws IOException;
    List<CommentDto> getCommentByQuestionId(Long questionId);
}
