package com.re.org.controller;

import com.re.org.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {
    private List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book(1, "Doraemon", "Hello", 2000),
                    new Book(2, "Shin", "Hihi", 2400),
                    new Book(3, "Dragon Ball", "Haha", 3000),
                    new Book(4, "OnePiece", "HoHo", 3200),
                    new Book(5, "Doraemon phần 2", "Hello", 2000)

            )
    );

    @GetMapping({"", "/books"})
    public String findAll(Model model) {
        model.addAttribute("book", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String detaileBook(
            @PathVariable("id") int id, Model model
    ) {
        Book targetBook = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("detail", targetBook);
        return "books-detail";
    }
}
