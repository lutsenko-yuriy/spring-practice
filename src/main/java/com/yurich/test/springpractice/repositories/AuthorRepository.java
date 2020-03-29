package com.yurich.test.springpractice.repositories;

import com.yurich.test.springpractice.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
