package com.example.library_system.controller;

import com.example.library_system.dto.BookRequestDTO;
import com.example.library_system.dto.BookResponseDTO;
import com.example.library_system.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDTO addBook(
            @Valid @RequestBody BookRequestDTO book
    ){
        return bookService.create(book);
    }

    @GetMapping("/books")
    public List<BookResponseDTO> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{book_id}")
    public BookResponseDTO getBookById(
            @PathVariable Integer book_id
    ){
        return bookService.getByID(book_id);
    }

    @GetMapping("/authors/{author_id}/books")
    public List<BookResponseDTO> getBookByAuthorId(
            @PathVariable Integer author_id
    ){
        return bookService.getBooksByAuthor(author_id);
    }

    @PutMapping("/books/{book_id}")
    public BookResponseDTO updateBook(
            @PathVariable Integer book_id,
            @Valid @RequestBody BookRequestDTO updatedBook
    ){
        return bookService.update(book_id, updatedBook);
    }

    @DeleteMapping("/books/{book_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(
            @PathVariable Integer book_id
    ){
        bookService.delete(book_id);
    }
}
