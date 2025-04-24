package com.sea.desafio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String cpf;
    private String address;
    private String phone;
    private String email;
    private boolean admin;


    public User() {
    }

    public User(Integer id, String name, String cpf, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.admin = false;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(cpf, user.cpf) && Objects.equals(address, user.address) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, address, phone, email);
    }
}
