package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
