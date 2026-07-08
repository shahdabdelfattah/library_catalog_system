package com.example.library_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "Title is required")
        String title,

        String genre,

        @NotNull(message = "Publish date is required")
        LocalDate publishDate,

        @NotNull(message = "Author ID is required")
        Integer authorId
) { }
