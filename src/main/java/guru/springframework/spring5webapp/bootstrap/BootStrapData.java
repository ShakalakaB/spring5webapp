package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthroRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthroRepository authroRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthroRepository authroRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authroRepository = authroRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setAddress("NY");
        publisherRepository.save(publisher);

        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        bookRepository.save(book1);
        authroRepository.save(eric);
        publisherRepository.save(publisher);

//        System.out.println("numbers of books: " + bookRepository.count());
//        System.out.println("numbers of publisher: " + publisherRepository.count());
    }
}
