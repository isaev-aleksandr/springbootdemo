package ru.isaev.crud.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isaev.crud.springbootdemo.model.Book;

public interface BookRepository extends JpaRepository<Book, Short> {
}
