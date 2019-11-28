package com.fellipy.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fellipy.workshopmongodb.dto.AuthorDTO;

@Document(collection = "post")
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String body;
	private String title;
	private Date date;
	private AuthorDTO author;
	
	public Post() {
	}
	
	public Post(String id, String body, String title, java.util.Date date2, AuthorDTO user) {
		super();
		this.id = id;
		this.body = body;
		this.title = title;
		this.date = date2;
		this.author = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO user) {
		this.author = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
