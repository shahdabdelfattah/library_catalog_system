package com.example.library_system.dto;

import java.time.LocalDate;
import java.util.List;

public record AuthorResponseDTO(
        Integer id,
        String name,
        LocalDate birthDate,
        List<BookSummaryDTO> books
) { }
