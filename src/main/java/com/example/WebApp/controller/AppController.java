package com.example.WebApp.controller;

import com.example.WebApp.dao.BookRepo;
import com.example.WebApp.dao.StudentRepo;
import com.example.WebApp.model.Book;
import com.example.WebApp.model.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

    @Autowired
    BookRepo repo;
    @Autowired
    StudentRepo repo1;


    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book){
        System.out.println("in saveBook");
        System.out.println(book.getBid());
        if(!repo.findById(book.getBid()).isPresent()) {
            repo.save(book);
            return "Book saved";
        }
        return "Book already present";
    }

    @GetMapping("/getAll")
    public String getAllBooks(){
        System.out.println("in get All");
        List<Book> bookList = repo.findAll();
        //System.out.println(bookList);
        //System.out.println(bookJson);
//        return "{\"books\":" + bookJson + "}";
        return new Gson().toJson(bookList);
    }

    @GetMapping("/getBook/{bid}")
    public Object getBook(@PathVariable int bid){
        //System.out.println(repo.findById(bid));
        System.out.println("in GetBook");
        if(repo.findById(bid).isPresent()) {
            return repo.findById(bid);
        }
        return "Enter valid Book ID";
    }

    @PutMapping("/updateBook/{bid}/{availability}")
    public String updateBook(@PathVariable int bid, @PathVariable String availability){
        System.out.println("In Update " + bid + availability);
        if(repo.findById(bid).isPresent()) {
            repo.setFixedAvailabilityFor(bid, availability);
//            System.out.println(repo.findById(1));
            return new Gson().toJson(repo.findAll());
        }
        return "Book is not available. Create a new Book";
    }

    @DeleteMapping("/deleteBook/{bid}")
    public String deleteBook(@PathVariable int bid){
        try {
            System.out.println("in delete "+ bid);
            repo.deleteById(bid);
        }
        catch (EmptyResultDataAccessException e)
        {
            return "Book is not available";
        }
        return new Gson().toJson(repo.findAll());
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student){
        //System.out.println("hello");
        repo1.save(student);
        return "/main/webapp/index.html";
    }
}
