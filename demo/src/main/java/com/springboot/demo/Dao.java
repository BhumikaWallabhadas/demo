package com.springboot.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class Dao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 public void createTable() {
		 var query = "CREATE TABLE Book(BookId Varchar(255) PRIMARY KEY,BookName Varchar(255) NOT NULL,Author Varchar(255) NOT NULL)";
		 int update = this.jdbcTemplate.update(query);
		 System.out.println(update);
		 
	 
	 }
}
