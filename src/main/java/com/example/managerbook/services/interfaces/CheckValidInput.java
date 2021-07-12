package com.example.managerbook.services.interfaces;

public interface CheckValidInput {
    int checkEmail(String email);
    int checkPassword(String password);
    int checkPhone(String phone);
}
