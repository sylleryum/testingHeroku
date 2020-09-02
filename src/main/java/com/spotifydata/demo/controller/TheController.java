package com.spotifydata.demo.controller;

import com.spotifydata.demo.entities.Book;
import com.spotifydata.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("test", bookRepository.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String add(){
        bookRepository.save(new Book("tester"));
        bookRepository.save(new Book("tester1"));
        bookRepository.save(new Book("tester2"));
        return "redirect:/";
    }
}
