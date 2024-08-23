package com.avsoft.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avsoft.demo.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
