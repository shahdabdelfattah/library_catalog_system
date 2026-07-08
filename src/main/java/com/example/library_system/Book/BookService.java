package com.example.library_system.Book;

import com.example.library_system.Author.Author;
import com.example.library_system.Author.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
    }

    public Book Create(Book book){
        return bookRepository.save(book);
    }

    public Book getByID(Integer id){
        return bookRepository.findById(id)
                .orElse(null);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(Integer authorId){
        return bookRepository.findByAuthorId(authorId);
    }
    public Book Update(Integer id, Book updatedBook){
        Book book = getByID(id);
        book.setTitle(updatedBook.getTitle());
        book.setGenre(updatedBook.getGenre());
        book.setPublishDate(updatedBook.getPublishDate());
        book.setAuthor(updatedBook.getAuthor());

        return bookRepository.save(book);
    }
    public void Delete(Integer id){
        bookRepository.deleteById(id);
    }

}
