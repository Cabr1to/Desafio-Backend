package com.sea.desafio.controller;

import com.sea.desafio.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {


    @GetMapping
    public List<User> getUsers() {
        return List.of(
                new User(
                        1,
                        "Luis",
                        "000.000.000-22",
                        "Brasilia",
                        "10101010",
                        "luis@gmail.com"

                ),
                new User(
                        2,
                        "Luisa",
                        "000.000.111-33",
                        "Rio de Janeiro",
                        "12121212",
                        "luisa@gmail.com"
                )
        );
    }
}
