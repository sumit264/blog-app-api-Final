package com.dream.blog.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login_Tb") 

@NoArgsConstructor 
@Getter 
@Setter
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;

	@Column(name = "userName", nullable = false, length = 100) 
	private String userName;
	private String password;
}
