package com.example.library_system.Author;

import com.example.library_system.Book.BookMapper;
import com.example.library_system.Book.BookSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorMapper {

    private final BookMapper bookMapper;

    public AuthorMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Author toAuthor(AuthorRequestDTO dto){
        Author author = new Author();
        author.setName(dto.name());
        author.setBirthDate(dto.birthDate());
        return author;
    }

    public AuthorResponseDTO toResponseDTO(Author author) {
        List<BookSummaryDTO> books = author.getBooks()
                .stream()
                .map(bookMapper::toSummaryDTO)
                .toList();

        return new AuthorResponseDTO(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                books
        );    }
}
