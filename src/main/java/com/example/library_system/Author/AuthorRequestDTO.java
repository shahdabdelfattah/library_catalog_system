package com.example.library_system.Author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AuthorRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @Past(message = "Birth date must be in the past")
        LocalDate birthDate
) { }
