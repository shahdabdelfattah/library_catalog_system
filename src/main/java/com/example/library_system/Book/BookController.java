package com.example.library_system.Book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book createBook(
            @RequestBody Book book
    ){
        return bookService.Create(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{book_id}")
    public Book getBookById(
            @PathVariable Integer book_id
    ){
        return bookService.getByID(book_id);
    }

    @GetMapping("/books/author/{author_id}")
    public List<Book> getBookByAuthorId(
            @PathVariable Integer author_id
    ){
        return bookService.getBooksByAuthor(author_id);
    }

    @PutMapping("/books/{book_id}")
    public Book updateBook(
            @PathVariable Integer book_id,
            @RequestBody Book updatedBook
    ){
        return bookService.Update(book_id, updatedBook);
    }

    @DeleteMapping("/books/{book_id}")
    public void deleteBook(
            @PathVariable Integer book_id
    ){
        bookService.Delete(book_id);
    }
}
