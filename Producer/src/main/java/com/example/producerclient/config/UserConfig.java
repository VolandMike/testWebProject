package com.example.producerclient.config;

import com.example.producerclient.dto.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

@Configuration
public class UserConfig {
    @Value("${filename}")
    private String csvPath;
    @Getter
    List<User> userListFromCsv;


    @Bean
    void loadUsers() {

        try (Reader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(UserConfig
                        .class.getClassLoader().getResourceAsStream(csvPath))))) {

            // create csv bean reader
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            userListFromCsv = csvToBean.parse();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
