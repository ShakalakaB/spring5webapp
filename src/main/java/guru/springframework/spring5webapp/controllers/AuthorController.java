package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthroRepository authroRepository;

    public AuthorController(AuthroRepository authroRepository) {
        this.authroRepository = authroRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authroRepository.findAll());

        return "authors/list";
    }
}
