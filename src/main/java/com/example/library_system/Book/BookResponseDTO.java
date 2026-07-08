package com.example.library_system.Book;

import java.time.LocalDate;

public record BookResponseDTO(
        Integer id,
        String title,
        String genre,
        LocalDate publishDate,
        Integer authorId,
        String authorName
) {
}
