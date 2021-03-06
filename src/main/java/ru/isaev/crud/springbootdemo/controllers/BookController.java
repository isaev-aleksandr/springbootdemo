package ru.isaev.crud.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("bookSearch", new Book());
        return "book-list";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";

    }

    @PostMapping("/book-create")
    public String createBook (Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") Short id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Short id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book-search")
    public String searchBook(@RequestParam("bookName") String request, Book book, Model model){
        if (request == "") {
            return "redirect:/books";
        }
        List<Book> sought = bookService.findAllByBookNameOrGenreOrAuthor(request);
               model.addAttribute("booksSearch", sought);
        model.addAttribute("bookSearch", new Book());
        return "book-search";
    }
}

