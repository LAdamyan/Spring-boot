package com.epam.springboot.controller;

import com.epam.springboot.model.Author;
import com.epam.springboot.model.Book;
import com.epam.springboot.repository.AuthorRepository;
import com.epam.springboot.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public UserController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);

     /*   Author author = new Author();
        author.setName("Lilit");
        author.setSurname("Adamyan");
        author.setAge(20);

        authorRepository.save(author);*/

       /* Book book = bookRepository.getById(3);
        model.addAttribute("book",book);*/

        Author author = authorRepository.findById(1).orElseThrow(RuntimeException::new);
        List<Book> books = author.getBooks();
        model.addAttribute("books",books);


      /*  Book book = new Book();
        Author author1 = authorRepository.findById(1).orElseThrow(RuntimeException::new);
        book.setAuthor(author1);
        book.setPrice("7000");
        book.setBookName("Samvel");
        bookRepository.save(book);*/

        return "user";
    }
}