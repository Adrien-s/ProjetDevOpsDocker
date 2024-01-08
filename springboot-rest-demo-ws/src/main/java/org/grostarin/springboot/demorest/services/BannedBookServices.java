package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.repositories.BookRepository;
import org.grostarin.springboot.demorest.repositories.BannedBookRepository;
import org.grostarin.springboot.demorest.exceptions.BookIsBannedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannedBookServices {    

    @Autowired
    private BookRepository bookRepository;
    private BannedBookRepository bannedBookRepository;

    public boolean isBookBanned(String title, String author) {
        return bannedBookRepository.findByTitleAndAuthor(title, author).isPresent();
    }

    public Book create(Book book) throws BookIsBannedException {
        if(isBookBanned(book.getTitle(), book.getAuthor())) {
            throw new BookIsBannedException("This book is banned and cannot be added.");
        }
        return bookRepository.save(book);   
    }
}
