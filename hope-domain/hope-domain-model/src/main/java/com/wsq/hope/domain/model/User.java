package com.wsq.hope.domain.model;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private int age;
    private int chinese;
    private int maths;
    private int english;
    private int total;
}
