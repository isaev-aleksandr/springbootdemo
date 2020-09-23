package ru.isaev.crud.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isaev.crud.springbootdemo.model.Book;
import ru.isaev.crud.springbootdemo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById (Short id){
        return bookRepository.getOne(id);
    }

    public List<Book> findAll (){
        return bookRepository.findAll();
    }

    public Book saveBook (Book book){
        return bookRepository.save(book);
    }

    public void deleteById(Short id){
        bookRepository.deleteById(id);
    }
}