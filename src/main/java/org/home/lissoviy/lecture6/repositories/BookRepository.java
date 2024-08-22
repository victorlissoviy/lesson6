package org.home.lissoviy.lecture6.repositories;

import org.home.lissoviy.lecture6.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Standard book repository.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
