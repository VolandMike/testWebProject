package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Greetings {
    private final long id;
    private final String content;

}