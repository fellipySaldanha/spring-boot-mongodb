package com.fellipy.workshopmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fellipy.workshopmongodb.domain.Post;
import com.fellipy.workshopmongodb.services.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostResource {
	
	@Autowired
	private PostService service;		
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){				
		Post post = service.findById(id);		
		return ResponseEntity.ok().body(post);
	}
}