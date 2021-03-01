package ir.kalateh.firstApp.repo;

import ir.kalateh.firstApp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
}
