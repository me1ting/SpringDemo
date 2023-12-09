package com.example.mysqldemo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    private Long id;
    private Long credit;
}