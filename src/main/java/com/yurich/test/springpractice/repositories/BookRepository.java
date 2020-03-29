package com.yurich.test.springpractice.repositories;

import com.yurich.test.springpractice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
