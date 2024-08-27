package org.home.lissoviy.lecture6.services.impl;

import lombok.RequiredArgsConstructor;
import org.home.lissoviy.lecture6.models.Book;
import org.home.lissoviy.lecture6.repositories.BookRepository;
import org.home.lissoviy.lecture6.services.BookService;
import org.springframework.stereotype.Service;

/**
 * Book service implementation.
 */
@Service
@RequiredArgsConstructor()
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  @Override
  public Iterable<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book getBookById(long id) {
    return bookRepository.findById(id).orElseThrow();
  }

  @Override
  public void createBook(Book book) {
    bookRepository.save(book);
  }

  @Override
  public void updateBook(long id, Book book) {
    if (bookRepository.findById(id).isPresent()) {
      bookRepository.save(book);
    }
  }

  @Override
  public void deleteBook(long id) {
    bookRepository.deleteById(id);
  }
}
