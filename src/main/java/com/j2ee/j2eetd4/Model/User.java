package com.j2ee.j2eetd4.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	String name;

	@Column(name = "mail")
	String mail;

	@Column(name = "birthday")
	Date birthday;

	@Column(name = "published")
	int gender;
}
