package com.springboot.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.Models.Book;
@Repository
public interface BookRepository  extends JpaRepository<Book,String> {


}
