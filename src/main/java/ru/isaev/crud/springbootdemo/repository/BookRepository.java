package ru.isaev.crud.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.isaev.crud.springbootdemo.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Short> {

    List<Book> findAllByBookNameOrGenreOrAuthor(String bookName, String genre, String authot);
}
