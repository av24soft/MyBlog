package com.avsoft.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avsoft.demo.entity.Blog;
import com.avsoft.demo.repo.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	public Blog getBlogById(Long id) {
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		return optionalBlog.orElse(null); // Return the blog if found, or null if not
	}

	public void saveBlog(Blog blog) {
		blogRepository.save(blog);
	}

	public void deleteBlogById(Long id) {
		blogRepository.deleteById(id);
	}
}
