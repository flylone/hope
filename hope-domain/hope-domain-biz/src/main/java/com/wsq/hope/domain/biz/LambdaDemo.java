package com.wsq.hope.domain.biz;

import com.wsq.hope.domain.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LambdaDemo {

    public static void main(String[] args) {
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            User u = new User();
//            u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//            u.setName("name" + i + 1);
//            u.setAge(30 + i);
//            u.setChinese(50 + (i + 9) * 2 / 3);
//            u.setMaths(60 + (i + 13) * 3 / 4);
//            u.setEnglish(50 + (i + 7) * 4 / 5);
//            users.add(u);
//        }
//        users.forEach(System.out::println);
//        System.out.println("------------------------------------------------------------------");
//
//        users = users.stream().map(u -> {
//            u.setId(u.getId().toUpperCase());
//            return u;
//        }).collect(Collectors.toList());
//        users.forEach(System.out::println);
//
//        users.forEach(System.out::println);
//
//        System.out.println("------------------------------------------------------------------");
//        users = users.stream().filter(u -> u.getAge() < 35).collect(Collectors.toList());
//        users.forEach(System.out::println);
//
//        System.out.println("------------------------------------------------------------------");
//        List<Integer> list = new ArrayList<>();
//        list.add(Integer.MAX_VALUE);
//        list.add(Integer.MAX_VALUE - 10);
//        list.add(Integer.MAX_VALUE - 20);
//        list.hashCode();
        int[] a = {Integer.MAX_VALUE, Integer.MAX_VALUE - 10, Integer.MAX_VALUE - 20, Integer.MAX_VALUE - 30};
        int hashCode = Arrays.hashCode(a);
        int code = a.hashCode();
    }
}
