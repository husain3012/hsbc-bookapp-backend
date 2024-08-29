package com.microservice.empservice1.empdao;

import com.microservice.empservice1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDaoRepo extends JpaRepository<Book,Integer> {
    public Optional<Book> findByBookName(String bookName);
    public Optional<Book> findByBookNameAndBookPrice(String bookName, double bookPrice);
}
