package ua.kpi.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
