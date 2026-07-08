package com.example.library_system.Author;

import com.example.library_system.Book.BookSummaryDTO;

import java.time.LocalDate;
import java.util.List;

public record AuthorResponseDTO(
        Integer id,
        String name,
        LocalDate birthDate,
        List<BookSummaryDTO> books
) { }
