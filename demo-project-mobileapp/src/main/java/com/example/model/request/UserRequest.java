package com.example.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotNull(message = "Userd should not be null")
    public String userId;
    @NotNull(message = "email  should not be null and it should be valid")
    @Email
    public String email;
    @NotNull(message = "Name  should not be null")
    public String name;

    @Size(min = 4, max = 8, message = "Password must be equal to or greater than 4 characters and less than 8 characters")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
