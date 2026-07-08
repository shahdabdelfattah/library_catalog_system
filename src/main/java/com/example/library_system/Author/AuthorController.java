package com.example.library_system.Author;

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
    public Author Create(
            @RequestBody Author author
    ){
        return authorService.Create(author);
    }

    @GetMapping("/authors/{id}")
    public Author findAuthorByID(
            @PathVariable Integer id
    ){
        return authorService.findByID(id);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(
            @PathVariable Integer id,
            @RequestBody Author updatedAuthor
    ){
        return authorService.Update(id,updatedAuthor);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(
            @PathVariable Integer id
    ){
        authorService.Delete(id);
    }

}
