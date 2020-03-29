package com.yurich.test.springpractice.bootstrap;

import com.yurich.test.springpractice.domain.Author;
import com.yurich.test.springpractice.domain.Book;
import com.yurich.test.springpractice.repositories.AuthorRepository;
import com.yurich.test.springpractice.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "isbn");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noejb = new Book("J2EE Development without EJB", "another isbn");

        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noejb);

        System.out.println("Started in Bootstrap");
        System.out.println("Loaded " + bookRepository.count());
    }
}
