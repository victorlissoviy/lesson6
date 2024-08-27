package org.home.lissoviy.lecture6.services;

import org.home.lissoviy.lecture6.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@ActiveProfiles("test")
@SpringBootTest
class BookServiceTest {

  @Autowired
  private BookService bookService;

  @Test
  void getAllBooks() {
    Book book1 = Book.builder()
        .id(1L)
        .price(123.2)
        .title("Title")
        .author("Author 1")
        .build();

    Book book2 = Book.builder()
        .id(2L)
        .price(125.2)
        .title("Title 2")
        .author("Author 2")
        .build();

    bookService.createBook(book1);
    bookService.createBook(book2);

    Iterable<Book> books = bookService.getAllBooks();
    Iterator<Book> bookIterator = books.iterator();

    Book firstBook = bookIterator.next();
    assertEquals("Title", firstBook.getTitle());
    assertEquals("Author 1", firstBook.getAuthor());
    assertEquals(123.2, firstBook.getPrice());

    Book secondBook = bookIterator.next();
    assertEquals("Title 2", secondBook.getTitle());
    assertEquals("Author 2", secondBook.getAuthor());
    assertEquals(125.2, secondBook.getPrice());
  }

  @Test
  void getBookById() {
    Book book = Book.builder()
        .price(123.2)
        .title("Title 10")
        .author("Author 10")
        .build();

    bookService.createBook(book);
    Book bookById = bookService.getBookById(book.getId());
    assertEquals("Title 10", bookById.getTitle());
  }

  @Test
  void getBookByIdWrong() {
    Book book = Book.builder()
        .price(123.2)
        .title("Title 20")
        .author("Author 20")
        .build();

    bookService.createBook(book);
    assertThrowsExactly(NoSuchElementException.class, () -> bookService.getBookById(-1L));
  }

  @Test
  void updateBook() {
    Book book = Book.builder()
        .price(123.2)
        .title("Title 5")
        .author("Author 5")
        .build();

    bookService.createBook(book);

    Book bookById = bookService.getBookById(book.getId());
    assertEquals("Title 5", bookById.getTitle());
    assertEquals("Author 5", bookById.getAuthor());
    assertEquals(123.2, bookById.getPrice());

    book.setTitle("New Title");
    book.setAuthor("New Author");
    book.setPrice(321.8);

    bookService.updateBook(bookById.getId(), book);
    bookById = bookService.getBookById(book.getId());

    assertEquals("New Title", bookById.getTitle());
    assertEquals("New Author", bookById.getAuthor());
    assertEquals(321.8, bookById.getPrice());
  }

  @Test
  void deleteBook() {
    Book book = Book.builder()
        .price(123.2)
        .title("Title 5")
        .author("Author 5")
        .build();

    bookService.createBook(book);

    bookService.deleteBook(book.getId());

    assertThrowsExactly(NoSuchElementException.class, () -> bookService.getBookById(book.getId()));
  }

}