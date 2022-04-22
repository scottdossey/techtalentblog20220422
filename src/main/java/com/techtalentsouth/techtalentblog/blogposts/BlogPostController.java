package com.techtalentsouth.techtalentblog.blogposts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	
	/* Tell springboot to set this automatically via INJECTION */
	@Autowired
	private BlogPostRepository blogPostRepository;
		
	private static List<BlogPost> posts = new ArrayList<>();
	
	@GetMapping(value="/")
	public String index(Model model) {				
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}

	@GetMapping(value="/blogposts/new")
	public String newBlog(BlogPost post) {
		post.setAuthor("Scott Dossey");
		return "blogpost/new";
	}
	
	@PostMapping(value="/blogposts")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		//This method's goal is to save a blogPost entered
		//in the form to the database.
		BlogPost savedBlogPost = blogPostRepository.save(blogPost);
		posts.add(savedBlogPost);
		
		model.addAttribute("title", savedBlogPost.getTitle());
		model.addAttribute("author", savedBlogPost.getAuthor());
		model.addAttribute("blogEntry", savedBlogPost.getBlogEntry());
				
		return "blogpost/result";		
	}
	
}
