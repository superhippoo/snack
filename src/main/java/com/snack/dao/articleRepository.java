package com.snack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snack.Entity.ArticleEntity;

public interface articleRepository extends JpaRepository<ArticleEntity, String> {
		
}

