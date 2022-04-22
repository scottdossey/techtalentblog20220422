package com.techtalentsouth.techtalentblog.blogposts;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> { 
	/* What goes in here are additional methods that aren't 
	 * provided by CrudRepository that we want to perform on our database
	 * table.  We don't just add methods with any name we want
	 * to do anything..... 
	 * 
	 * Instead the methods are scanned by Spring Boot when loading this 
	 * file...to determine queries we want to do on the database....
	 */
	
}
