package com.avsoft.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.avsoft.demo.entity.Blog;
import com.avsoft.demo.service.BlogService;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/create")
    public String createBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create-blog";
    }

    @PostMapping("/blogs/save")
    public String saveBlog(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blogs"; // Redirect to the blog list page
    }

    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "list-blogs";
    }
}
