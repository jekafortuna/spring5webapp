package ua.kpi.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ua.kpi.spring5webapp.model.Author;
import ua.kpi.spring5webapp.model.Book;
import ua.kpi.spring5webapp.model.Publisher;
import ua.kpi.spring5webapp.repositories.AuthorRepository;
import ua.kpi.spring5webapp.repositories.BookRepository;
import ua.kpi.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        /**
         * Erik - Author
         */
        Author erik = new Author("Erik", "Evans");
        Book bookErik1 = new Book("Domain Driven Design", "1234", publisher);
        erik.getBooks().add(bookErik1);
        bookErik1.getAuthors().add(erik);

        authorRepository.save(erik);
        bookRepository.save(bookErik1);

        /**
         * Rod - Author
         */
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "222455", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
