package com.spotifydata.demo;

import com.spotifydata.demo.entities.Book;
import com.spotifydata.demo.repositories.BookRepository;
import com.spotifydata.demo.services.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceUnitTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void jpaHibernate() {
        bookRepository.save(new Book("tester"));
        bookRepository.save(new Book("tester1"));
        bookRepository.save(new Book("tester2"));

        List<Book> books = bookService.list();

        //Assert.assertEquals(books.size(), 3);
        System.out.println("--ok "+bookRepository.findAll());
    }
}