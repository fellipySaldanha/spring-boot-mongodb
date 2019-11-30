package com.fellipy.workshopmongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fellipy.workshopmongodb.domain.Post;
import com.fellipy.workshopmongodb.resources.util.URL;
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
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDateString,
 			@RequestParam(value="maxDate", defaultValue="") String maxDateString
 			) 
	{
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDateString, new Date(0L));
		Date max = URL.convertDate(maxDateString, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
