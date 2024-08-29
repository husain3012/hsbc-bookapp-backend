package com.microservice.empservice1.restcontroller;


import com.microservice.empservice1.empdao.BookDaoRepo;
import com.microservice.empservice1.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("bookrest")
@RestController
public class BookRestController {
    Logger logger = LoggerFactory.getLogger(BookRestController.class);
    @Autowired
    private BookDaoRepo bookdao;

    @GetMapping("books")
    public List<Book> getAllBooks()
    {
        logger.error("inside getAllBooks of Book Contoller");
        return this.bookdao.findAll().subList(0,100);
    }


    @GetMapping("book/{bookid}")
    public Book getBookById(@PathVariable int bookid)
    {

        logger.error("inside getBookById of Book Contoller, bookid:"+bookid);
        return this.bookdao.findById(bookid).orElse(null);
    }



    @PostMapping("book")
    public Book postBook(@RequestBody Book b)
    {
        logger.error("inside postBook, book:"+b);
        return this.bookdao.save(b);
    }

    @PutMapping("book")
    public Book updateBook(@RequestBody Book b)
    {
        Optional<Book> op = this.bookdao.findById(b.getBookId());

        if(op.isPresent()){
            logger.error("inside updateBook, book:"+b);
            return this.bookdao.save(b);
        }
        else
        {
            logger.error("inside updateBook, book not found");
            return null;
        }


    }

    @DeleteMapping("book/{bookid}")
    public void deleteBook(@PathVariable  int bookid)
    {
        logger.error("inside deleteBook of Book Contoller");
        this.bookdao.deleteById(bookid);
    }





}
