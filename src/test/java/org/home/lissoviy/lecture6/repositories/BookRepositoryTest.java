package org.home.lissoviy.lecture6.repositories;

import org.home.lissoviy.lecture6.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Test
  void findAll() {
    Book book1 = new Book(1L, "Title 1", "Author 1", 123.0);

    Book savedBook = bookRepository.save(book1);

    Optional<Book> optionalBook1 = bookRepository.findById(savedBook.getId());

    assertTrue(optionalBook1.isPresent());
  }
}