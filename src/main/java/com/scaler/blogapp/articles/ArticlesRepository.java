package com.scaler.blogapp.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findBySlug(String slug);
}
