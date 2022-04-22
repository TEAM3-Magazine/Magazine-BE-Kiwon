package com.sparta.pbl_week2.service;

import com.sparta.pbl_week2.exception.ExistLike;
import com.sparta.pbl_week2.exception.NotFoundLike;
import com.sparta.pbl_week2.exception.NotFoundPost;
import com.sparta.pbl_week2.exception.NotFoundUser;
import com.sparta.pbl_week2.model.Like;
import com.sparta.pbl_week2.model.Post;
import com.sparta.pbl_week2.model.User;
import com.sparta.pbl_week2.repository.LikeRepository;
import com.sparta.pbl_week2.repository.PostRepository;
import com.sparta.pbl_week2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final PostService postService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public Like addlikes(Long userId, Long postId) {
        if (likeRepository.findByUser_UserIdAndPost_PostId(userId, postId).isPresent()) {
            throw new ExistLike();
        }
        User user = userRepository.findById(userId).orElseThrow(NotFoundUser::new);
        Post post = postRepository.findById(postId).orElseThrow(NotFoundPost::new);
//        Optional<Post> post = Optional.ofNullable(boardRepository.findById(boardId))
//                .orElseThrow(() -> new CustomException(BOARD_NOT_FOUND));
//        Optional<User> user = Optional.ofNullable(userRepository.findById(likesrequestDto.getUserId()))
//                .orElseThrow(() -> new CustomException(EMAIL_NOT_FOUND));
        Like like = new Like();
        post.addLikelist(like);
        user.addUsertoLike(like);
        likeRepository.save(like);
        return like;
    }

    @Transactional
    public void delete(Long userId, Long postId) {
        Like like = likeRepository.findByUser_UserIdAndPost_PostId(userId, postId).orElseThrow(NotFoundLike::new);
//        Optional<Likelist> likelist = Optional.ofNullable(likesRepository.findByUser_IdAndPost_Id(userId, postId))
//                .orElseThrow(() -> new CustomException(BOARD_NOT_FOUND));
        likeRepository.delete(like);
    }
}
