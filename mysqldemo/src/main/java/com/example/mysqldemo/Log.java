package com.example.mysqldemo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Log {
    Long id;
    Long uid;
    Long credits;
    Long balance;
}
