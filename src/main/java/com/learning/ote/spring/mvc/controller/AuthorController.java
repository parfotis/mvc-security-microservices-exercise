package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.domain.dto.AuthorDTO;
import com.learning.ote.spring.mvc.domain.enumerator.Category;
import com.learning.ote.spring.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    private static final String AUTHORS_TEMPLATE = "/author/authors";
    private static final String CREATE_AUTHOR_TEMPLATE = "/author/createAuthor";

    private static final String AUTHORS_ATTR = "authors";
    private static final String AUTHOR_ATTR = "authorForm";

    private static final String AUTHORS_URL = "/authors";

    @Autowired
    AuthorService authorService;

    @GetMapping(value = "/authors")
    public String findAll(Model model) {
        List<AuthorDTO> authorList = authorService.findAll();
        model.addAttribute(AUTHORS_ATTR, authorList);

        return AUTHORS_TEMPLATE;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/authors/{id}/delete")
    public String delete(@PathVariable("id") Long authorId) {
        authorService.deleteById(authorId);

        return redirect(AUTHORS_URL);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/authors/create")
    public String showCreateView(Model model) {
        model.addAttribute(AUTHOR_ATTR, new AuthorDTO());

        return CREATE_AUTHOR_TEMPLATE;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/authors")
    public String createOrUpdate(@ModelAttribute(AUTHOR_ATTR) @Valid AuthorDTO authorDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(AUTHOR_ATTR, authorDTO);

            return CREATE_AUTHOR_TEMPLATE;
        }
        // TODO: Remove this and add all information to UI as a drop down
        //bookDTO.setCategory(Category.COMEDY.name());
        //bookDTO.setAuthorId(1L);

        authorService.save(authorDTO);

        return redirect(AUTHORS_URL);
    }

    private String redirect(String uri) {
        return String.format("redirect:%s", uri);
    }
}
