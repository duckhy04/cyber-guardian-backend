package org.example.cyberguardianbackend.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.cyberguardianbackend.dto.CommentDto;
import org.example.cyberguardianbackend.services.user.comment.UserCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserCommentController {
    private final UserCommentService userCommentService;

    @PostMapping("/comment")
    public ResponseEntity<CommentDto> saveComment(@ModelAttribute CommentDto commentDto, @RequestParam Long userId, @RequestParam Long questionId) throws IOException {
        CommentDto comment = userCommentService.saveComment(commentDto, userId, questionId);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @GetMapping("/comment")
    public ResponseEntity<List<CommentDto>> getAllCommentByQuestionId(@RequestParam Long questionId) throws IOException {
        List<CommentDto> comments = userCommentService.getCommentByQuestionId(questionId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }
}
