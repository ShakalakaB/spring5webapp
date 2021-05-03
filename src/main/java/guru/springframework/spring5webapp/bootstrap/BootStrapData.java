package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthroRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthroRepository authroRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthroRepository authroRepository, BookRepository bookRepository) {
        this.authroRepository = authroRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        this.bookRepository.save(book1);
        this.authroRepository.save(eric);

        System.out.println("numbers of books: " + this.bookRepository.count());
    }
}
