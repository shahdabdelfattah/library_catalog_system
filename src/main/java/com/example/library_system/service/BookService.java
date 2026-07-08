package com.example.library_system.service;

import com.example.library_system.entity.Author;
import com.example.library_system.repository.AuthorRepository;
import com.example.library_system.entity.Book;
import com.example.library_system.mapper.BookMapper;
import com.example.library_system.dto.BookRequestDTO;
import com.example.library_system.dto.BookResponseDTO;
import com.example.library_system.exception.ResourceNotFoundException;
import com.example.library_system.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
    }

    public BookResponseDTO create(BookRequestDTO dto){
        Book book = bookMapper.toBook(dto);

        Author author = authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new ResourceNotFoundException("No Author found with id: " + dto.authorId()));

        book.setAuthor(author);

        bookRepository.save(book);
        return bookMapper.toResponseDTO(book);
    }

    public List<BookResponseDTO> getBooks(){
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO getByID(Integer id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Book found with id: " + id));
        return bookMapper.toResponseDTO(book);
    }

    public List<BookResponseDTO> getBooksByAuthor(Integer authorId){
        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(bookMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    public BookResponseDTO update(Integer id, BookRequestDTO updatedBook){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Book found with id: " + id));

        book.setTitle(updatedBook.title());
        book.setGenre(updatedBook.genre());
        book.setPublishDate(updatedBook.publishDate());

        Author author = authorRepository.findById(updatedBook.authorId())
                .orElseThrow(() -> new ResourceNotFoundException("No Author found with id: " + updatedBook.authorId()));

        book.setAuthor(author);

        bookRepository.save(book);

        return bookMapper.toResponseDTO(book);
    }
    public void delete(Integer id){

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Book found with id: " + id));

        bookRepository.delete(book);
    }

}
