package com.example.managerbook.controller;

import com.example.managerbook.controller.request.AddBookRequest;
import com.example.managerbook.controller.request.UpdateBookRequest;
import com.example.managerbook.controller.response.BookListResponse;
import com.example.managerbook.entity.BookEntity;
import com.example.managerbook.repository.BookRepository;
import com.example.managerbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookRepository repository;


    @GetMapping(value = "/{category_id}")
    public BookListResponse getBookByCategoryID(@PathVariable(name = "category_id") Integer cateId,
                                                @RequestParam(name = "order", defaultValue = "ASC") String order,
                                                @RequestParam(name = "orderBy", defaultValue = "title") String orderBy,
                                                @RequestParam(name = "pageNum") Integer pageNum){
        return bookService.getBookByCategoryID(cateId, order, orderBy,pageNum);
    }
    @PostMapping(value = "/addBook")
    public BookEntity addBook(@RequestBody AddBookRequest bookRequest){
        BookEntity entity = new BookEntity();
        entity.setTitle(bookRequest.getTitle());
        entity.setAuthor(bookRequest.getAuthor());
        entity.setCategoryId(bookRequest.getCategoryId());
        return entity;
    }
    @PostMapping(value = "/addList")
    public List<BookEntity> addListBook(@RequestBody List<AddBookRequest> requests){
        return bookService.addListBook(requests);
    }
    @PutMapping(value = "/update")
    public BookEntity updateBook(@RequestBody UpdateBookRequest request){
        return bookService.updateBook(request);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Integer id){
        return bookService.deleteBook(id);
    }
}
