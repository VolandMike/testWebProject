package com.example.producerclient.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class User {
    @CsvBindByName
    private String username;
    @CsvBindByName
    private String firstname;
    @CsvBindByName
    private String lastname;
    @CsvBindByName
    private String password;
}
