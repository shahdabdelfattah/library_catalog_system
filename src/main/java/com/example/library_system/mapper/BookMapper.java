package com.example.library_system.mapper;

import com.example.library_system.entity.Author;
import com.example.library_system.repository.AuthorRepository;
import com.example.library_system.entity.Book;
import com.example.library_system.dto.BookRequestDTO;
import com.example.library_system.dto.BookResponseDTO;
import com.example.library_system.dto.BookSummaryDTO;
import com.example.library_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    private final AuthorRepository authorRepository;

    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Book toBook(BookRequestDTO dto){
        Book book = new Book();
        book.setTitle(dto.title());
        book.setGenre(dto.genre());
        book.setPublishDate(dto.publishDate());

        return book;
    }

    public BookResponseDTO toResponseDTO(Book book){
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getGenre(),
                book.getPublishDate(),
                book.getAuthor().getId(),
                book.getAuthor().getName()
        );
    }

    public BookSummaryDTO toSummaryDTO(Book book){
        return new BookSummaryDTO(
                book.getId(),
                book.getTitle()
        );
    }
}
