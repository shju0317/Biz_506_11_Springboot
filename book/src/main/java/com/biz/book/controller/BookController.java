package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public List<BookVO> getList(Model model){
        List<BookVO> bookList = bookService.selectAll();
        model.addAttribute("BOOKS", bookList);

        String[] car = new String[]{"소나타","그랜저","페라리","람보르기니"};
        model.addAttribute("CAR", car);


        return "book/list";
    }
}
