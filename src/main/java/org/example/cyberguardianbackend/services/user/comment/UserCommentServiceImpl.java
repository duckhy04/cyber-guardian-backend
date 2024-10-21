package org.example.cyberguardianbackend.services.user.comment;

import org.example.cyberguardianbackend.dto.CommentDto;
import org.example.cyberguardianbackend.entity.Comment;
import org.example.cyberguardianbackend.entity.Question;
import org.example.cyberguardianbackend.entity.User;
import org.example.cyberguardianbackend.repository.CommentRepository;
import org.example.cyberguardianbackend.repository.QuestionRepository;
import org.example.cyberguardianbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCommentServiceImpl implements UserCommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public UserCommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public CommentDto saveComment(CommentDto commentDto, Long userId, Long questionId) throws IOException {
        User user = userRepository.findById(userId).orElseThrow();
        Question question = questionRepository.findById(questionId).orElseThrow();

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());

        // Kiểm tra xem có ảnh trong commentDto hay không
        comment.setImage(commentDto.getImage() != null && !commentDto.getImage().isEmpty() ? commentDto.getImage().getBytes() : null);

        comment.setUser(user);
        comment.setQuestion(question);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment).getCommentDto();
    }

    public List<CommentDto> getCommentByQuestionId(Long questionId) {
        List<Comment> comments = commentRepository.findByQuestionId(questionId);
        return comments.stream().map(Comment::getCommentDto).collect(Collectors.toList());
    }
}
