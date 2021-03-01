package ir.kalateh.firstApp.repo;

import ir.kalateh.firstApp.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
}
