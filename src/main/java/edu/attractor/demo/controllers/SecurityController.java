package edu.attractor.demo.controllers;


import edu.attractor.demo.entities.User;
import edu.attractor.demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/sign-in")
    String signIn() {
        return "login/login";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    @GetMapping("/sign-up")
    String signUpPage(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "login/register";
    }

    @PostMapping("/sign-up")
    String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                  RedirectAttributes attributes) {

        attributes.addFlashAttribute("user", user);
        if (bindingResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "login/login";
        }

        User savedUsed = userService.signUpUser(user);


        return "redirect:/sign-in";
    }


}
