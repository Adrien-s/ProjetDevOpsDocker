package org.grostarin.springboot.demorest.controllers;

import javax.validation.Valid;

import org.grostarin.springboot.demorest.annotations.LogExecutionTime;
import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.services.BannedBookServices;
import org.grostarin.springboot.demorest.exceptions.BookIsBannedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BannedBookController {

    private final BannedBookServices bannedBookServices;

    @Autowired
    public BannedBookController(BannedBookServices bannedBookServices) {
        this.bannedBookServices = bannedBookServices;
    }

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        try {
            Book savedBook = bannedBookServices.create(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (BookIsBannedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(BookIsBannedException.class)
    public ResponseEntity<?> handleBookIsBannedException(BookIsBannedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
