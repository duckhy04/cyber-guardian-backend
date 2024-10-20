package org.example.cyberguardianbackend.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.cyberguardianbackend.dto.CommentDto;
import org.example.cyberguardianbackend.services.user.comment.UserCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserCommentController {
    private final UserCommentService userCommentService;

    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto, @RequestParam Long userId, @RequestParam Long questionId) throws IOException {
        CommentDto comment = userCommentService.saveComment(commentDto, userId, questionId);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
