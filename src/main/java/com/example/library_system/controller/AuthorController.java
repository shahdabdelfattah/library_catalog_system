package com.example.library_system.controller;

import com.example.library_system.dto.AuthorRequestDTO;
import com.example.library_system.dto.AuthorResponseDTO;
import com.example.library_system.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO addAuthor(
            @Valid @RequestBody AuthorRequestDTO author
    ){
        return authorService.create(author);
    }

    @GetMapping("/authors/{id}")
    public AuthorResponseDTO findAuthorByID(
            @PathVariable Integer id
    ){
        return authorService.findById(id);
    }

    @GetMapping("/authors")
    public List<AuthorResponseDTO> getAuthors(){
        return authorService.getAuthors();
    }

    @PutMapping("/authors/{id}")
    public AuthorResponseDTO updateAuthor(
            @PathVariable Integer id,
            @Valid @RequestBody AuthorRequestDTO updatedAuthor
    ){
        return authorService.update(id,updatedAuthor);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(
            @PathVariable Integer id
    ){
        authorService.delete(id);
    }

}
