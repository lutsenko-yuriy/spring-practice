package com.yurich.test.springpractice.bootstrap;

import com.yurich.test.springpractice.domain.Author;
import com.yurich.test.springpractice.domain.Book;
import com.yurich.test.springpractice.domain.Publisher;
import com.yurich.test.springpractice.repositories.AuthorRepository;
import com.yurich.test.springpractice.repositories.BookRepository;
import com.yurich.test.springpractice.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Publisher oreilly =
                new Publisher(
                        "O'Reilly",
                        "USA",
                        "Somewhere",
                        "Over the rainbow",
                        "In my ass"
                );

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "isbn", oreilly);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noejb = new Book("J2EE Development without EJB", "another isbn", oreilly);

        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);

        publisherRepository.save(oreilly);

        authorRepository.save(rod);
        bookRepository.save(noejb);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        System.out.println("Started in Bootstrap");
        System.out.println(
                "Loaded " +
                        bookRepository.count() + " " +
                        publisherRepository.count() + " " +
                        authorRepository.count()
        );
    }
}
