package com.fellipy.workshopmongodb.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fellipy.workshopmongodb.domain.Post;
import com.fellipy.workshopmongodb.domain.User;
import com.fellipy.workshopmongodb.dto.AuthorDTO;
import com.fellipy.workshopmongodb.dto.CommentDTO;
import com.fellipy.workshopmongodb.repository.PostRepository;
import com.fellipy.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRespository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sfdDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		sfdDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRespository.deleteAll();
		userRepository.deleteAll();
				
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, "Vou viajar para São Paulo. Abraços!", "Partiu viagem", sfdDateFormat.parse("21/08/2019"), new AuthorDTO(maria));
		Post post2 = new Post(null, "Acordei feliz hoje!", "BOm dia", sfdDateFormat.parse("15/04/2019"),  new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sfdDateFormat.parse("21/03/2019"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sfdDateFormat.parse("22/03/2019"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sfdDateFormat.parse("23/03/2019"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRespository.saveAll(Arrays.asList(post1, post2));
		
		maria.getListPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
