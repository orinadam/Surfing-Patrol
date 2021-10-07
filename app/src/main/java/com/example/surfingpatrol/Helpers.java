package com.example.surfingpatrol;

public class Helpers {
    public static String generateId(String username) {
        String id = "";
        for (int i = 0; i < username.length(); i++) {
            id += "" + ((int) username.charAt(i));

        }
        return id;
    }
}
