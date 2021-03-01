package ir.kalateh.firstApp.bootstrap;

import ir.kalateh.firstApp.model.Author;
import ir.kalateh.firstApp.model.Book;
import ir.kalateh.firstApp.model.Publisher;
import ir.kalateh.firstApp.repo.AuthorRepo;
import ir.kalateh.firstApp.repo.BookRepo;
import ir.kalateh.firstApp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;
    
    public BootStrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Started in Bootstrap");
        
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        
        publisherRepo.save(publisher);
        
        System.out.println("Publisher Count: " + publisherRepo.count());
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        
        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);
        
        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
