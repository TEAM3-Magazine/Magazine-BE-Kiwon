package com.sparta.pbl_week2.dto;

import com.sparta.pbl_week2.model.Like;
import com.sparta.pbl_week2.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private String contents;
        private String image_url;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private Long post_id;
        private Long user_id;
        private String user_name;
        private String contents;
        private String image_url;
        private String created_at;
        private List<Long> post_like;


        public Response(@NotNull Post post){
            this.post_id = post.getPostId();
            this.user_id = post.getUser().getUserId();
            this.user_name = post.getUser().getUserName();
            this.contents = post.getContents();
            this.image_url = post.getImageUrl();
            this.created_at = post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            post_like = new ArrayList<>();
            for(Like like : post.getLikelist()){
                post_like.add(like.getUser().getUserId());
            }

        }
    }


}
