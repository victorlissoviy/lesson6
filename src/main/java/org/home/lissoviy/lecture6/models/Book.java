package org.home.lissoviy.lecture6.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Main model.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

  /**
   * Book identification
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Name book.
   */
  @Column(nullable = false)
  private String title;

  /**
   * Author book.
   */
  @Column(nullable = false)
  private String author;

  /**
   * Price book.
   */
  @Column(nullable = false)
  private Double price;
}
