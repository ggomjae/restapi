package com.gomjae.blog.webservice.dto.response;
import com.gomjae.blog.webservice.entity.post.Post;
import lombok.Getter;

@Getter
public class ResponsePostDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public ResponsePostDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
