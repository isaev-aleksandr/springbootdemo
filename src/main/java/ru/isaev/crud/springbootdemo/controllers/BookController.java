package ru.isaev.crud.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.isaev.crud.springbootdemo.model.Book;
import ru.isaev.crud.springbootdemo.service.BookService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";

    }

    @PostMapping
    public String createBook (Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
