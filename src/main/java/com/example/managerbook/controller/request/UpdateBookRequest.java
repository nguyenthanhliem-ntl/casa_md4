package com.example.managerbook.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {
    private Integer id;
    private String title;
    private String author;
}
