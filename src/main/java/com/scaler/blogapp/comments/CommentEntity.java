package com.scaler.blogapp.comments;


import com.scaler.blogapp.articles.ArticleEntity;
import com.scaler.blogapp.users.UserEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comments")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Nullable
    private String title;

    @NonNull
    private String body;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "articleId", nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private UserEntity author;


}
