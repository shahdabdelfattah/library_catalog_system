package com.example.library_system.Author;

import com.example.library_system.exception.DuplicateResourceException;
import com.example.library_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponseDTO create(AuthorRequestDTO dto){
//        dto -> entity -> function -> ret responseDto
        if (authorRepository.existsByNameIgnoreCase(dto.name())) {
            throw new DuplicateResourceException("Author " + dto.name() + " already exists");
        }
        Author author = authorMapper.toAuthor(dto);
        Author saved = authorRepository.save(author);
        return authorMapper.toResponseDTO(saved);
    }

    public AuthorResponseDTO findById(Integer id){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Author found with id: " + id));
        return authorMapper.toResponseDTO(author);
    }

    public List<AuthorResponseDTO> getAuthors(){
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AuthorResponseDTO update(Integer id, AuthorRequestDTO updatedAuthor
    ){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Author found with id: " + id));

        author.setName(updatedAuthor.name());
        author.setBirthDate(updatedAuthor.birthDate());

        authorRepository.save(author);

        return authorMapper.toResponseDTO(author);
    }

    public void delete(Integer id){
        authorRepository.deleteById(id);
    }
}
