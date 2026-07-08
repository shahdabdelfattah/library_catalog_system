package com.example.library_system.dto;

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
