package com.example.managerbook.controller.response;

import com.example.managerbook.entity.BookEntity;
import com.example.managerbook.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookListResponse {
    private Integer code;
    private String message;
    private List<BookEntity> data;

    public void setData(List<BookEntity> data) {
    }
}

