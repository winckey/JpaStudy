package Dto;

import lombok.*;

@Getter
@Setter
public class User{

    Long id;

    String email;

    String position;

    String department;

    String name;

    String password;



    public User() {

    }

    public User(String email, String position, String department, String name, String password) {
        this.email = email;
        this.position = position;
        this.department = department;
        this.name = name;
        this.password = password;

    }
}
