package com.snack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snack.Entity.ArticleEntity;

public interface articleRepository extends JpaRepository<ArticleEntity, String> {

	List<ArticleEntity> findBybrdNo(String brdNo);
		
}

