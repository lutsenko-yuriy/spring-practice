package com.yurich.test.springpractice.repositories;

import com.yurich.test.springpractice.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
