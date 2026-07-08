package com.example.library_system.Author;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author Create(Author author){
        return authorRepository.save(author);
    }

    public Author findByID(Integer id){
        return authorRepository.findById(id)
                .orElse(new Author());
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author Update(Integer id, Author updatedAuthor
    ){
        var author = findByID(id);
        author.setName(updatedAuthor.getName());
        author.setAge(updatedAuthor.getAge());
        return authorRepository.save(author);
    }

    public void Delete(Integer id){
        authorRepository.deleteById(id);
    }
}
