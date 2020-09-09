package com.learning.ote.spring.mvc.converter;

import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.entity.AuthorEntity;

public class AuthorConverter {

    public static AuthorDTO convert(AuthorEntity author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setFirstName(author.getFirstName());

        return authorDTO;
    }

    public static AuthorEntity convert(AuthorDTO authorDTO) {
        AuthorEntity author = new AuthorEntity();
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());

        return author;
    }
}
