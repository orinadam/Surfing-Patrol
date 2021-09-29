package com.example.surfingpatrol;

public class User {
    String name, username, email, password;

    public User(){

    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String generateId(){
        String id = "";
        for(int i = 0; i < username.length(); i++) {
            id += "" + ((int)username.charAt(i));

        }
        return id;
    }
}
