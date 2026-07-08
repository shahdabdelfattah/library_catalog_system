package com.example.library_system.Book;

import com.example.library_system.Author.Author;
import com.example.library_system.Author.AuthorRepository;
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

        Author author = authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new ResourceNotFoundException("No Author found with id: " + dto.authorId()));

        book.setAuthor(author);

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
