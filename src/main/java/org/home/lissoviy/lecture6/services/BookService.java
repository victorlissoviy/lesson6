package org.home.lissoviy.lecture6.services;

import org.home.lissoviy.lecture6.models.Book;

/**
 * Book service.
 */
public interface BookService {
  /**
   * Get all books from database.
   *
   * @return all books
   */
  Iterable<Book> getAllBooks();

  /**
   * Get book by ID.
   *
   * @param id id book.
   * @return founded book.
   */
  Book getBookById(long id);

  /**
   * Add book to database.
   *
   * @param book added book.
   */
  void createBook(Book book);

  /**
   * Update existing book.
   *
   * @param id id book.
   * @param book book to update.
   */
  void updateBook(long id, Book book);

  /**
   * Delete book by id.
   *
   * @param id id book.
   */
  void deleteBook(long id);
}
