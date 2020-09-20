package com.snack.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snack.Entity.BoardEntity;

public interface boardRepository extends JpaRepository<BoardEntity, String> {
		
}

